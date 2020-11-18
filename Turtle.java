package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * this class represents the turtle
 * set the image, speed, acting,...
 * @author Jia Hui
 *
 */
public class Turtle extends Actor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private double speed;
	
	@Override
	public void act(long now) {
		if (now/900000000  % 3 ==0) {
			setImage(turtle2);
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtle1);
		}
		else if (now/900000000 %3 == 2) {
			setImage(turtle3);
		}
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:src/p4_group_8_repo/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/p4_group_8_repo/resources/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/p4_group_8_repo/resources/TurtleAnimation3.png", w, h, true, true);
		setImageXY(xpos,ypos,turtle2);
		speed = s;
	}
	
	public double getSpeed() {
		return speed;
	}
	
}
