package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	
	@Override
	public void act(long now) {}
	
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/"+n+".png", dim, dim, true, true);
		setImageXY(x,y,im1);
	}
	
}
