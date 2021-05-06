package com.example.team4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

import java.util.Locale;

public class learn_alphabet extends AppCompatActivity {
    TextView Learn, Alphabet, English;
    Button back, a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    ImageView image1;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_alphabet);

        Learn = findViewById(R.id.learn);
        Alphabet = findViewById(R.id.alphabet);
        English = findViewById(R.id.english);
        back = findViewById(R.id.buttonback);
        image1 = findViewById(R.id.alpha_image);

        a = findViewById(R.id.button_a);
        b = findViewById(R.id.button_b);
        c = findViewById(R.id.button_c);
        d = findViewById(R.id.button_d);
        e = findViewById(R.id.button_e);
        f = findViewById(R.id.button_f);
        g = findViewById(R.id.button_g);
        h = findViewById(R.id.button_h);
        i = findViewById(R.id.button_i);
        j = findViewById(R.id.button_j);
        k = findViewById(R.id.button_k);
        l = findViewById(R.id.button_l);
        m = findViewById(R.id.button_m);
        n = findViewById(R.id.button_n);
        o = findViewById(R.id.button_o);
        p = findViewById(R.id.button_p);
        q = findViewById(R.id.button_q);
        r = findViewById(R.id.button_r);
        s = findViewById(R.id.button_s);
        t = findViewById(R.id.button_t);
        u = findViewById(R.id.button_u);
        v = findViewById(R.id.button_v);
        w= findViewById(R.id.button_w);
        x = findViewById(R.id.button_x);
        y = findViewById(R.id.button_y);
        z = findViewById(R.id.button_z);


        back.setOnClickListener(view->{
            onBackPressed();
        });

        a.setOnClickListener(view->{
            Alphabet.setText("Aa");
            English.setText("Aligator");
            image1.setImageResource(R.mipmap.a);
            soundon();
        });
        b.setOnClickListener(view->{
            Alphabet.setText("Bb");
            English.setText("Bear");
            image1.setImageResource(R.mipmap.b);
            soundon();
        });
        c.setOnClickListener(view->{
            Alphabet.setText("Cc");
            English.setText("Cat");
            image1.setImageResource(R.mipmap.c);
            soundon();
        });
        d.setOnClickListener(view->{
            Alphabet.setText("Dd");
            English.setText("Dog");
            image1.setImageResource(R.mipmap.d);
            soundon();
        });
        e.setOnClickListener(view->{
            Alphabet.setText("Ee");
            English.setText("Elephant");
            image1.setImageResource(R.mipmap.e);
            soundon();
        });
        f.setOnClickListener(view->{
            Alphabet.setText("Ff");
            English.setText("Fox");
            image1.setImageResource(R.mipmap.f);
            soundon();
        });
        g.setOnClickListener(view->{
            Alphabet.setText("Gg");
            English.setText("Giraffe");
            image1.setImageResource(R.mipmap.g);
            soundon();
        });
        h.setOnClickListener(view->{
            Alphabet.setText("Hh");
            English.setText("Horse");
            image1.setImageResource(R.mipmap.h);
            soundon();
        });
        i.setOnClickListener(view->{
            Alphabet.setText("Ii");
            English.setText("Iguana");
            image1.setImageResource(R.mipmap.i);
            soundon();
        });
        j.setOnClickListener(view->{
            Alphabet.setText("Ji");
            English.setText("JellyFish");
            image1.setImageResource(R.mipmap.j);
            soundon();
        });
        k.setOnClickListener(view->{
            Alphabet.setText("Kk");
            English.setText("Kangaroo");
            image1.setImageResource(R.mipmap.k);
            soundon();
        });
        l.setOnClickListener(view->{
            Alphabet.setText("Ll");
            English.setText("Lion");
            image1.setImageResource(R.mipmap.l);
            soundon();
        });
        m.setOnClickListener(view->{
            Alphabet.setText("Mm");
            English.setText("Mouse");
            image1.setImageResource(R.mipmap.m);
            soundon();
        });
        n.setOnClickListener(view->{
            Alphabet.setText("Nn");
            English.setText("Narwhal");
            image1.setImageResource(R.mipmap.n);
            soundon();
        });
        o.setOnClickListener(view->{
            Alphabet.setText("Oo");
            English.setText("Owl");
            image1.setImageResource(R.mipmap.o);
            soundon();
        });
        p.setOnClickListener(view->{
            Alphabet.setText("Pp");
            English.setText("Pig");
            image1.setImageResource(R.mipmap.p);
            soundon();
        });
        q.setOnClickListener(view->{
            Alphabet.setText("Qq");
            English.setText("Quail");
            image1.setImageResource(R.mipmap.q);
            soundon();
        });
        r.setOnClickListener(view->{
            Alphabet.setText("Rr");
            English.setText("Rhinoceros");
            image1.setImageResource(R.mipmap.r);
            soundon();
        });
        s.setOnClickListener(view->{
            Alphabet.setText("Ss");
            English.setText("Snail");
            image1.setImageResource(R.mipmap.s);
            soundon();
        });
        t.setOnClickListener(view->{
            Alphabet.setText("Tt");
            English.setText("Tiger");
            image1.setImageResource(R.mipmap.t);
            soundon();
        });
        u.setOnClickListener(view->{
            Alphabet.setText("Uu");
            English.setText("Unicorn");
            image1.setImageResource(R.mipmap.u);
            soundon();
        });
        v.setOnClickListener(view->{
            Alphabet.setText("Vv");
            English.setText("Vulture");
            image1.setImageResource(R.mipmap.v);
            soundon();
        });
        w.setOnClickListener(view->{
            Alphabet.setText("Ww");
            English.setText("Whale");
            image1.setImageResource(R.mipmap.w);
            soundon();
        });
        x.setOnClickListener(view->{
            Alphabet.setText("Xx");
            English.setText("X-rayFish");
            image1.setImageResource(R.mipmap.x);
            soundon();
        });
        y.setOnClickListener(view->{
            Alphabet.setText("Yy");
            English.setText("Yak");
            image1.setImageResource(R.mipmap.y);
            soundon();
        });
        z.setOnClickListener(view->{
            Alphabet.setText("Zz");
            English.setText("Zebra");
            image1.setImageResource(R.mipmap.z);
            soundon();
        });
    }
    private void soundon()
    {
        switch(Alphabet.getText().toString()){
            case "Aa":
                player = MediaPlayer.create(this,R.raw.a);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Bb":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Cc":
                player = MediaPlayer.create(this,R.raw.c);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Dd":
                player = MediaPlayer.create(this,R.raw.d);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Ee":
                player = MediaPlayer.create(this,R.raw.e);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Ff":
                player = MediaPlayer.create(this,R.raw.f);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Gg":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Hh":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Ii":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Jj":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Kk":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Ll":
                player = MediaPlayer.create(this,R.raw.l);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Mm":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Nn":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Oo":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Pp":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Qq":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Rr":
                player = MediaPlayer.create(this,R.raw.r);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Ss":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Tt":
                player = MediaPlayer.create(this,R.raw.t);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Uu":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Vv":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Ww":
                player = MediaPlayer.create(this,R.raw.w);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Xx":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Yy":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });
            case "Zz":
                player = MediaPlayer.create(this,R.raw.b);
                player.start();
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        player.release();
                    }
                });

        }
    }
}