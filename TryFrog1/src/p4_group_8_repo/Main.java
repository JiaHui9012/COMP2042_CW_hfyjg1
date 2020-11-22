package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {
	private AnimationTimer timer;
	private MyStage background = new MyStage();
	private Animal animal = new Animal("file:src/p4_group_8_repo/resources/froggerUp.png");
	private TextField nameEnter = new TextField("Player");
	private boolean nextLevel=false;
	private int levelCount=1;
	private GameLife life1 =  new GameLife(30, 500, 750);
	private GameLife life2 =  new GameLife(30, 470, 750);
	private GameLife life3 =  new GameLife(30, 440, 750);
	private GameLife life4 =  new GameLife(30, 410, 750);
	private GameLife life5 =  new GameLife(30, 380, 750);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception { //setting up the scene and start the game
		Scene scene  = new Scene(background,564,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		start(); 
		startGame();	
	}
	
	public void startGame() {  //start the game
		new StartScene(background,animal,nameEnter);
		nextLevel=true;
	}
	
	public void Level2() {  //start level 2
		new Level2(background,animal, life1, life2, life3, life4 ,life5);
		setNumber(animal.getPoints());
		nextLevel=true;
		
	}
	
	public void Level3() {  //start level 3
		new Level3(background,animal, life1, life2, life3, life4 ,life5);
		setNumber(animal.getPoints());
		nextLevel=true;
	}
	
	public void Level4() {  //start level 4
		new Level4(background,animal, life1, life2, life3, life4 ,life5);
		setNumber(animal.getPoints());
		nextLevel=true;
	}
	
	public void Level5() {  //start level 5
		new Level5(background,animal, life1, life2, life3, life4 ,life5);
		setNumber(animal.getPoints());
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) { //if change score is true, then set up the digits
            		setNumber(animal.getPoints());
            	}
            	if(animal.getLife()<5&&levelCount!=1) { //if the life is less than five and is not in level 1, then tell the background to remove the life 
            		removeLife(animal.getLife());
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
            			Level3();
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
            		new EndScene(background,animal,nameEnter);

		    		System.out.print("STOPP\n");
    	            stop(); // stop background running
    	            background.stop(); // stop actors' animation
		    		
		    		Button playAgain = new Button("Play Again");
		    		background.addButton(playAgain, 110, 700, 150, 50);
		    		background.getChildren().add(playAgain);
		    		playAgain.setOnAction(new EventHandler<ActionEvent>() { //if the play again button gets pressed, then restart the game
		    			@Override
		    		    public void handle(ActionEvent event) {
		    				background.getChildren().clear(); // clear everything
		    				animal.setPoints(0);  //reset points to 0
		    				animal.setEnd();  //reset the destinations
		    				start(); //start background scene again
		    				startGame(); //start the game in the beginning
		    				levelCount=1;  //set the level count to 1
		    			}
		    		});
		    		
		    		Button quit = new Button("Quit");
		    		background.addButton(quit, 300, 700, 150, 50);
		    		background.getChildren().add(quit);
		    		quit.setOnAction(new EventHandler<ActionEvent>() { //if the quit button gets pressed, then the platform will be closed
		    			@Override
		    		    public void handle(ActionEvent event) {
		    				background.stopMusic(); //stop music
		    	            Platform.exit();  //exit the game
		    			}
		    		});
            	}
            }
        };
    }
	
	public void start() { //start the game 
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() { //stop the game
        timer.stop();
    }
    
    /**
     * this method is to set up the digits on the screen based on the points to show the current score
     * @param n the points
     */
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		int d = n / 10;
    		int k = n - d * 10;
    		n = d;
    		background.add(new Digit(k, 30, 500 - shift, 30));
    		if(animal.getChangeDigit()) {  //this is to avoid the error on setting up the digits, especially when the points is being deducting from longer length to shorter length  
    		background.add(new Digit(0, 30, 470 - shift, 30)); //example: when the previous point is 1030, the current point is 980 after deducting, the 1 digit from 1030 has to be set to 0 digit
    		}
    		shift+=30;
    	}
    	animal.setChangeDigit();
    }
    
    /**
	 * this method is to remove the life if the animal dies
	 * @param life how many life left
	 */
	public void removeLife(int life) {
		if(life==5) {	}
		else if(life==4) {
			background.remove(life5);
		}
		else if(life==3) {
			background.remove(life4);
		}
		else if(life==2) {
			background.remove(life3);
		}
		else if(life==1) {
			background.remove(life2);
		}
		else if(life==0) {
			background.remove(life1);
		}
	}
	
}
