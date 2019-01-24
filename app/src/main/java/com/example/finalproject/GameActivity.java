package com.example.finalproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class GameActivity extends AppCompatActivity { //IS the screen/activity for the actual game itself

    int lives;
    int normalColor;
    int differentColor;
    int changed;
    int index;
    int score;
    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    MediaPlayer click;
    MediaPlayer lose;
    Button[] buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // Starts also playing the background animation and makes an array of all the buttons.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        constraintLayout = findViewById(R.id.myGameBackground);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
        this.lives = 5;
        this.buttons = new Button[25];
        buttons[0] = findViewById(R.id.b1);
        buttons[1] = findViewById(R.id.b2);
        buttons[2] = findViewById(R.id.b3);
        buttons[3] = findViewById(R.id.b4);
        buttons[4] = findViewById(R.id.b5);
        buttons[5] = findViewById(R.id.b6);
        buttons[6] = findViewById(R.id.b7);
        buttons[7] = findViewById(R.id.b8);
        buttons[8] = findViewById(R.id.b9);
        buttons[9] = findViewById(R.id.b10);
        buttons[10] = findViewById(R.id.b11);
        buttons[11] = findViewById(R.id.b12);
        buttons[12] = findViewById(R.id.b13);
        buttons[13] = findViewById(R.id.b14);
        buttons[14] = findViewById(R.id.b15);
        buttons[15] = findViewById(R.id.b16);
        buttons[16] = findViewById(R.id.b17);
        buttons[17] = findViewById(R.id.b18);
        buttons[18] = findViewById(R.id.b19);
        buttons[19] = findViewById(R.id.b20);
        buttons[20] = findViewById(R.id.b21);
        buttons[21] = findViewById(R.id.b22);
        buttons[22] = findViewById(R.id.b23);
        buttons[23] = findViewById(R.id.b24);
        buttons[24] = findViewById(R.id.b25);
        click = MediaPlayer.create(getApplicationContext(), R.raw.click); // creates click and game over sound effect, pulled from res.raw
        lose = MediaPlayer.create(getApplicationContext(), R.raw.gameover);
        this.index = 100;
        this.score = 0;
        changeScore();
        changeLives();
        newBtnColor();


    }
    public void activityBack(View view){ //code for going back to the menu for the back button
        click.start();
        Intent startNewActivity = new Intent(this, MainMenu.class);
        startActivity(startNewActivity);

    }
    public void buttonCheck(View v){ // Checks id the button pushed is in fact the changed button, or another one.
        if(v.getId() == buttons[changed].getId()){
            this.score++;
            changeScore();
            newBtnColor();
            if(index > 15){
                index -= 5;
            }
            else if (index > 10){
                index--;
            }
        }
        else {
            if (lives <= 0){
                lose.setVolume(20,20);
                lose.start();
                Intent startNewActivity = new Intent(this, gameOver.class);
                startActivity(startNewActivity);
            }
            else {
                this.lives--;
                changeLives();
            }
        }
    }
    public void rndmColor(){ //creates a new random color and changed color, based off of index
        Random rnd = new Random();
        int r = rnd.nextInt(256);
        int g = rnd.nextInt(256);
        int b = rnd.nextInt(256);
        this.normalColor = Color.argb(255,r,g,b);
        r -= index;
        g -= index;
        b -= index;
        if(r < 0){
            r *= -1;
        }
        if(g < 0){
            g *= -1;
        }
        if(b < 0){
            b *= -1;
        }
        this.differentColor = Color.argb(255,r,g,b);

    }
    public void newBtnColor(){ // assigns the tiles a new color, and a random tile a different color
        Random rnd = new Random();
        rndmColor();
        this.changed = rnd.nextInt(25);
        for(int x = 0; x <= 24; x++){
            Button b = this.buttons[x];
            b.setBackgroundColor(this.normalColor);
        }
        Button b = this.buttons[this.changed];
        b.setBackgroundColor(this.differentColor);
    }
    public void changeScore(){ //updates the score
        TextView tv = findViewById(R.id.Score);
        tv.setText("Score: " + this.score);
    }
    public void changeLives(){ //updates the lives
        TextView tv = findViewById(R.id.Lives);
        tv.setText("Lives: " + this.lives);
    }
}

