package com.example.wasalahore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wasalahore.Model.OwnerDataClass;
import com.example.wasalahore.RecyclerView.CarAdapter;
import com.example.wasalahore.RecyclerView.CarDataClass;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileActivity extends AppCompatActivity implements CarAdapter.OnClickInterface {

    TextView car1, car2;
    Button button;
    List<String> carsRegistered = new ArrayList<>();
    RecyclerView recyclerView;
    CarAdapter carAdapter;
    List<CarDataClass> carDataClass = new ArrayList<>();
    DatabaseReference databaseReference, carsDataBase, ownerDatabase;
    Context context;
    String _userid;
    OwnerDataClass ownerDataClass = new OwnerDataClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = this;


        Toast.makeText(context, getIntent().getStringExtra("user_id"), Toast.LENGTH_SHORT).show();
        _userid = getIntent().getStringExtra("user_id");



        recyclerView = findViewById(R.id.cars_recycler);
        carAdapter = new CarAdapter(ProfileActivity.this, carDataClass, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(ProfileActivity.this));
        recyclerView.setAdapter(carAdapter);


        ownerDatabase = FirebaseDatabase.getInstance().getReference("owner").child(_userid);
        ownerDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ownerDataClass = dataSnapshot.getValue(OwnerDataClass.class);
                Toast.makeText(context, ownerDataClass.getDob(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("owner").child(_userid).child("cars");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        carsRegistered.add(dataSnapshot1.getValue(String.class));
                        Toast.makeText(ProfileActivity.this,dataSnapshot1.getValue(String.class) , Toast.LENGTH_SHORT).show();
                    }
                    addCars();
                } else {
                    Log.d("aaaaaaaaaaaaaaaaa", "aaaaaaaaaaaa: ");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    void addCars() {
        int length = carsRegistered.size();
        for (int i = 0; i < length; i++) {

            carsDataBase = FirebaseDatabase.getInstance().getReference("car").child(carsRegistered.get(i));
            carsDataBase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChildren()) {
                        carDataClass.add(dataSnapshot.getValue(CarDataClass.class));
                        Log.e("calleddddddddd", dataSnapshot.getValue(CarDataClass.class).getCompanyname());
//                        }

                        carAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }

    @Override
    public void onCarClick(int position) {
        Toast.makeText(context, Integer.toString(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ProfileActivity.this, CarViewActivity.class);
        intent.putExtra("lisenceno",carsRegistered.get(position));
        intent.putExtra("modelname",carDataClass.get(position).getModelname());
        intent.putExtra("companyname",carDataClass.get(position).getCompanyname());
        intent.putExtra("modelnumber",carDataClass.get(position).getModelnumber());
        startActivity(intent);
        Log.e("AAAAAAAAAAAA", "onCarClick: AAAAAAAAAAAAAAAAAa");
    }
}
