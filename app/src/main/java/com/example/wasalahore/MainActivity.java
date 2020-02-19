package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wasalahore.Model.LoginClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText password, username;
    ImageView imglogo;
    Button button;
    DatabaseReference databaseReference;
    String _password, _username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);
        imglogo = findViewById(R.id.login_img);
        Picasso.get().load(R.drawable.cars).into(imglogo);
        button = findViewById(R.id.login_btn);

        databaseReference = FirebaseDatabase.getInstance().getReference("logins");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Would you care to enter a username?!?", Toast.LENGTH_SHORT).show();
                else if (password.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Would you care to enter a password", Toast.LENGTH_SHORT).show();
                else {
                    _username = username.getText().toString();
                    _password = password.getText().toString();
                    Query query = databaseReference.orderByChild("emailaddress").equalTo(_username);
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.hasChildren()) {

                                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                    LoginClass _user = dataSnapshot1.getValue(LoginClass.class);

                                    if (_user.getPassword().equalsIgnoreCase(_password)) {
                                        Toast.makeText(MainActivity.this, "Welcome :D ", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(MainActivity.this, _password, Toast.LENGTH_SHORT).show();

                                    }

                                }


                            } else {
                                Toast.makeText(MainActivity.this, "Username doesn't exists", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }


            }
        });

    }
}
