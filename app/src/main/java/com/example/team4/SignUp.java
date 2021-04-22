package com.example.team4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity
{
    TextInputLayout Name, Username, Email, Phone, Password, Age;
    RadioButton Girl,Boy;
    Button callLogIn;
    ImageButton signup_btn;
    ImageView image;
    TextView logoText, sign;
    LinearLayout signup;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private FirebaseAuth mAuth;
    private static final String TAG = "SignUp";
    private User userclass;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        Name = findViewById(R.id.name);
        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        Phone = findViewById(R.id.phone);
        Password = findViewById(R.id.password);
        Age = findViewById(R.id.age);
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

        signup_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Intent intent = new Intent(SignUp.this,Login.class);
                //startActivity(intent);
                String name = Name.getEditText().getText().toString();
                username = Username.getEditText().getText().toString();
                String email = Email.getEditText().getText().toString();
                String phone = Phone.getEditText().getText().toString();
                String password = Password.getEditText().getText().toString();
                String girl = Girl.getText().toString();
                String boy = Boy.getText().toString();
                int age = Integer.parseInt(Age.getEditText().getEditableText().toString());

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter email and password", Toast.LENGTH_LONG).show();
                    return;
                }

                userclass = new User(name,username,email,phone,password,boy,girl,age);
                RegisterUser(email,password);

               // reference.child(username).setValue(userclass);
            }
        });


        callLogIn.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this,Login.class);
            startActivity(intent);

        });
    }
    public void RegisterUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success.Please verify your email to login");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                    }
                                    else{
                                        Toast.makeText(SignUp.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }
                    }
                });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }
    public void updateUI (FirebaseUser currentUser){
        //String keyID = reference.push().getKey();
        reference.child(username).setValue(userclass);
        Intent intent = new Intent(SignUp.this,Login.class);
        startActivity(intent);

    }
}