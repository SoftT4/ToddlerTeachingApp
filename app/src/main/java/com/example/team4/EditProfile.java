package com.example.team4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class EditProfile extends AppCompatActivity implements View.OnClickListener{

    ImageView profileimg;
    Button update,cancel;
    private EditText Fullname, Email, Phone, Password, Age;
    String fullname,email,phone,password,age;

    private FirebaseUser showuser;
    private DatabaseReference reference;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        profileimg = findViewById(R.id.profile_image);
        update = findViewById(R.id.update_btn);
        cancel = findViewById(R.id.back_btn);

        update.setOnClickListener(this);
        cancel.setOnClickListener(this);

        final TextView fullNameLabel = findViewById(R.id.fullname_field);
        final TextView usernameLabel = findViewById(R.id.username_field);
        Fullname = findViewById(R.id.full_name_profile);
        Email = findViewById(R.id.email_profile);
        Phone = findViewById(R.id.phone_no_profile);
        Password = findViewById(R.id.password_profile);
        Age = findViewById(R.id.age_profile);

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
                    String fullnameView = userProfile.name;
                    String fullname = userProfile.name;
                    String email = userProfile.email;
                    String phone = userProfile.phone;
                    String password = userProfile.password;
                    String age = userProfile.age;

                    fullNameLabel.setText(username);
                    usernameLabel.setText(fullnameView);
                    Fullname.setText(fullname);
                    Email.setText(email);
                    Phone.setText(phone);
                    Password.setText(password);
                    Age.setText(age);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.update_btn:
                updateProfile();
                break;
            case R.id.back_btn:
                startActivity(new Intent(this,Profile.class));
                break;
        }
    }

    private void updateProfile()
    {
        fullname = Fullname.getText().toString().trim();
        email = Email.getText().toString().trim();
        phone = Phone.getText().toString().trim();
        password = Password.getText().toString().trim();
        age = Age.getText().toString().trim();

        if(fullname.isEmpty())
        {
            Fullname.setError("Full name is required");
            Fullname.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            Password.setError("Password is required");
            Password.requestFocus();
            return;
        }
        if(password.length() < 8)
        {
            Password.setError("At least 8 characters");
            Password.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            Email.setError("Email is required");
            Email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Email.setError("Invalid email");
            Email.requestFocus();
            return;
        }
        if(phone.isEmpty())
        {
            Phone.setError("Phone number is required");
            Phone.requestFocus();
            return;
        }
        if(phone.length() < 10)
        {
            Phone.setError("Invalid phone number");
            Phone.requestFocus();
            return;
        }
        if(age.isEmpty())
        {
            Age.setError("Age is required");
            Age.requestFocus();
            return;
        }
        if(age.equals("0"))
        {
            Age.setError("Invalid age");
            Age.requestFocus();
            return;
        }

        HashMap hashMap = new HashMap();
        hashMap.put("name",fullname);
        hashMap.put("email",email);
        hashMap.put("phone",phone);
        hashMap.put("password",password);
        hashMap.put("age",age);

        reference.child(userID).updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task)
            {

            }
        });
    }



}
