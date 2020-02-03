package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wasalahore.RainGauges.RainGaugeHome;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ListActivity extends AppCompatActivity {

    CardView car_faults, profile_info, give_review, live_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        car_faults = findViewById(R.id.car_faults);
        profile_info = findViewById(R.id.profile_info);
        give_review = findViewById(R.id.give_review);





        give_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, RainGaugeHome.class);
                startActivity(intent);
            }
        });
        
        profile_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        car_faults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, CarFaultsActivity.class);
                startActivity(intent);
            }
        });
    }
}
