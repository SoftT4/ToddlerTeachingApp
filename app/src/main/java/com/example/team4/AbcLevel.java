package com.example.team4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class AbcLevel extends AppCompatActivity {

    TextView choose;
    ImageButton easy, medium,hard;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc_level);

        choose = findViewById(R.id.choose);
        easy = findViewById(R.id.easy_btn);
        medium = findViewById(R.id.medium_btn);
        hard = findViewById(R.id.hard_btn);
        back = findViewById(R.id.back_btn);

        back.setOnClickListener(view -> {

            Intent intent = new Intent(AbcLevel.this, Start.class);
            startActivity(intent);
        });
        easy.setOnClickListener(view->{
            Intent learn = new Intent(this, learn_alphabet.class);
            startActivity(learn);
        });
    }
}