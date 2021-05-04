package com.example.team4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText Name, Username, Email, Phone, Password, Age;
    RadioButton Girl, Boy;
    Button callLogIn;
    ImageButton signup_btn;
    ImageView image;
    TextView logoText, sign;
    LinearLayout signup;
    ProgressBar progressBar;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private FirebaseAuth mAuth;
    private static final String TAG = "SignUp";
    private User userclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        Name = (EditText) findViewById(R.id.name);
        Username = (EditText)findViewById(R.id.username);
        Email = (EditText)findViewById(R.id.email);
        Phone = (EditText)findViewById(R.id.phone);
        Password = (EditText)findViewById(R.id.password);
        Age = (EditText)findViewById(R.id.age);
        Girl = findViewById(R.id.girl);
        Boy = findViewById(R.id.boy);

        callLogIn = findViewById(R.id.back_to_login);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_text);
        sign = findViewById(R.id.sign);
        signup = findViewById(R.id.signup);
        signup_btn = findViewById(R.id.signupButton);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");
        mAuth = FirebaseAuth.getInstance();
        callLogIn.setOnClickListener(this);
        signup_btn.setOnClickListener(this);

        progressBar = findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_to_login:
                startActivity(new Intent(this,Login.class));
                break;
            case R.id.signupButton:
                signUpUser();
                break;
        }
    }

    private void signUpUser()
    {
        String fullname = Name.getText().toString().trim();
        String username = Username.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String phone = Phone.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String age = Age.getText().toString().trim();
        String boy = Boy.getText().toString().trim();
        String girl = Girl.getText().toString().trim();


        if(fullname.isEmpty())
        {
            Name.setError("Full name is required");
            Name.requestFocus();
            return;
        }
        if(username.isEmpty())
        {
            Username.setError("Username is required");
            Username.requestFocus();
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

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            userclass = new User(fullname,username,email,phone,password,boy,girl,age);

                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(userclass).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(SignUp.this,"Registered successfully!",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                    else
                                        {
                                            Toast.makeText(SignUp.this,"Register Failed! Try again!",Toast.LENGTH_LONG).show();
                                            progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(SignUp.this,"Register Failed! Try again!",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}