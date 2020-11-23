# Screenshot of Game
![alt text](https://raw.githubusercontent.com/hirish99/Frogger-Arcade-Game/master/arcade.png)

In refactoring part, I have removed some unused codes and statements after understanding the codes and then I have organized the files a bit in the packages which I have created a resources folder in the p4_group_8_repo to put all the images and music theme so it will be easy to differentiate the codes and resources. 
 
In Animal class, there are some lines are repeating the same things, so i created some new methods which is setMoveImageSecond() and deathReset() to perform the extract methods and I also added the arrow keys to play game instead of just using WASD keys.

Most of the subclasses from Actor class need to set up initial image and position, so I created a method setImageXY() to set image, X, and Y in Actor class.

To improve the encapsulation, I have encapsulated most of the variables and created some get and set methods for variables so it can provide public access to the private variables.

In the addition and extension part, I have added a background for the game and adjusted the actors to fit the background because when first time running the game, there is no background at the back due to the image link is wrong or the image is not in the folder. 
                      

After that, I have added the starting scene and ending scene for the game by creating two classes called StartScene and EndScene which extends MyStage class. Inside the StartScene, there will have the basic info about the game, a text field to insert player name, and two buttons which are Start button and How To Play button.

Inside the EndScene, it will display the score of the player gets in that round and it also has a high scores list with player names. There will also have two buttons which are for Play Again and Quit Game. To display the high scores list, a ScoreList class is created to store and read the score from a text file called Score. 
    

In order to make the game more interesting, I added 5 levels for the game which Level1 is the classic mode, level2 has added five game lives, level3 has added the flies in destinations, level4 has added a snake, and level5 has increased the speed. I created three more subclasses for Actor class which are Fly, Snake, and GameLife which are needed for the levels, and five classes Level1, Level2, Level3, Level4, and Level5 which extends MyStage class to add all the needed actors into the levels.

I added two JUnit tests which are ActorTest to test out the Animal class and End class from Actor class and another is ScoreListTest to test the ScoreList class.

Lastly, I added comments in all the classes and generated Javadocs into the project.