package p4_group_8_repo.Actor;

import javafx.scene.image.Image;

/**
 * this class represents the log object
 * it is a subclass of Actor
 */
public class Log extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed , 0); //this is to set up how the log moves 
		if (getX()>600 && speed>0)  //control where the log to start
			setX(-180); //start at the left side
		if (getX()<-300 && speed<0)
			setX(700); //start at the right side
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImageXY(xpos,ypos,new Image(imageLink, size,size, true, true));
		speed = s;
	}
	
	/**
	 * tell whether the log is moving from right to the left 
	 * @return if the log is moving from right to the left, return true
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
