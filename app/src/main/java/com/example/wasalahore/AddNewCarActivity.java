package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewCarActivity extends AppCompatActivity {

    EditText lisence_number, model_name, model_number, company_name;
    Button request;
    String _lisencenumber, _model_name, _model_number, _company_name;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_car);

        lisence_number = findViewById(R.id.car_number);
        model_name = findViewById(R.id.model_name);
        company_name = findViewById(R.id.company_name);
        model_number = findViewById(R.id.model_number);
        request = findViewById(R.id.request);

        databaseReference = FirebaseDatabase.getInstance().getReference("addnewcarrequest");


        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _lisencenumber = lisence_number.getText().toString();
                _model_name = model_name.getText().toString();
                _model_number = model_number.getText().toString();
                _company_name = company_name.getText().toString();

                String pushKey = databaseReference.push().getKey();

                databaseReference.child(pushKey).child("carnum").setValue(_lisencenumber);
                databaseReference.child(pushKey).child("manufacturer").setValue(_company_name);
                databaseReference.child(pushKey).child("model").setValue(_model_number);
                databaseReference.child(pushKey).child("name").setValue(_model_name);
                databaseReference.child(pushKey).child("uid").setValue(pushKey);
                databaseReference.child(pushKey).child("ownername").setValue("Irtaza Fayaz");

                Intent intent = new Intent(AddNewCarActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


    }
}
