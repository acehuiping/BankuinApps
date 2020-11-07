package com.example.bankuinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    private ImageView btnBank;
    //private ImageView btnEdu;
    //private ImageView btnGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonFunction();
    }

    private void buttonFunction(){

        btnBank = findViewById(R.id.btn_bank);
        //btnEdu = findViewById(R.id.btn_edu);
        //btnGame = findViewById(R.id.btn_game);

        btnBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChildrenBankActivity.class));
            }
        });

    }
}