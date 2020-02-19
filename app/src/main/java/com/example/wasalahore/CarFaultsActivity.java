package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wasalahore.CarFaults.CarFaultsAdapter;
import com.example.wasalahore.CarFaults.CarFaultsDataClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CarFaultsActivity extends AppCompatActivity {
    String lisence_no = "len4245";
    Button button;
    TextView textView;
    DatabaseReference databaseReference, databaseReference1;
    RecyclerView recyclerView;
    List<String> car_faults_ids = new ArrayList<>();
    List<CarFaultsDataClass> dataClassList = new ArrayList<>();
    CarFaultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_faults);
        button = findViewById(R.id.back_button_car_faults);
        textView = findViewById(R.id.dtc_id);
        recyclerView = findViewById(R.id.rec_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(CarFaultsActivity.this));
        adapter = new CarFaultsAdapter(CarFaultsActivity.this, dataClassList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("car_faults").child(lisence_no);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                car_faults_ids.clear();
                if (dataSnapshot.hasChildren()) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        car_faults_ids.add(dataSnapshot1.child("dtc_id").getValue().toString());
                    }
                    Log.e("sting list", car_faults_ids.toString());
                    notifyChange();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        databaseReferenceddListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.hasChildren()) {
//                    Map<String, Object> data = (Map<String, Object>) dataSnapshot.getValue();
////                    String title = dataSnapshot.child("title").getValue().toString();
////                    String technical_description = dataSnapshot.child("technical_description").getValue().toString();
////                    String description = dataSnapshot.child("description").getValue().toString();
////                    String causes = dataSnapshot.child("causes_text").getValue().toString();
////                    String solutions = dataSnapshot.child("possible_solutions").getValue().toString();
//                    CarFaultsDataClass carFaultsDataClass = new CarFaultsDataClass(data.get("speed").toString(), "title", "technical_description", "description", "causes", "solutions");
//                    dataClassList.add(carFaultsDataClass);
//                    adapter.notifyDataSetChanged();
//                } else {
//                    Toast.makeText(CarFaultsActivity.this, "nai hua", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarFaultsActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }

    public void notifyChange() {
        databaseReference1 = FirebaseDatabase.getInstance().getReference("tbl_dtc_data");
        int len = car_faults_ids.size();
        dataClassList.clear();
        for (int i = 0; i < len; i++) {
            Query query = databaseReference1.orderByChild("dtc_id").equalTo(car_faults_ids.get(i));
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChildren()) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            dataClassList.add(dataSnapshot1.getValue(CarFaultsDataClass.class));
                            Log.e("called", "onDataChange: ");
                        }
                        Log.e("1", dataClassList.toString());
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            Log.e("2", dataClassList.toString());
        }
        Log.e("3", dataClassList.toString());
        Log.e("aaaaaa", dataClassList.toString());

    }
}
