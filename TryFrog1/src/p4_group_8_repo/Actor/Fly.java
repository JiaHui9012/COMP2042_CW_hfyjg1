package p4_group_8_repo.Actor;

import javafx.scene.image.Image;

/**
 * this class represents the fly with the destination
 * it is a subclass of Actor
 * @author Jia Hui
 *
 */
public class Fly extends Actor {

	private Image fly;
	private Image end;
	private boolean activated;
	private boolean occupied;
	
	public Fly() {}
	
	public Fly(int xpos, int ypos) {
		// TODO Auto-generated constructor stub
		fly = new Image("file:src/p4_group_8_repo/resources/fly.png", 60, 60, true, true);
		end = new Image("file:src/p4_group_8_repo/resources/End.png", 60, 60, true, true);
		setImageXY(xpos, ypos, end); //set the destination of the frog first
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(!activated) {
			if (now/900000000  % 10 ==0||now/900000000  % 10 ==1) { //in certain times, set the fly to appear at the destination
				setImage(fly);
				occupied=true;
			}
			else {
				setImage(end);
				occupied=false;
			}
		}
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
	 * @return activated = true, when the destination is already occupied by the frog; else activated = false
	 */
	public boolean isActivated() {
		return activated;
	}
	
	/**
	 * tell whether the destination is being occupied by the fly
	 * @return occupied = true, when the fly is occupying the destination; else it will return false
	 */
	public boolean isOccupied() {
		return occupied;
	}

}
