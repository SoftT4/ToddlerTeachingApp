package com.example.team4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button callSignUp;
    ImageButton login_btn;
    ImageView image;
    TextView logoText, sign, forgotPassword;
    private EditText Email, Password;
    private static final String TAG = "Login";
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        callSignUp = findViewById(R.id.signup_click);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_text);
        sign = findViewById(R.id.sign);
        login_btn = findViewById(R.id.LoginButton);

        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);

        login_btn.setOnClickListener(this);
        callSignUp.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);

        progressBar = findViewById(R.id.progressBar2);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.signup_click:
                startActivity(new Intent(this,SignUp.class));
                break;
            case R.id.LoginButton:
                userLogin();
                break;
            case R.id.forgotPassword:
                startActivity(new Intent(this,ForgotPassword.class));
                break;
        }
    }

    private void userLogin()
    {
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if(email.isEmpty())
        {
            Email.setError("Email is required!");
            Email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Email.setError("Invalid email");
            Email.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            Password.setError("Password is required!");
            Password.requestFocus();
            return;
        }
        if(password.length() < 8)
        {
            Password.setError("Minimum length is 8 characters!");
            Password.requestFocus();
            return;
        }

        
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified())
                    {
                        startActivity(new Intent(Login.this,Profile.class));
                        finish();
                    }
                    else
                    {
                        user.sendEmailVerification();
                        Toast.makeText(Login.this,"Check your email to verify your account.",Toast.LENGTH_LONG).show();
                    }

                }
                else{
                    Toast.makeText(Login.this,"Authentication failed.",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
            }
        });
    }
}