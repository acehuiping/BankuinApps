package com.example.bankuinapps;

import android.app.AlertDialog;
import android.app.Dialog;
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
import com.example.bankuinapps.Model.expensesData;
import com.example.bankuinapps.Model.kidData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class addExpenseModalForm extends AppCompatDialogFragment {
    private FirebaseAuth mAuth;
    private DatabaseReference mDBref;
    childrenData data;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uid = mUser.getUid();
        FirebaseDatabase mydb =FirebaseDatabase.getInstance();
        DatabaseReference mDBref = mydb.getReference().child("KidBankData").child("Expense");


        AlertDialog.Builder mydialog = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myview = inflater.inflate(R.layout.addexpense, null);
        mydialog.setView(myview);
        AlertDialog dialog = mydialog.create();

        EditText categoryedt = myview.findViewById(R.id.category_edt);
        EditText amountedt = myview.findViewById(R.id.amount_edt);
        EditText noteedt = myview.findViewById(R.id.note_edt);

        Button btnSave = myview.findViewById(R.id.btnSave);
        Button cancel = myview.findViewById(R.id.btnCancel);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = categoryedt.getText().toString().trim();
                String amount = amountedt.getText().toString().trim();
                String note = noteedt.getText().toString().trim();

                if (TextUtils.isEmpty(category)) {
                    categoryedt.setError("Required Field..");
                    return;
                }

                if (TextUtils.isEmpty(amount)) {
                    amountedt.setError("Required Field..");
                    return;
                }

                int amountint = Integer.parseInt(amount);
                String id = mDBref.push().getKey();

                //childrenData data = new childrenData(name, id, allowanceint);

                //childrenData data = new childrenData();
                //mDBref.push().setValue(childrenData);

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
