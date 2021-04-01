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
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity
{

    Button callSignUp;
    ImageButton login_btn;
    ImageView image;
    TextView logoText, sign;
    TextInputLayout username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_text);
        sign = findViewById(R.id.sign);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.playButton);


        callSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this,SignUp.class);
            Pair[] pairs = new Pair[7];
            pairs[0] = new Pair<View,String>(image,"logo_image");
            pairs[1] = new Pair<View,String>(logoText,"logo_text");
            pairs[2] = new Pair<View,String>(sign,"logo_desc");
            pairs[3] = new Pair<View,String>(username,"username_tran");
            pairs[4] = new Pair<View,String>(password,"password_tran");
            pairs[5] = new Pair<View,String>(login_btn,"button_tran");
            pairs[6] = new Pair<View,String>(callSignUp,"login_signup_tran");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
            {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
}