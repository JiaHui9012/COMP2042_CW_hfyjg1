package p4_group_8_repo.Game;

import p4_group_8_repo.Actor.Animal;
import p4_group_8_repo.World.MyStage;

/**
 * this class is to control the five levels
 * @author Jia Hui
 *
 */
public class Levels {

	private MyStage background;
	private Animal animal;
	private GameController controller;
	private boolean nextLevel;
	
	public Levels(MyStage background, Animal animal, GameController controller, boolean nextLevel) {
		// TODO Auto-generated constructor stub
		this.background = background;
		this.animal = animal;
		this.controller = controller;
		this.nextLevel = nextLevel;
	}
	
	/**
	 * method to call level 1
	 */
	public void Level1() { 
		new Level1(background,animal,controller);
		nextLevel=true;
	}
	
	/**
	 * method to call level 2
	 */
	public void Level2() {
		new Level2(background,animal, controller);
		controller.setPoints(animal.getPoints());
		controller.setNumber();
		nextLevel=true;
		
	}
	
	/**
	 * method to call level 3
	 */
	public void Level3() { 
		new Level3(background,animal, controller);
		controller.setPoints(animal.getPoints());
		controller.setNumber();
		nextLevel=true;
	}
	
	/**
	 * method to call level 4
	 */
	public void Level4() { 
		new Level4(background,animal, controller);
		controller.setPoints(animal.getPoints());
		controller.setNumber();
		nextLevel=true;
	}
	
	/**
	 * method to call level 5
	 */
	public void Level5() { 
		new Level5(background,animal, controller);
		controller.setPoints(animal.getPoints());
		controller.setNumber();
		nextLevel=false;
	}
	
	/**
	 * get the value of the variable nextLevel
	 * @return the value of the variable nextLevel
	 */
	public boolean getNextLevel() {
		return nextLevel;
	}

}
