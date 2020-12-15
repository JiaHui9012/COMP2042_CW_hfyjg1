package p4_group_8_repo.Actor;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * this class represents the characters/animals of the game which is the frog 
 * it is a subclass of Actor
 * 
 * @author Jia Hui
 *
 */
public class Animal extends Actor {
	private Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
	private int points = 0, end = 0, imgSize = 40;
	private boolean second = false, noMove = false;
	private double movement = 13.3333333*2, movementX = 10.666666*2;
	private boolean carDeath = false, waterDeath = false;
	private boolean changeScore = false, changeDigit=false;
	private int death = 0, life=5;
	private double w = 800;
	private double speed[] = new double[4];
	
	public Animal() {}
	
	/**
	 * this constructor is to set up the initial looks of the animal frog when it faces different directions
	 * @param imageLink this parameter is the link of the image
	 */
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
						if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {	//move up
			                changeScore = false;
			                setMoveImageSecond(0, -movement, imgW1, false);
			            }
			            else if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {  //move left
			            	setMoveImageSecond(-movementX, 0, imgA1, false);
			            }
			            else if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {	 //move down      	
			            	setMoveImageSecond(0, movement, imgS1, false);
			            }
			            else if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {  //move right            	
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
							setPoints(getPoints()+10); //points+=10;
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
		if (getY()<0 || getY()>734) {  //when the animal near the upper/lower screen, it will jump back to the initial position to avoid it jumps out of the screen 
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {  //when the animal near the left screen/ it jumps out of the left screen,it will automatically jump back to the screen
			move(movement*2, 0);
		}
		if (getX()>555) {  //when the animal near the right screen/ it jumps out of the right screen, it will automatically jump back to the screen
			move(-movement*2, 0);
		}
		if (carDeath) {  // this represents how the frog acts if it gets road kill
			CarDeath(now);
		}
		if (waterDeath) {  // this represents how the frog acts if it jumps into the river
			WaterDeath(now);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {  //if the frog gets intersecting with the obstacle, then carDeath=true
			carDeath = true;
		}
		if (getIntersectingObjects(Snake.class).size() >= 1) {  //if the frog gets intersecting with the snake, then carDeath=true
			carDeath = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {  //if the frog gets intersecting with the log
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(speed[0],0); //move the animal in the speed with the object
			else
				move (speed[1],0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {  //if the frog gets intersecting with the turtle
			move(speed[2],0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {  //if the frog gets intersecting with the wet turtle
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {  //if the wet turtle is sunk when the frog still gets intersecting with it, then waterDeath=true
				waterDeath = true;
			} else {
				move(speed[3],0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {  //if the frog gets intersecting with its destination
			if (getIntersectingObjects(End.class).get(0).isActivated()) {  //if the frog jumps to the destination that is already occupied by other frogs
				end--;
				deductPoints(); //points-=50; deduct the points
			}
			setPoints(getPoints()+50);  //points+=50; earn points
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300); //reset the x position of the frog
			setY(679.8+movement); //reset the y position of the frog
		}
		else if(getIntersectingObjects(Fly.class).size() >= 1) { //if the frog gets intersecting with flies in the destinations
			if (getIntersectingObjects(Fly.class).get(0).isActivated()) {  //if the frog jumps to the destination that is already occupied by other frogs
				end--;
				deductPoints(); //points-=50; deduct the points
			}
			else {
				if(getIntersectingObjects(Fly.class).get(0).isOccupied()) { //if the frog catches a fly then earns extra 50 points which is total 100 points
					setPoints(getPoints()+100);
				}
				else {
					setPoints(getPoints()+50);
				}
			}
			changeScore = true;
			w=800;
			getIntersectingObjects(Fly.class).get(0).setEnd();
			end++;
			setX(300); //reset the x position of the frog
			setY(679.8+movement); //reset the y position of the frog
		}
		else if (getY()<413){  //if the frog jumps into the river, then waterDeath=true
			waterDeath = true;
		}
	}
	
	/**
	 * this method represents if the five destinations are occupied, then it will return true
	 * @return returns true if the parameter end equals to 5
	 */
	public boolean getStop() {
		return end==5;
	}
	
	/**
	 * reset the end to 0
	 */
	public void setEnd() {
		end=0;
	}
	
	/**
	 * get the integer of the parameter end
	 * @return return how many destinations are occupied
	 */
	public int getEnd() {
		return end;
	}
	
	/**
	 * set the life
	 * @param life it indicates how many life to set up 
	 */
	public void setLife(int life) {
		this.life=life;
	}
	
	/**
	 * get the integer of the parameter life
	 * @return return how many life left
	 */
	public int getLife() {
		return this.life;
	}
	
	/**
	 * set the score of the player into the points
	 * @param points it is the score of the player gets
	 */
	public void setPoints(int points) {
		this.points=points;
	}
	
	/**
	 * get the points
	 * @return return the current points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * this method is to decrease the points and check if the length of previous point are longer than the current points,
	 * if yes, then changeDigit = true 
	 */
	public void deductPoints() {
		if (getPoints()>50) {
			int temp=getPoints();
			setPoints(getPoints()-50);
			if((temp+"").length()>(getPoints()+"").length()) {
				changeDigit=true;
			}
		}
	}
	
	/**
	 * reset the changeDigit to false
	 */
	public void resetChangeDigit() {
		changeDigit=false;
	}
	
	/**
	 * get the value of changeDigit
	 * @return return true if needed to change the digit 
	 */
	public boolean getChangeDigit() {
		return changeDigit;
	}
	
	/**
	 * this method is to indicate if the screen needs to change score 
	 * @return if yes return true and reset the changeScore to false, else return false 
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}
	
	/**
	 * this method is to set up the move, image, second status of the frog for each keys is pressed/released
	 * @param a this parameter is to set X
	 * @param b this parameter is to set Y
	 * @param img this is to set the image of the frog
	 * @param c this is to set the variable second  
	 */
	public void setMoveImageSecond(double a, double b, Image img, boolean c) {
		move(a,b);
		setImage(img);
		second=c;
	}
	
	/**
	 * method to set the death images of the frog if the frog gets hit by the car
	 * @param now the current time stamp of the current frame given in nanoseconds
	 */
	public void CarDeath(long now) {
		noMove = true;
		if ((now)% 11 ==0) { 
			death++;
		}
		switch(death) {
		case 1: setImage(new Image("file:src/p4_group_8_repo/resources/cardeath1.png", imgSize, imgSize, true, true));
				break;
		case 2: setImage(new Image("file:src/p4_group_8_repo/resources/cardeath2.png", imgSize, imgSize, true, true));
				break;
		case 3: setImage(new Image("file:src/p4_group_8_repo/resources/cardeath3.png", imgSize, imgSize, true, true));
				break;
		case 4: deathReset(true,false);  //when it dies, the system will reset the frog to the initial position 
				break;
		default:
				break;
		}
	}
	
	/**
	 * method to set the images of the frog if the frog jumps into the water
	 * @param now the current time stamp of the current frame given in nanoseconds
	 */
	public void WaterDeath(long now) {
		noMove = true;
		if ((now)% 11 ==0) {
			death++;
		}
		switch(death) {
		case 1: setImage(new Image("file:src/p4_group_8_repo/resources/waterdeath1.png", imgSize,imgSize , true, true));
				break;
		case 2: setImage(new Image("file:src/p4_group_8_repo/resources/waterdeath2.png", imgSize,imgSize , true, true));
				break;
		case 3: setImage(new Image("file:src/p4_group_8_repo/resources/waterdeath3.png", imgSize,imgSize , true, true));
				break;
		case 4: setImage(new Image("file:src/p4_group_8_reporesources//waterdeath4.png", imgSize,imgSize , true, true));
				break;
		case 5: deathReset(false,true); //when it disappears in the screen, the system will reset the frog to the initial position
				break;
		default:
				break;
		}
	}
	
	/**
	 * this method is to reset the frog when it dies/jumps into the river  
	 * @param cardeath this parameter is to indicate if it is a car death
	 * @param waterdeath this parameter is to indicate if it is a water death
	 */
	public void deathReset(boolean cardeath, boolean waterdeath) {
		life--; //deduct the life when death happened
		setImageXY(300, 679.8+movement, new Image("file:src/p4_group_8_repo/resources/froggerUp.png", imgSize, imgSize, true, true)); //reset the image of the frog
		if(cardeath) { carDeath = false;} //reset the carDeath to false
		else if(waterdeath) { waterDeath = false;} //reset the waterDeath to false
		death = 0; //reset death = 0
		noMove = false; //reset noMove to false
		deductPoints(); //deduct points method
		changeScore = true; //indicate to change score
	}
	
	/**
	 * get the speeds of the objects in the river to set the speed of the animal, this is to let the animal moves the same speed when it stands on the moving objects
	 * @param log represents the speed of log 
	 * @param logLeft represents the speed of log moving left 
	 * @param turtle represents the speed of turtle 
	 * @param wetTurtle represents the speed of wet turtle
	 */
	public void getSpeed(double log, double logLeft, double turtle, double wetTurtle) {
		speed[0] = log;  //set the speed of the log moving right from the left into the array which index is 0
		speed[1] = logLeft; //set the speed of the log moving left from the right into the array which index is 1 
		speed[2] = turtle; //set the speed of the turtle into the array which index is 2 
		speed[3] = wetTurtle; //set the speed of the wetTurtle into the array which index is 3 
	}

}
