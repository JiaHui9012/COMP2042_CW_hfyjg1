package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * this class represents the destinations of the animal(frog)
 * it is a subclass of Actor
 * @author Jia Hui
 *
 */
public class End extends Actor{
	private boolean activated = false;
	
	public End() {}
	
	@Override
	public void act(long now) {}
	
	public End(int x, int y) {
		setImageXY(x,y,new Image("file:src/p4_group_8_repo/resources/End.png", 60, 60, true, true));
	}
	
	/**
	 * this method is to set the image when the frog is occupied the destination
	 */
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/resources/FrogEnd.png", 60, 60, true, true));
		activated = true;
	}
	
	/**
	 * tell whether the destination is already occupied by the frog
	 * @return return activated = true, when the destination is already occupied by the frog; else activated = false
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
