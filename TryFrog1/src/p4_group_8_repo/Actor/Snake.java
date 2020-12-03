package p4_group_8_repo.Actor;

import javafx.scene.image.Image;

/**
 * this class represents the actor snake 
 * it is a subclass of Actor
 * @author Jia Hui
 *
 */
public class Snake extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Snake(String imageLink, int xpos, int ypos, double s, int w, int h) {
		// TODO Auto-generated constructor stub
		setImageXY(xpos,ypos,new Image(imageLink, w,h, true, true));
		speed = s;
	}

}
