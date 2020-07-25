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
    or quit the game. It has an engaging
    and colourful background as so that
    it doesn't look dull for the players.
 */

public class MainActivity extends AppCompatActivity {
    // Define the buttons and variable to store the user's score
    public static long totalScore;
    Button startButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the user's score to 0 every time the user starts the game
        totalScore = 0;

        // Initialize the buttons to map it to the XML code so you can use certain button commands
        startButton = (Button) findViewById(R.id.start);
        exitButton = (Button) findViewById(R.id.exit);

        // Whenever the user clicks on the start button do this
        startButton.setOnClickListener((v) -> {

            // Start up the game (switch activity to the game class) and close this activity
            Intent d = new Intent(MainActivity.this, game.class);
            startActivity(d);
            this.finish();
        });

        // Whenever the user clicks on the start button do this
        exitButton.setOnClickListener((v) -> {

            // Close this and every activity that came before this
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);
        });

        // Check for any open activities and close them all
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }
}