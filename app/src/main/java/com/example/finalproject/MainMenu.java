package com.example.finalproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    MediaPlayer musicPlayer;
    MediaPlayer click;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //On the creation of the App, this is the activity that first gets displayed.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        constraintLayout = findViewById(R.id.myBackground);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();//In xml section, imports the background animation file from inside of my_bg_anim, standing for my background animation
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        musicPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);// Imports background music from res.raw and stars playing it
        click = MediaPlayer.create(getApplicationContext(), R.raw.click);
        musicPlayer.setLooping(true);
        musicPlayer.start();

    }
    public void changeActivityLives(View view){ //Uses an intent to change activities to the game activity
        click.start();
        Intent startNewActivity = new Intent(this, GameActivity.class);
        startActivity(startNewActivity);

    }
}

