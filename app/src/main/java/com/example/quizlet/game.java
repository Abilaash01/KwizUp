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
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.lang.String;

/*
    This class is the main part of the
    app which is the game portion. This
    part includes designing the buttons
    for each choice and a timer with
    progress bar and it also includes a
    score counter. The other main portion
    of this code is for developing each
    random question.
 */

public class game extends AppCompatActivity {
    // Defines the buttons and text screens
    Button c1, c2, c3, c4, t, b;
    public int q1, q2, solution, error1, error2, error3;
    public int secondsRemaining = 30;

    // Defines and initializes the array for each choice
    private String[] mcq = new String[4];
    private Random random = new Random();
    private int c;
    TextView txt, timer, sc;
    ProgressBar prog;
    game g;

    /*
        This method creates and displays all the
        data that is processed such as the textview,
        the score, timer and the button choices
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Links and initializes the buttons and textviews to the corresponding xml file
        txt = (TextView) findViewById(R.id.questionBar);
        timer = (TextView) findViewById(R.id.time);
        sc = (TextView) findViewById(R.id.scoreBoard);
        c1 = (Button) findViewById(R.id.choiceA);
        c2 = (Button) findViewById(R.id.choiceB);
        c3 = (Button) findViewById(R.id.choiceC);
        c4 = (Button) findViewById(R.id.choiceD);
        t = (Button) findViewById(R.id.tryAgain);
        b = (Button) findViewById(R.id.backToMain);
        prog = (ProgressBar) findViewById(R.id.progressBar);

        // Sets a font type for the question view
        Typeface typer = Typeface.createFromAsset(getAssets(), "fonts/Brightly Crush Shine.otf");
        txt.setTypeface(typer);

        // Sets the choices buttons to visible and the try again and main menu button to invisible
        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);
        c3.setVisibility(View.VISIBLE);
        c4.setVisibility(View.VISIBLE);

        t.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);

        // Sets the timer and progress timer to 30 seconds
        secondsRemaining = 30;

        // Sets up the new set of questions with corresponding answers
        newQuestion();
        setUp();
        countDownTimer.start();

        // If first button is clicked run through this method
        c1.setOnClickListener((v) -> {
            // Sets all the buttons to non-clickable
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);

            // If the answer is correct give a point if not don't give any points
            if (Integer.parseInt(c1.getText().toString()) == solution) {
                // Set colour of chosen answer to green
                c1.setBackgroundColor(Color.parseColor("#2CFF00"));
                MainActivity.totalScore += 5;
            } else {
                // Set colour of chosen answer to red
                c1.setBackgroundColor(Color.parseColor("#FF0000"));

                // Set colour of correct answer to green
                if (Integer.parseInt(c1.getText().toString()) == solution) {
                    c1.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c2.getText().toString()) == solution) {
                    c2.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c3.getText().toString()) == solution) {
                    c3.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c4.getText().toString()) == solution) {
                    c4.setBackgroundColor(Color.parseColor("#2CFF00"));
                }
            }

            // Set up a delay before going to next question
            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Set up the new question
                    newQuestion();
                    setUp();
                }
            }, 800);
        });

        // If second button is clicked run through this method
        c2.setOnClickListener((v) -> {
            // Sets all the buttons to non-clickable
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);

            // If the answer is correct give a point if not don't give any points
            if (Integer.parseInt(c2.getText().toString()) == solution) {
                // Set colour of chosen answer to green
                c2.setBackgroundColor(Color.parseColor("#2CFF00"));
                MainActivity.totalScore += 5;
            } else {
                // Set colour of chosen answer to red
                c2.setBackgroundColor(Color.parseColor("#FF0000"));

                // Set colour of correct answer to green
                if (Integer.parseInt(c1.getText().toString()) == solution) {
                    c1.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c2.getText().toString()) == solution) {
                    c2.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c3.getText().toString()) == solution) {
                    c3.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c4.getText().toString()) == solution) {
                    c4.setBackgroundColor(Color.parseColor("#2CFF00"));
                }
            }

            // Set up a delay before going to next question
            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Set up the new question
                    newQuestion();
                    setUp();
                }
            }, 800);
        });

        // If third button is clicked run through this method
        c3.setOnClickListener((v) -> {
            // Sets all the buttons to non-clickable
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);

            // If the answer is correct give a point if not don't give any points
            if (Integer.parseInt(c3.getText().toString()) == solution) {
                // Set colour of chosen answer to green
                c3.setBackgroundColor(Color.parseColor("#2CFF00"));
                MainActivity.totalScore += 5;
            } else {
                // Set colour of chosen answer to red
                c3.setBackgroundColor(Color.parseColor("#FF0000"));

                // Set colour of correct answer to green
                if (Integer.parseInt(c1.getText().toString()) == solution) {
                    c1.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c2.getText().toString()) == solution) {
                    c2.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c3.getText().toString()) == solution) {
                    c3.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c4.getText().toString()) == solution) {
                    c4.setBackgroundColor(Color.parseColor("#2CFF00"));
                }
            }

            // Set up a delay before going to next question
            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Set up the new question
                    newQuestion();
                    setUp();
                }
            }, 800);
        });

        // If fourth button is clicked run through this method
        c4.setOnClickListener((v) -> {
            // Sets all the buttons to non-clickable
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);

            // If the answer is correct give a point if not don't give any points
            if (Integer.parseInt(c4.getText().toString()) == solution) {
                // Set colour of chosen answer to green
                c4.setBackgroundColor(Color.parseColor("#2CFF00"));
                MainActivity.totalScore += 5;
            } else {
                // Set colour of chosen answer to red
                c4.setBackgroundColor(Color.parseColor("#FF0000"));

                // Set colour of correct answer to green
                if (Integer.parseInt(c1.getText().toString()) == solution) {
                    c1.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c2.getText().toString()) == solution) {
                    c2.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c3.getText().toString()) == solution) {
                    c3.setBackgroundColor(Color.parseColor("#2CFF00"));
                } else if (Integer.parseInt(c4.getText().toString()) == solution) {
                    c4.setBackgroundColor(Color.parseColor("#2CFF00"));
                }
            }

            // Set up a delay before going to next question
            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Set up the new question
                    newQuestion();
                    setUp();
                }
            }, 800);
        });
    }

    /*
        This method is used for mixing up
        the choices to be in random order.
     */
    private String[] shuffleArray(String[] mcqNew) {
        // Make a new arraylist
        ArrayList<String> temp = new ArrayList<String>();
        Random r = new Random();

        // Swap the element with a random other element
        for(int i = mcqNew.length - 1; i > 0; i--) {
            int ind = r.nextInt(1 + i);

            while(temp.contains(mcq[ind])) {
                ind = r.nextInt(1 + i);
            }

            temp.add(mcq[ind]);
            String a = mcqNew[ind];
            mcqNew[ind] = mcqNew[i];
            mcqNew[i] = a;
        }

        return mcqNew;
    }


