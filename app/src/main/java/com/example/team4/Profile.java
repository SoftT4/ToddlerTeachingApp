package com.example.team4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class Profile extends AppCompatActivity
{
    ImageButton LogOut;
    ImageButton start, statistics, edit_profile;
    TextView username, fullname, emaildis;
    ImageView user;
    String email;

    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        LogOut = findViewById(R.id.logout);
        start = findViewById(R.id.start);
        statistics = findViewById(R.id.stat);
        edit_profile = findViewById(R.id.edit);
        username = findViewById(R.id.username);
        fullname = findViewById(R.id.fullname);
        emaildis = findViewById(R.id.email);
        user = findViewById(R.id.userimg);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    if(ds.child("email").getValue().equals(email)){
                        fullname.setText(ds.child("name").getValue(String.class));
                        emaildis.setText(email);
                        username.setText(ds.child("username").getValue(String.class));

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
         LogOut.setOnClickListener(view -> {

         Intent intent2 = new Intent(Profile.this, Login.class);
          startActivity(intent2);
          });

    }
}