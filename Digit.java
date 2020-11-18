package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * this class represents the digit that appears in the top right screen to indicate the score 
 * @author Jia Hui
 *
 */
public class Digit extends Actor{
	
	Image im1;
	
	@Override
	public void act(long now) {}
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/resources/"+n+".png", dim, dim, true, true);
		setImageXY(x,y,im1);
	}
	
}
