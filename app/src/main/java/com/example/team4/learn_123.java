package com.example.team4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class learn_123 extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine,zero,back;
    ImageView art;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_123);
        one = findViewById(R.id.button_1);
        two = findViewById(R.id.button_2);
        three = findViewById(R.id.button_3);
        four= findViewById(R.id.button_4);
        five = findViewById(R.id.button_5);
        six = findViewById(R.id.button_6);
        seven = findViewById(R.id.button_7);
        eight = findViewById(R.id.button_8);
        nine  = findViewById(R.id.button_9);
        zero = findViewById(R.id.button_0);
        art = findViewById(R.id.num_image);
        back = findViewById(R.id.buttonback);

        back.setOnClickListener(view->{
            onBackPressed();
        });
        zero.setOnClickListener(view->{
            art.setImageResource(R.mipmap.ze);
            player = MediaPlayer.create(this,R.raw.zero);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        one.setOnClickListener(view->{
            art.setImageResource(R.mipmap.on);
            player = MediaPlayer.create(this,R.raw.one);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        two.setOnClickListener(view->{
            art.setImageResource(R.mipmap.tw);
            player = MediaPlayer.create(this,R.raw.two);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        three.setOnClickListener(view->{
            art.setImageResource(R.mipmap.th);
            player = MediaPlayer.create(this,R.raw.three);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        four.setOnClickListener(view->{
            art.setImageResource(R.mipmap.fo);
            player = MediaPlayer.create(this,R.raw.four);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        five.setOnClickListener(view->{
            art.setImageResource(R.mipmap.fv);
            player = MediaPlayer.create(this,R.raw.five);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        six.setOnClickListener(view->{
            art.setImageResource(R.mipmap.six);
            player = MediaPlayer.create(this,R.raw.six);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        seven.setOnClickListener(view->{
            art.setImageResource(R.mipmap.sev);
            player = MediaPlayer.create(this,R.raw.seven);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        eight.setOnClickListener(view->{
            art.setImageResource(R.mipmap.eig);
            player = MediaPlayer.create(this,R.raw.eight);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });
        nine.setOnClickListener(view->{
            art.setImageResource(R.mipmap.nin);
            player = MediaPlayer.create(this,R.raw.nine);
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    player.release();
                }
            });

        });



    }

}