package com.example.bankuinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class Eduction1 extends AppCompatActivity {

    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eduction1);

        viewFlipper = findViewById(R.id.view_flipper);
        TextView textView = new TextView(this);

        textView.setGravity(Gravity.CENTER);
        viewFlipper.addView(textView);
        viewFlipper.setFlipInterval(2000);
        //viewFlipper.startFlipping();
    }

    public void previousView(View v) {
        //viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        //viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
        viewFlipper.showPrevious();
    }
    public void nextView(View v) {
        //viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        //viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showNext();
    }

    public void endview(View v){
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
    }
}