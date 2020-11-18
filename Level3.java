package p4_group_8_repo;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Level3 extends World {

	GameLife life1 =  new GameLife(30, 500, 750);
	GameLife life2 =  new GameLife(30, 470, 750);
	GameLife life3 =  new GameLife(30, 440, 750);
	GameLife life4 =  new GameLife(30, 410, 750);
	GameLife life5 =  new GameLife(30, 380, 750);
	
	public Level3(MyStage background, Animal animal, TextField nameEnter, BackgroundImage froggerback) {
		// TODO Auto-generated constructor stub
		StartEndScreen start = new StartEndScreen();
		Text level = new Text("Level 3: Limited Life+Speed Up");
		
		background.add(froggerback);
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 0, 166, 1.7));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 220, 166, 1.7));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 440, 166, 1.7));
		background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 0, 276, -2.5));
		background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 400, 276, -2.5));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 50, 329, 1.7));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 270, 329, 1.7));
		background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 490, 329, 1.7));
		
		background.add(new Turtle(500, 376, -1.5, 130, 130));
		background.add(new Turtle(300, 376, -1.5, 130, 130));
		
		background.add(new WetTurtle(700, 376, -1.5, 130, 130));
		background.add(new WetTurtle(600, 217, -1.3, 130, 130));
		background.add(new WetTurtle(400, 217, -1.3, 130, 130));
		background.add(new WetTurtle(200, 217, -1.3, 130, 130));
		
		background.add(new End(10,96));
		background.add(new End(130,96));
		background.add(new End(130 + 130-10,96));
		background.add(new End(130 + 130-10+130-10,96));
		background.add(new End(130 + 130-10+130-10+130-10+3,96));
		
		background.add(animal);
		animal.getSpeed(-2.5, 1.7, -1.5, -1.3);
		
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 0, 649, 1.7, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 300, 649, 1.7, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 600, 649, 1.7, 120, 120));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 100, 597, -1.5, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 250, 597, -1.5, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 400, 597, -1.5, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 550, 597, -1.5, 50, 50));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 0, 540, 1.5, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 500, 540, 1.5, 200, 200));
		background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 500, 490, -9, 50, 50));
		
		//setNumber(animal.getPoints());
		background.add(life1);
		background.add(life2);
		background.add(life3);
		background.add(life4);
		background.add(life5);
		start.addText(level,"Verdana",18,Color.WHITE,10,780);
		background.getChildren().add(level);
		background.start();
	}
	
	public void removeLife(MyStage background, int life) {
		if(life==5) {	}
		else if(life==4) {
			background.remove(life5);
		}
		else if(life==3) {
			background.remove(life4);
		}
		else if(life==2) {
			background.remove(life3);
		}
		else if(life==1) {
			background.remove(life2);
		}
		else if(life==0) {
			background.remove(life1);
		}
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

}
