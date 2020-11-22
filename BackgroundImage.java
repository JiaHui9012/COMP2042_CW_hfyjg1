package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * this class is to set the images that needed in the game
 * it is a subclass of Actor
 * @author Jia Hui
 *
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {}
	
	public BackgroundImage(String imageLink, int size1, int size2) {
		setImage(new Image(imageLink, size1, size2, true, true));
	}

}
