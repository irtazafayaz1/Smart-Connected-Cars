package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wasalahore.Model.LiveDataClass;
import com.github.capur16.digitspeedviewlib.DigitSpeedView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CarViewActivity extends AppCompatActivity {

    DigitSpeedView digitSpeedView, fuel, rpm;
    DatabaseReference databaseReference;
    String lisenceno, modelnumber, modelname, companyname;
    TextView carName,registrationNo;
    FloatingActionButton giveReview, carFaults, add_car;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_view);
        carName = findViewById(R.id.carName);
        registrationNo = findViewById(R.id.registrationNo);
        add_car = findViewById(R.id.add_car);
        giveReview = findViewById(R.id.profile_give_review);
        carFaults = findViewById(R.id.profile_car_faults);



        Intent intent = getIntent();
        lisenceno = intent.getStringExtra("lisenceno");
        modelname = intent.getStringExtra("modelname");
        modelnumber = intent.getStringExtra("modelnumber");
        companyname = intent.getStringExtra("companyname");

        Toast.makeText(this, lisenceno + modelnumber + modelname + companyname, Toast.LENGTH_SHORT).show();

        carFaults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarViewActivity.this, CarFaultsActivity.class);
                intent.putExtra("lisenceno",lisenceno);
                startActivity(intent);
            }
        });


        giveReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarViewActivity.this, ReviewActivity.class);
                intent.putExtra("lisenceno",lisenceno);
                intent.putExtra("companyname",companyname);
                intent.putExtra("modelname",modelname + " " + modelnumber);

                startActivity(intent);
            }
        });
        add_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarViewActivity.this, AddNewCarActivity.class);
                startActivity(intent);

            }
        });



        carName.setText(modelname);
        registrationNo.setText(lisenceno);


        digitSpeedView = findViewById(R.id.speed_meter);
        rpm = findViewById(R.id.rpm_meter);
        fuel = findViewById(R.id.fuel_meter);
        databaseReference = FirebaseDatabase.getInstance().getReference("livedata").child(lisenceno);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                LiveDataClass liveDataClass = dataSnapshot.getValue(LiveDataClass.class);
//                Log.e("1111111onDataChange: ", dataSnapshot.getValue(LiveDataClass.class).getFuel());
                digitSpeedView.updateSpeed(liveDataClass.getSpeed());
                rpm.updateSpeed(liveDataClass.getRpm());
                fuel.updateSpeed(liveDataClass.getFuel());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
