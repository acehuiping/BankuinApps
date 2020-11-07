package com.example.bankuinapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bankuinapps.Adapter.kidAdapter;
import com.example.bankuinapps.Model.kidData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChildrenBankActivity extends AppCompatActivity {

    private Button addnewkid;
    //Firebase DB
    private FirebaseAuth mAuth;
    private DatabaseReference mKidDB;
    RecyclerView recyclerView;
    kidAdapter kiddadapter;
    List<kidData> kiddata;
    private kidAdapter.RecyclerViewClickListner listner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_bank);

        recyclerView = findViewById(R.id.recycler_id_kid);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        kiddata = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uid = mUser.getUid();

        mKidDB = FirebaseDatabase.getInstance().getReference().child("KidBankData").child(uid);

        mKidDB.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    kidData data = ds.getValue(kidData.class);
                    kiddata.add(data);
                }
                setOnClickListner();
                kiddadapter = new kidAdapter(kiddata, listner);
                recyclerView.setAdapter(kiddadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        addnewkid = findViewById(R.id.btn_addnewchild);
        addnewkid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }


    public void openDialog(){
        addChildModalForm form = new addChildModalForm();
        form.show(getSupportFragmentManager(), "Test Dialog");
    }

    public void setOnClickListner(){
        listner = new kidAdapter.RecyclerViewClickListner() {
            @Override
            public void onClick(View v, int position) {
                startActivity(new Intent(getApplicationContext(), ChildrenDetailsActivity.class));
            }
        };
    }
}