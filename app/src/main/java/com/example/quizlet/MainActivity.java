package com.example.quizlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static long totalScore;
    Button startButton, helpButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalScore = 0;

        startButton = (Button) findViewById(R.id.start);
        helpButton = (Button) findViewById(R.id.help);
        exitButton = (Button) findViewById(R.id.exit);

        startButton.setOnClickListener((v) -> {
            Intent d = new Intent(MainActivity.this, game.class);
            startActivity(d);
            this.finish();
        });

        helpButton.setOnClickListener((v) -> {
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