# COSC-310 
For COSC 310 assignment #individule,
This code is a conversation between a user and a chat bot to discuss problems It is comprised of classes:

Update: the program facilitates a conversation between a user and a bot on the topic of issues with both android and apple smarttphones.
        the newest version includes a twitter api that is able to pull resent tweets from a certain user on topics relating to tech tips
        
        in addition to twitter there was suppose to be a translation api but that did not work


--> The first class is the Apple class, it is responsible for creating the list of keywords necessary for our program to return a corresponding response. It also creates the list of prepared responses.

--> The second class is the GUI class, it is responsible for developing the user interface for our chat bot. (all the visual stuff)

--> The 3rd class is the survey class, it is responsible for providing the closing survey for users to fill out. It will also save the results of the survey to a text file.

--> The 4th class is the main class and simply responsible for creating a new GUI object

--> The 5th class is called the solution class. It is responsible for searching the device class, with the user-entered keyword, and finding a solution.

--> The 6th class is called the Test class and is used for testing our code's functionality.

--> The 7th class is called the logger class and it is responsible for recording the entire conversation between the user and bot.

--> The 8th class is a new class called the Android Class which adds functionality for android users.

--> The 9th class is a new class called Spell check and it compares incorrectly spelt words with its database to see if it can detect underlying meaning

--> The 10th class is a new class called POS which takes apart the sentences inputted by the user and separates them into parts of speech.

--> The 11th class is a new class called Digital Client. It is responsible for chatting with the other chat bot.

The rest of the classes just help the other various classes work. In summary, added features are (improved GUI, Spellcheck, Conversation with other groups (#17) bot, POS recognition, a new functionality (device), and 5 non-answer responses.
