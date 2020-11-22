package p4_group_8_repo;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * this class represents Level 3 Stage of the game
 * this class is to add all the needed things into level 3's scene
 * This level includes all objects in level 2 and the newly added Fly
 * it is a subclass of MyStage
 * @author Jia Hui
 *
 */
public class Level3 extends MyStage {
	
	public Level3(MyStage background, Animal animal, GameLife life1, GameLife life2, GameLife life3, GameLife life4, GameLife life5) {
		// TODO Auto-generated constructor stub
		Text level = new Text("Level 3: Catch The Flies For More Points");
		
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
		
		background.add(life1);
		background.add(life2);
		background.add(life3);
		background.add(life4);
		background.add(life5);
		addText(level,"Verdana",18,Color.WHITE,10,780);
		background.getChildren().add(level);
		background.start();
	}

}
