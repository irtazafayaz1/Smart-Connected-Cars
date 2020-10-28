package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView register;
    EditText password, username;
    ImageView imglogo;
    Button button;
    DatabaseReference databaseReference;
    String _password, _username;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register = findViewById(R.id.register);
        username = findViewById(R.id.username_login);
        password = findViewById(R.id.password_login);
        imglogo = findViewById(R.id.login_img);
        Picasso.get().load(R.drawable.cars).into(imglogo);
        button = findViewById(R.id.login_btn);
        firebaseAuth = FirebaseAuth.getInstance();


        databaseReference = FirebaseDatabase.getInstance().getReference("logins");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterOwner.class));
            }
        });

        button.setOnClickListener(this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (username.getText().toString().isEmpty())
//                    Toast.makeText(MainActivity.this, "Would you care to enter a username?!?", Toast.LENGTH_SHORT).show();
//                else if (password.getText().toString().isEmpty())
//                    Toast.makeText(MainActivity.this, "Would you care to enter a password", Toast.LENGTH_SHORT).show();
//                else {
//                    _username = username.getText().toString();
//                    _password = password.getText().toString();
//
//                    firebaseAuth.signInWithEmailAndPassword(_username, _password)
//                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    if (task.isSuccessful()) {
//                                        // Sign in success, update UI with the signed-in user's information
//                                        Log.d("TAG", "signInWithEmail:success");
//                                        FirebaseUser user = firebaseAuth.getCurrentUser();
//                                        updateUI(user);
//                                    } else {
//                                        // If sign in fails, display a message to the user.
//                                        Log.w("TAG", "signInWithEmail:failure", task.getException());
//                                        updateUI(null);
//                                        // [START_EXCLUDE]
//                                        // [END_EXCLUDE]
//                                    }
//
//                                    // [START_EXCLUDE]
//                                    if (!task.isSuccessful()) {
//                                        Toast.makeText(MainActivity.this, "WROMGGG", Toast.LENGTH_SHORT).show();
//                                    }
//                                    // [END_EXCLUDE]
//                                }
//                            });
//
////
////                    Query query = databaseReference.orderByChild("emailaddress").equalTo(_username);
////                    query.addValueEventListener(new ValueEventListener() {
////                        @Override
////                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                            if (dataSnapshot.hasChildren()) {
////
////                                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
////                                    LoginClass _user = dataSnapshot1.getValue(LoginClass.class);
////
////                                    if (_user.getPassword().equalsIgnoreCase(_password)) {
////                                        Toast.makeText(MainActivity.this, "Welcome :D ", Toast.LENGTH_SHORT).show();
////
////                                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
////                                        startActivity(intent);
////                                    } else {
////                                        Toast.makeText(MainActivity.this, _password, Toast.LENGTH_SHORT).show();
////
////                                    }
////
////                                }
////
////
////                            } else {
////                                Toast.makeText(MainActivity.this, "Username doesn't exists", Toast.LENGTH_SHORT).show();
////                            }
////                        }
////
////                        @Override
////                        public void onCancelled(@NonNull DatabaseError databaseError) {
////
////                        }
////                    });
//
//                }
//
//
//            }
//        });

    }

    void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("user_id",user.getUid());
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_btn) {
            if (username.getText().toString().isEmpty())
                Toast.makeText(MainActivity.this, "Would you care to enter a username?!?", Toast.LENGTH_SHORT).show();
            else if (password.getText().toString().isEmpty())
                Toast.makeText(MainActivity.this, "Would you care to enter a password", Toast.LENGTH_SHORT).show();
            else {
                _username = username.getText().toString();
                _password = password.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(_username, _password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("TAG", "signInWithEmail:success");
                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("TAG", "signInWithEmail:failure", task.getException());
                                    updateUI(null);
                                    Toast.makeText(MainActivity.this, "WROMGGGAAAAAAA", Toast.LENGTH_SHORT).show();

                                    // [START_EXCLUDE]
                                    // [END_EXCLUDE]
                                }

                                // [START_EXCLUDE]
                                if (!task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "WROMGGG", Toast.LENGTH_SHORT).show();
                                }
                                // [END_EXCLUDE]
                            }
                        });
            }
        }
    }
}