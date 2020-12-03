package p4_group_8_repo.Game;

import p4_group_8_repo.Actor.Animal;
import p4_group_8_repo.Actor.BackgroundImage;
import p4_group_8_repo.EndScene.EndScene;
import p4_group_8_repo.World.MyStage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * game section
 * control the levels, actors
 * @author Jia Hui
 *
 */
public class Game extends Application {
	
	private AnimationTimer timer;
	private MyStage background;
	private Animal animal = new Animal("file:src/p4_group_8_repo/resources/froggerUp.png");
	private TextField nameEnter;
	private Stage primaryStage;
	private boolean nextLevel=false;
	private int levelCount=1;
	private GameModel model = new GameModel();
	private GameView view = new GameView(model);
	private GameController controller = new GameController(model,view);
	
	public Game() { }
	
	public Game(TextField nameEnter,Stage primaryStage,MyStage background) {
		// TODO Auto-generated constructor stub
		this.nameEnter = nameEnter;
		this.primaryStage = primaryStage;
		this.background = background;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene  = new Scene(background,564,800);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		background.add(new BackgroundImage("file:src/p4_group_8_repo/resources/iKogsKW.png",600,800));
		controller.setMyStage(background);
		controller.setAnimal(animal);
		Level1(); //start level 1
		start();  //start timer
	}

	public void Level1() {  //method call level 1
		levelCount=1;
		new Level1(background,animal,controller);
		nextLevel=true;
	}
	
	public void Level2() {  //start level 2
		new Level2(background,animal, controller);
		controller.setPoints(animal.getPoints());
		controller.setNumber();
		nextLevel=true;
		
	}
	
	public void Level3() {  //start level 3
		new Level3(background,animal, controller);
		controller.setPoints(animal.getPoints());
		controller.setNumber();
		nextLevel=true;
	}
	
	public void Level4() {  //start level 4
		new Level4(background,animal, controller);
		controller.setPoints(animal.getPoints());
		controller.setNumber();
		nextLevel=true;
	}
	
	public void Level5() {  //start level 5
		new Level5(background,animal, controller);
		controller.setPoints(animal.getPoints());
		controller.setNumber();
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) { //if change score is true, then set up the digits
            		controller.setPoints(animal.getPoints());
            		controller.setNumber();
            	}
            	if(animal.getLife()<5&&levelCount!=1) { //if the life is less than five and is not in level 1, then tell the background to remove the life 
            		controller.setLifeNumber(animal.getLife());
            		controller.removeLife();
            	}
            	if(animal.getStop()&&nextLevel) { //when a level is completed which all the destinations are occupied and next level is activated, then
            		levelCount++;  //increase the level
    	            stop();  //stop the background
    	            background.stop();  //stop the animations of the actors
    	            background.getChildren().clear(); //clear all the actors
    				start(); //start again the background
            		animal.setEnd(); // reset the destinations number
            		animal.setLife(5); //reset the game life to 5
            		nextLevel=false; //deactivate the next level
            		if(levelCount==2) { //if level count = 2, then start level 2
            			Level2();
            		}
            		else if(levelCount==3) { //if level count = 3, then start level 3
            			Level3();
            		}
            		else if(levelCount==4) { //if level count = 4, then start level 4
            			Level4();
            		}
            		else if(levelCount==5) { //if level count = 5, then start level 5
            			Level5();
            		}
    			}
            	if ((animal.getStop()||animal.getLife()==0)&&levelCount!=1) { //if the destinations are all occupied or the 5 life are finished, and it is not level 1
            		EndScene endScene = new EndScene(background,animal,nameEnter,timer);
            		try {
						endScene.start(primaryStage); //call end scene
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            }
        };
    }
	
	public void start() { //start the game 
    	createTimer();
        timer.start();
    }

    public void stop() { //stop the game
        timer.stop();
    }
	
}
