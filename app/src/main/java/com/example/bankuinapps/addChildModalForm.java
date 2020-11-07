package com.example.bankuinapps;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.bankuinapps.Model.childrenData;
import com.example.bankuinapps.Model.kidData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class addChildModalForm extends AppCompatDialogFragment {

    private FirebaseAuth mAuth;
    private DatabaseReference mDBref;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uid = mUser.getUid();
        mDBref = FirebaseDatabase.getInstance().getReference().child("KidBankData").child(uid);


        AlertDialog.Builder mydialog = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myview = inflater.inflate(R.layout.addchildren, null);
        mydialog.setView(myview);
        AlertDialog dialog = mydialog.create();


        EditText nameedt = myview.findViewById(R.id.kidname_edt);
        EditText allowanceedt = myview.findViewById(R.id.allowance_edt);

        Button btnAddNewChild = myview.findViewById(R.id.btnSave);
        Button cancel = myview.findViewById(R.id.btnCancel);

        btnAddNewChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameedt.getText().toString().trim();
                String allowance = allowanceedt.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    nameedt.setError("Required Field..");
                    return;
                }

                if (TextUtils.isEmpty(allowance)) {
                    allowanceedt.setError("Required Field..");
                    return;
                }

                int allowanceint = Integer.parseInt(allowance);
                String id = mDBref.push().getKey();
                kidData data = new kidData(name, allowanceint, id);
                //childrenData data = new childrenData(name, id, allowanceint);
                mDBref.child(name).setValue(data);

                Toast.makeText(getActivity(), "Data ADDED", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
        return dialog;
    }
}
