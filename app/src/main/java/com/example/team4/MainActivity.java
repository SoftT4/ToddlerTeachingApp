package com.example.team4;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private static int SPLASH_SCREEN = 4000;

    Animation topAnim, bottomAnim;
    ImageView play, room;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        new BackgroundSplashTask().execute();
    }

    private class BackgroundSplashTask extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            play = findViewById(R.id.play);
            room = findViewById(R.id.room);

            play.setAnimation(topAnim);
            room.setAnimation(bottomAnim);
            try
            {
                Thread.sleep(SPLASH_SCREEN);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
           /* Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View, String>(play, "logo_image");
            pairs[1] = new Pair<View, String>(room, "logo_text");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                MainActivity.this.startActivity(intent, options.toBundle());
            }*/
            finish();
        }
    }
}