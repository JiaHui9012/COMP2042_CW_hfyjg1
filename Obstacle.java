package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * this class represents the obstacle and its action
 * @author Jia Hui
 *
 */
public class Obstacle extends Actor {
	private double speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImageXY(xpos,ypos,new Image(imageLink, w,h, true, true));
		speed = s;
	}

}
