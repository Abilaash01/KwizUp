# KwizUp
Fun kids math game :)

This is a Readme file containing everything you must know about how to update the game to add any new features.


USER STORIES
------------
1. As a user I can choose the option to start or quit the game without having to close the app using the phone software.

2. As a user I receive my final score at the end of the game to view my points.

3. As a user I get 1 second after each question to check the answer if wrong.

4. As a user I have the option of playing again or going back to the home screen at the end of the game.

5. As a user the user interface is asthetically pleasing and calm.


TEST CASES
----------
**Case 1:**
1. Run the app

2. Click the start button

3. Answer a question right

4. Answer the next question wrong

5. Answer the next question wrong

6. Answer the next question right

7. Wait for timer to end

8. Click the Try Again button

**Results:**
The final score should be displayed as 10 points since you got 2 answers correct. When the timer
ends, you should be displayed with a screen that gives you two options to Try Again or go Back to
Menu. When you try again, the game should restart score set to 0.


**Case 2:**
1. Run the app

2. Click the start button

3. Answer a question right

4. Answer the next question wrong

5. Answer the next question right

6. Answer the next question right

7. Wait for timer to end

8. Click the Back to Main button

**Results:**
The final score should be displayed as 15 points since you got 3 answers correct. When the timer
ends, you should be displayed with a screen that gives you two options to Try Again or go Back to
Menu. When you click Back to Main, the game should go back to the main menu screen.


**Case 3:**
1. Run the app

2. Click the start button

3. Wait for timer to end

4. Click the Back to Main button

5. Click the Start Game button

**Results:**
The final score should be displayed as 0 since no questions were answered. When you click
Back to Main, the game should go to the main menu. When the Start Game button is clicked the
game should start up again with teh timer at 30 seconds and the score at 0.


**Case 4:**
1. Run the app

2. Click the Exit button

**Results:**
The app should quit returning you to your phone home screen.


**Case 5:**
1. Run the app

2. Click the start button

3. Wait for timer to end

4. Click the Back to Main button

5. Click the Exit Button

**Results:**
The final score should be displayed as 0 since no questions were answered. Then when you click
Back to Main you should be sent back to the main screen. Once you click Exit, the app should terminate.



CHANGING THE UI
---------------
Firstly, if you would like to make any changes to the main menu specifically, the best way to implement it is to either
modify the **MainActivity.java** file if you want to add any buttons or extra UI items. If you would like to have another
view option for example a help screen, make a new activity and modify the **MainActivity.java** so when a button is
pressed, it will start the new activity and delete the previous.

Secondly, if you would like to modify the type of questions, in **game.java**, you can find the **newQuestion** method and
modify anything in there to adjust the question type to your liking. Now if you would like to, you can also add a
**Scoreboard** by making a new activity so when the timer is up is starts the **Scoreboard** activity. All the information
relating to the timer can be seen in the **countDownTimer** method on line 315.

Whenever you want to add new buttons or textViews, be sure to add them using the .xml file corresponding to the
correct java file it's linked to.


LOCATIONS
---------
To find the necessary files to update, go to app -> src -> main -> java/com/example/quizlet and there you will see
the 2 java files. Then, when you want to check the xml files go to app -> src -> main -> res and all the files
will be there.


SUGGESTED DOWNLOADS
-------------------

Link to Android Studio download: https://developer.android.com/studio/
Link to Java JDK download: https://www.oracle.com/java/technologies/javase-downloads.html
