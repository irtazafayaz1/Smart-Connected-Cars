package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wasalahore.RainGauges.RainGaugeHome;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView car1, car2;
    Button button;
    FloatingActionButton giveReview, carFaults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        giveReview = findViewById(R.id.profile_give_review);
        carFaults = findViewById(R.id.profile_car_faults);
//        button = findViewById(R.id.back_button_profile);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ProfileActivity.this, ListActivity.class);
//                startActivity(intent);
//            }
//        });

        carFaults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, CarFaultsActivity.class);
                startActivity(intent);
            }
        });


        giveReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, RainGaugeHome.class);
                startActivity(intent);
            }
        });

    }
}
