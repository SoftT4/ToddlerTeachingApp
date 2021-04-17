package com.example.team4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
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

        signup_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                String name = Name.getEditText().getText().toString();
                String username = Username.getEditText().getText().toString();
                String email = Email.getEditText().getText().toString();
                String phone = Phone.getEditText().getText().toString();
                String password = Password.getEditText().getText().toString();
                String girl = Girl.getText().toString();
                String boy = Boy.getText().toString();
                int age = Integer.parseInt(Age.getEditText().getEditableText().toString());

                User userclass = new User(name,username,email,phone,password,boy,girl,age);

                reference.child(username).setValue(userclass);
            }
        });


        callLogIn.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this,Login.class);
            Pair[] pairs = new Pair[5];
            pairs[0] = new Pair<View,String>(image,"logo_image");
            pairs[1] = new Pair<View,String>(logoText,"logo_text");
            pairs[2] = new Pair<View,String>(sign,"logo_desc");
            pairs[3] = new Pair<View,String>(signup,"signup_tran");
            pairs[4] = new Pair<View,String>(signup_btn,"play_tran");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
            {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
}