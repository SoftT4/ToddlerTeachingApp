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

public class SignUp extends AppCompatActivity
{
    Button callLogIn;
    ImageButton play_btn;
    ImageView image;
    TextView logoText, sign;
    LinearLayout signup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        callLogIn = findViewById(R.id.back_to_login);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_text);
        sign = findViewById(R.id.sign);
        signup = findViewById(R.id.signup);
        play_btn = findViewById(R.id.playButton);

        callLogIn.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this,Login.class);
            Pair[] pairs = new Pair[5];
            pairs[0] = new Pair<View,String>(image,"logo_image");
            pairs[1] = new Pair<View,String>(logoText,"logo_text");
            pairs[2] = new Pair<View,String>(sign,"logo_desc");
            pairs[3] = new Pair<View,String>(signup,"signup_tran");
            pairs[4] = new Pair<View,String>(play_btn,"play_tran");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
            {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });
    }
}