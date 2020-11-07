package com.example.bankuinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildrenDetailsActivity extends AppCompatActivity {

    private Button addincome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_details);
        buttonfunction();
    }

    private void buttonfunction(){
        addincome = findViewById(R.id.btn_addincome);
        addincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

     void openDialog(){
         addExpenseModalForm form = new addExpenseModalForm();
         form.show(getSupportFragmentManager(), "Test Dialog");
     }
}