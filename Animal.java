package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2;
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	private int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean stop = false;
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	public Animal(String imageLink) {
		setImageXY(300, 679.8+movement, new Image(imageLink, imgSize, imgSize, true, true));
		imgW1 = new Image("file:src/p4_group_8_repo/resources/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/resources/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/resources/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/resources/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/resources/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/resources/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/resources/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/resources/froggerRightJump.png", imgSize, imgSize, true, true);
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {}
				else {
					if (second) {
						if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {	
			                changeScore = false;
			                setMoveImageSecond(0, -movement, imgW1, false);
			            }
			            else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
			            	setMoveImageSecond(-movementX, 0, imgA1, false);
			            }
			            else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {	            	
			            	setMoveImageSecond(0, movement, imgS1, false);
			            }
			            else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {	            	
			            	setMoveImageSecond(movementX, 0, imgD1, false);
			            }
					}
					else if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {	            	
						setMoveImageSecond(0, -movement, imgW2, true);
		            }
		            else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {	            	
		            	setMoveImageSecond(-movementX, 0, imgA2, true);
		            }
		            else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {	            	
		            	setMoveImageSecond(0, movement, imgS2, true);
		            }
		            else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {	            	
		            	setMoveImageSecond(movementX, 0, imgD2, true);
		            }
				}
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						setPoints(getPoints()+10);
					}
					setMoveImageSecond(0, -movement, imgW1, false);
	            }
	            else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {	            	
	            	setMoveImageSecond(-movementX, 0, imgA1, false);
	            }
	            else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {	            	
	            	setMoveImageSecond(0, movement, imgS1, false);
	            }
	            else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {	            	
	            	setMoveImageSecond(movementX, 0, imgD1, false);
	            }
	        }
			}
			
		});
	}
	
	@Override
	public void act(long now) {
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (getX()>555) {
			move(-movement*2, 0);
		}
		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/resources/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/resources/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/resources/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				deathReset(true,false);
			}
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/resources/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/resources/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/resources/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/p4_group_8_reporesources//waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				deathReset(false,true);
			}
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				setPoints(getPoints()-50);
			}
			setPoints(getPoints()+50);
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
		}
	}
	
	public boolean getStop() {
		return end==5;
	}
	
	public void setPoints(int points) {
		this.points=points;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
	
	public void setMoveImageSecond(double a, double b, Image img, boolean c) {
		move(a,b);
		setImage(img);
		second=c;
	}
	
	public void deathReset(boolean cardeath, boolean waterdeath) {
		setImageXY(300, 679.8+movement, new Image("file:src/p4_group_8_repo/resources/froggerUp.png", imgSize, imgSize, true, true));
		if(cardeath) { carDeath = false;}
		else if(waterdeath) { waterDeath = false;}
		carD = 0;
		noMove = false;
		if (getPoints()>50) {
			setPoints(getPoints()-50); //points-=50;
			changeScore = true;
		}
	}

}