    /*
        This is the countdown timer that goes
        from 30 to 0.
     */
    CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
        @Override
        // Every second display the time remaining and decrease the bar size
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            prog.setProgress(secondsRemaining);
            timer.setText("Time Remaining: " + secondsRemaining);
        }

        @Override
        // When the time is up disable everything and display the try again and main menu button
        public void onFinish() {
            timer.setText("Time's Up");
            txt.setText("YOUR FINAL SCORE: " + MainActivity.totalScore);

            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);

            // Set all button colours to blue
            c1.setBackgroundColor(Color.parseColor("#000EFF"));
            c2.setBackgroundColor(Color.parseColor("#000EFF"));
            c3.setBackgroundColor(Color.parseColor("#000EFF"));
            c4.setBackgroundColor(Color.parseColor("#000EFF"));

            // Start a delay timer
            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                // Start the new page
                public void run() {
                    MainActivity.totalScore = 0;
                    t.setEnabled(true);
                    b.setEnabled(true);

                    c1.setVisibility(View.INVISIBLE);
                    c2.setVisibility(View.INVISIBLE);
                    c3.setVisibility(View.INVISIBLE);
                    c4.setVisibility(View.INVISIBLE);

                    t.setVisibility(View.VISIBLE);
                    b.setVisibility(View.VISIBLE);

                    t.setOnClickListener((v) -> {
                        secondsRemaining = 30;
                        MainActivity.totalScore = 0;
                        g = new game();
                        newQuestion();
                        setUp();
                        countDownTimer.start();
                    });

                    b.setOnClickListener((v) -> {
                        Intent i = new Intent(game.this, MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);

                        if (getIntent().getBooleanExtra("GAME", false)) {
                            finish();
                        }
                    });
                }
            }, 1000);
        }
    };

    // Create a new question
    private void newQuestion() {
        q1 = random.nextInt(11);
        q2 = random.nextInt(11);

        if(MainActivity.totalScore > 0) {
            sc.setText("Score: " + Long.toString(MainActivity.totalScore));
        } else {
            sc.setText("Score: 0");
        }

        error1 = random.nextInt(5);
        error2 = random.nextInt(10);
        error3 = random.nextInt(3);

        while(error1 == error2 || error1 == error3 || error3 == error2 || error3 == 0 || error2 == 0 || error1 == 0) {
            error1 = random.nextInt(5);
            error2 = random.nextInt(10);
            error3 = random.nextInt(3);
        }

        c = random.nextInt(2);

        if(c == 0) {
            solution = q1 - q2;
        } else if(c == 1) {
            solution = q1 + q2;
        }

        mcq[0] = Integer.toString(solution);
        mcq[1] = Integer.toString(solution + error1);
        mcq[2] = Integer.toString(solution - error2);
        mcq[3] = Integer.toString(solution - error3);

        shuffleArray(mcq);

        c1.setText(mcq[0]);
        c2.setText(mcq[1]);
        c3.setText(mcq[2]);
        c4.setText(mcq[3]);
    }

    private void setUp() {
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
        t.setEnabled(false);
        b.setEnabled(false);

        c1.setVisibility(View.VISIBLE);
        c2.setVisibility(View.VISIBLE);
        c3.setVisibility(View.VISIBLE);
        c4.setVisibility(View.VISIBLE);

        t.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);

        c1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        c2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        c3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        c4.setBackgroundColor(Color.parseColor("#FFFFFF"));

        if(c == 0) {
            txt.setText("What is " + q1 + " - " + q2 + "?");
        } else if(c == 1) {
            txt.setText("What is " + q1 + " + " + q2 + "?");
        }
    }
}