package p4_group_8_repo.Game;

import javafx.scene.text.Text;
import p4_group_8_repo.Actor.Animal;
import p4_group_8_repo.Actor.BackgroundImage;
import p4_group_8_repo.Actor.Fly;
import p4_group_8_repo.Actor.Log;
import p4_group_8_repo.Actor.Obstacle;
import p4_group_8_repo.Actor.Snake;
import p4_group_8_repo.Actor.Turtle;
import p4_group_8_repo.Actor.WetTurtle;
import p4_group_8_repo.World.MyStage;

/**
 * this class represents Level 4 Stage of the game
 * this class is to add all the needed things into level 4's scene
 * This level includes all objects in level 3 and the newly added Snake
 * it is a subclass of MyStage
 * @author Jia Hui
 *
 */
public class Level4 {

	public Level4(MyStage background, Animal animal, GameController controller) {
		// TODO Auto-generated constructor stub
		Text level = new Text("Level 4: Watch Out For Snake!");
		controller.setText(level);
		
		background.add(new BackgroundImage("file:src/p4_group_8_repo/resources/iKogsKW.png",600,800));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 440, 166, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 400, 276, -2));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 490, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		
		background.add(new Fly(10,96));
		background.add(new Fly(130,96));
		background.add(new Fly(130 + 130-10,96));
		background.add(new Fly(130 + 130-10+130-10,96));
		background.add(new Fly(130 + 130-10+130-10+130-10+3,96));
		
		background.add(new Snake("file:src/p4_group_8_repo/resources/snakeRight.png", 0, 430, 3, 50, 50)); //add snake into the game
		
		background.add(animal);
		animal.getSpeed(-2, 0.75, -1, -1);
		
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 0, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 300, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 600, 649, 1, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 500, 490, -5, 50, 50));
		
		background.add(controller.getLife1()); //add the life of the frog
		background.add(controller.getLife2());
		background.add(controller.getLife3());
		background.add(controller.getLife4());
		background.add(controller.getLife5());
		
		background.getChildren().add(controller.LevelTitleText());
		background.start();
	}

}
