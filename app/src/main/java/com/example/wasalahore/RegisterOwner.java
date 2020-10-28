package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterOwner extends AppCompatActivity {

    EditText name, cnic, phone;
    Button register;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_owner);

        name = findViewById(R.id.name_);
        cnic = findViewById(R.id.cnic_);
        register = findViewById(R.id.register_);
        phone = findViewById(R.id.phone);

        databaseReference = FirebaseDatabase.getInstance().getReference("add_new_onwer_request");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String _name = name.getText().toString();
                String _cnic = cnic.getText().toString();
                String _phone = phone.getText().toString();
                String pushKey = databaseReference.push().getKey();
                Log.e("onCreate", _name + _cnic + pushKey);

                databaseReference.child(pushKey).child("name").setValue(_name);
                databaseReference.child(pushKey).child("cnic").setValue(_cnic);
                databaseReference.child(pushKey).child("phone").setValue(_phone);
                Intent intent = new Intent(RegisterOwner.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }

}
