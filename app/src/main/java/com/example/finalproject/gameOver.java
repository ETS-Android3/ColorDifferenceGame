package com.example.finalproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class gameOver extends AppCompatActivity {

    MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//just plays the sound effect of losing
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        click = MediaPlayer.create(getApplicationContext(), R.raw.click);
    }
    public void changeMenu(View view){ //uses an intent to switch to the main menu activity
        click.start();
        Intent startNewActivity = new Intent(this, MainMenu.class);
        startActivity(startNewActivity);
    }
    public void restart(View view){//This uses an intent to restart the game activity
        click.start();
        Intent startNewActivity = new Intent(this, GameActivity.class);
        startActivity(startNewActivity);
    }
}// Before this, I only have ever seriously coded when we were using j-grasp in Ap comp-sci. So something like this was a huge step id difficulty for me
//  making me learn the basics of xml and android app development on my own. So while the the java component of this code seems simplistic, I hope you keep in
//  mind that the majority of my time was spent learning and implementing the xml portion in tandem with the java code.
