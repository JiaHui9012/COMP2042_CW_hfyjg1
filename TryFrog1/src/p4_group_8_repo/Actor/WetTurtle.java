package p4_group_8_repo.Actor;

import javafx.scene.image.Image;

/**
 * this class represents the wet turtle
 * it is a subclass of Actor
 * @author Jia Hui
 *
 */
public class WetTurtle extends Actor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	private double speed;
	private boolean sunk = false;
	
	@Override
	public void act(long now) {
		if (now/900000000  % 4 ==0) {
			setImage(turtle2);
			sunk = false;
		}
		else if (now/900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtle3);
			sunk = false;
		}
		else if (now/900000000 %4 == 3) {
			setImage(turtle4);
			sunk = true;
		}
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	public WetTurtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:src/p4_group_8_repo/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/resources/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/resources/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/p4_group_8_repo/resources/TurtleAnimation4Wet.png", w, h, true, true);
		setImageXY(xpos,ypos,turtle2);
		speed = s;
	}
	
	public boolean isSunk() {
		return sunk;
	}
}
