package p4_group_8_repo.Actor;

import javafx.scene.image.Image;

/**
 * this class represents the game life
 * it is a subclass of Actor
 * @author Jia Hui
 *
 */
public class GameLife extends Actor {

	private Image im1;
	
	public GameLife(int dim, int x, int y) {
		// TODO Auto-generated constructor stub
		im1 = new Image("file:src/p4_group_8_repo/resources/video game life.png", dim, dim, true, true);
		setImageXY(x, y, im1);
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

}
