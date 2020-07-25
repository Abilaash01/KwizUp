/*
    Author: Abilaash Uthayachandran
    Date: 07/24/2020

    This is a simple math quiz game program
    for kids. It has a timer to countdown
    for 30 seconds and after 30 seconds a
    score will pop up as the user's final
    score before giving the option to go back
    to the main menu or try again.
 */

package com.example.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
    This class is the main menu allowing
    the user to either start the game,
    open up the help menu or
 */

public class MainActivity extends AppCompatActivity {
    public static long totalScore;
    Button startButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalScore = 0;

        startButton = (Button) findViewById(R.id.start);
        exitButton = (Button) findViewById(R.id.exit);

        startButton.setOnClickListener((v) -> {
            Intent d = new Intent(MainActivity.this, game.class);
            startActivity(d);
            this.finish();
        });

        exitButton.setOnClickListener((v) -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        });

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
}