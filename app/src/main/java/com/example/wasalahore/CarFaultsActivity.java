package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wasalahore.CarFaults.CarFaultsAdapter;
import com.example.wasalahore.CarFaults.CarFaultsDataClass;
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

public class CarFaultsActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    List<CarFaultsDataClass> dataClassList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_faults);
        button = findViewById(R.id.back_button_car_faults);
        textView = findViewById(R.id.dtc_id);
        recyclerView = findViewById(R.id.rec_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(CarFaultsActivity.this));
        final CarFaultsAdapter adapter = new CarFaultsAdapter(CarFaultsActivity.this, dataClassList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("tbl_dtc_data");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("dtc_id")) {
                    String id = dataSnapshot.child("dtc_id").getValue().toString();
                    String title = dataSnapshot.child("title").getValue().toString();
                    String technical_description = dataSnapshot.child("technical_description").getValue().toString();
                    String description = dataSnapshot.child("description").getValue().toString();
                    String causes = dataSnapshot.child("causes_text").getValue().toString();
                    String solutions = dataSnapshot.child("possible_solutions").getValue().toString();
                    CarFaultsDataClass carFaultsDataClass = new CarFaultsDataClass(id, title, technical_description, description, causes, solutions);
                    dataClassList.add(carFaultsDataClass);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(CarFaultsActivity.this, "nai hua", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarFaultsActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }
}
