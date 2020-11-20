package p4_group_8_repo;

import javafx.scene.image.Image;

public class Fly extends Actor {

	private Image fly;
	private Image end;
	private boolean activated;
	private boolean occupied;
	
	public Fly(int xpos, int ypos) {
		// TODO Auto-generated constructor stub
		fly = new Image("file:src/p4_group_8_repo/resources/fly.png", 60, 60, true, true);
		end = new Image("file:src/p4_group_8_repo/resources/End.png", 60, 60, true, true);
		setImageXY(xpos, ypos, end);
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if(!activated) {
			if (now/900000000  % 10 ==0||now/900000000  % 10 ==1) {
				setImage(fly);
				occupied=true;
			}
			else {
				setImage(end);
				occupied=false;
			}
		}
	}
	
	public void setEnd() {
		setImage(new Image("file:src/p4_group_8_repo/resources/FrogEnd.png", 60, 60, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public boolean isOccupied() {
		return occupied;
	}

}
