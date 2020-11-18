package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * this class represents the destinations of the animal(frog)
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
	
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/resources/FrogEnd.png", 60, 60, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
