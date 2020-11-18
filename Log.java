package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * this class represents the log object
 * set the image, speed, how it act
 */
public class Log extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImageXY(xpos,ypos,new Image(imageLink, size,size, true, true));
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
