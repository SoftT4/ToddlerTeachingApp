package com.example.team4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Profile extends AppCompatActivity {
    ImageButton LogOut;
    ImageButton start, statistics, edit_profile;
    ImageView user;

    private FirebaseUser showuser;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        LogOut = findViewById(R.id.logout);
        start = findViewById(R.id.start);
        statistics = findViewById(R.id.stat);
        edit_profile = findViewById(R.id.edit);
        user = findViewById(R.id.imageView);

        final TextView usernameText = findViewById(R.id.username);
        final TextView fullnameText = findViewById(R.id.fullname);
        final TextView emailText = findViewById(R.id.email);

        showuser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users");
        userID = showuser.getUid();

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null)
                {
                    String username = userProfile.username;
                    String fullname = userProfile.name;
                    String email = userProfile.email;

                    usernameText.setText(username);
                    fullnameText.setText(fullname);
                    emailText.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });

        edit_profile.setOnClickListener(view -> {

            Intent intent = new Intent(Profile.this, EditProfile.class);
            startActivity(intent);
        });

        LogOut.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent2 = new Intent(Profile.this, Login.class);
            startActivity(intent2);
        });

    }

}
