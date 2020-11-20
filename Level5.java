package p4_group_8_repo;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * this class represents Level 5 of the game
 * this class is to add all the needed things into level 5's scene
 * This level includes all objects in level 4, but their speed has changed more faster
 * @author Jia Hui
 *
 */
public class Level5 extends World {

	public Level5(MyStage background, Animal animal, BackgroundImage froggerback, GameLife life1, GameLife life2, GameLife life3, GameLife life4, GameLife life5) {
		// TODO Auto-generated constructor stub
		StartEndScreen start = new StartEndScreen();
		Text level = new Text("Level 4: Speed Up");
		
		background.add(froggerback);
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 0, 166, 1.35));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 220, 166, 1.35));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 440, 166, 1.35));
		background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 0, 276, -2.2));
		background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 400, 276, -2.2));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 50, 329, 1.35));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 270, 329, 1.35));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 490, 329, 1.35));
		
		background.add(new Turtle(500, 376, -1.3, 130, 130));
		background.add(new Turtle(300, 376, -1.3, 130, 130));
		
		background.add(new WetTurtle(700, 376, -1.3, 130, 130));
		background.add(new WetTurtle(600, 217, -1.2, 130, 130));
		background.add(new WetTurtle(400, 217, -1.2, 130, 130));
		background.add(new WetTurtle(200, 217, -1.2, 130, 130));
		
		background.add(new Fly(10,96));
		background.add(new Fly(130,96));
		background.add(new Fly(130 + 130-10,96));
		background.add(new Fly(130 + 130-10+130-10,96));
		background.add(new Fly(130 + 130-10+130-10+130-10+3,96));
		
		background.add(new Snake("file:src/p4_group_8_repo/resources/snakeRight.png", 0, 430, 4, 50, 50));
		
		background.add(animal);
		animal.getSpeed(-2.2, 1.35, -1.3, -1.2);
		
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 0, 649, 1.5, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 300, 649, 1.5, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 600, 649, 1.5, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 100, 597, -1.35, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 250, 597, -1.35, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 400, 597, -1.35, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 550, 597, -1.35, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 0, 540, 1.5, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 500, 540, 1.5, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 500, 490, -7, 50, 50));
		
		background.add(life1);
		background.add(life2);
		background.add(life3);
		background.add(life4);
		background.add(life5);
		start.addText(level,"Verdana",18,Color.WHITE,10,780);
		background.getChildren().add(level);
		background.start();
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

}
