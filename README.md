# KwizUp
Fun kids math game :)

This is a Readme file containing everything you must know about how to update the game to add any new features.

Firstly, if you would like to make any changes to the main menu specifically, the best way to implement it is to either
modify the MainActivity.java file if you want to add any buttons or extra UI items. If you would like to have another
view option for example a help screen, make a new activity and modify the MainActivity.java so when a button is
pressed, it will start the new activity and delete the previous.

Secondly, if you would like to modify the type of questions, in game.java, you can find the newQuestion method and
modify anything in there to adjust the question type to your liking. Now if you would like to, you can also add a
Scoreboard by making a new activity so when the timer is up is starts the Scoreboard activity. All the information
relating to the timer can be seen in the countDownTimer method on line 315.

Whenever you want to add new buttons or textViews, be sure to add them using the .xml file corresponding to the
correct java file it's linked to.