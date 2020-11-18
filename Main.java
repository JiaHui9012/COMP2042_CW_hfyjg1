package p4_group_8_repo;

import java.util.ArrayList;
import java.util.Set;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	private AnimationTimer timer;
	private MyStage background = new MyStage();
	private Animal animal = new Animal("file:src/p4_group_8_repo/resources/froggerUp.png");
	private BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/resources/iKogsKW.png",600,800);
	private TextField nameEnter = new TextField("Player");
	private boolean nextLevel=false;
	private boolean stopGame=false;
	private int levelCount=1;
	private Level3 level3;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene  = new Scene(background,564,800);
		primaryStage.setScene(scene);
		primaryStage.show();
		start(); 
		startGame();	
	}
	
	public void startGame() {
		new StartEndScreen(background,animal,nameEnter,froggerback);
		nextLevel=true;
	}
	
	public void Level2() {
		new Level2(background,animal,nameEnter,froggerback);
		setNumber(animal.getPoints());
		nextLevel=true;
		
	}
	
	public void Level3() {
		level3 = new Level3(background,animal,nameEnter,froggerback);
		setNumber(animal.getPoints());
		stopGame=true;
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if(animal.getLife()<5&&levelCount==3) {
            		level3.removeLife(background, animal.getLife());
            	}
            	if(animal.getStop()&&nextLevel) {
            		levelCount++;
    	            stop();
    	            background.stop();
    	            background.getChildren().clear();
    				start();
            		animal.setEnd();
            		animal.setLife(5);
            		nextLevel=false;
            		if(levelCount==2) {
            			Level2();
            		}
            		else if(levelCount==3) {
            			Level3();
            		}
    			}
            	if ((animal.getStop()||animal.getLife()==0)&&stopGame) {
            		int size=10;
            		int i=0;
            		ArrayList<String> arrayScoreString = new ArrayList<String>();
            		ScoreList scorelist = new ScoreList(); //store the score to file
            		BackgroundImage endingBackground = new BackgroundImage("file:src/p4_group_8_repo/resources/iKogsKW.png",600,800);
            		Text ScoreTitle = new Text("Game Over!");
            		Text ScoreTitle1 = new Text("You Have Won The Game!");
    	            Text ScoreTitle2 = new Text("Your Score: "+animal.getPoints()+"!");
    	            //Text ScoreTitle3 = new Text("Highest Possible Score: 800");
    	            Text ScoreTitle4 = new Text("High Scores");
    	            
            		background.add(endingBackground);
            		scorelist.WriteReadFile(animal.getPoints(), nameEnter.getText());
    				
            		if(animal.getStop()) {
            			scorelist.addText(ScoreTitle1,"Verdana",30,Color.WHITE,90,200);
            			background.getChildren().add(ScoreTitle1);
            		}
            		else if(animal.getLife()==0) {
            			scorelist.addText(ScoreTitle,"Verdana",30,Color.WHITE,180,200);
            			background.getChildren().add(ScoreTitle);
            		}
		    		scorelist.addText(ScoreTitle2,"Verdana",25,Color.WHITE,170,240);
		    		background.getChildren().add(ScoreTitle2);
		    		//scorelist.addText(ScoreTitle3,"Verdana",15,Color.WHITE,170,270);
		    		//background.getChildren().add(ScoreTitle3);
		    		scorelist.addText(ScoreTitle4,"Verdana",25,Color.WHITE,100,320);
		    		background.getChildren().add(ScoreTitle4);

	    			Set <String> keys = scorelist.getScoreList().keySet();
		    		if(scorelist.getScoreList().size()<10){ 
		    			size=scorelist.getScoreList().size(); }
		    		for(String key:keys) {
		    			arrayScoreString.add(Integer.toString(scorelist.getScoreList().get(key))); //change the integer to string
		    		}
		    		for(String key:keys) {
		    			Text t = new Text((i+1)+")  "+key+"   "+arrayScoreString.get(i));
		    			scorelist.addText(t, "Verdana", 20, Color.WHITE, 100, 360+(i*30));
		    			background.getChildren().add(t); //show scores to the screen
		    			i++;
		    			if(i==size) {
		    				break;
		    			}
		    		}

		    		System.out.print("STOPP\n");
    	            stop();
    	            background.stop();
		    		
		    		Button playAgain = new Button("Play Again");
		    		scorelist.addButton(playAgain, 110, 700, 150, 50);
		    		background.getChildren().add(playAgain);
		    		playAgain.setOnAction(new EventHandler<ActionEvent>() { //if the start button gets pressed
		    			@Override
		    		    public void handle(ActionEvent event) {
		    				background.getChildren().clear();
		    				animal.setPoints(0);
		    				animal.setEnd();
		    				start();
		    				startGame();
		    				stopGame=false;
		    				levelCount=1;
		    			}
		    		});
		    		
		    		Button quit = new Button("Quit");
		    		scorelist.addButton(quit, 300, 700, 150, 50);
		    		background.getChildren().add(quit);
		    		quit.setOnAction(new EventHandler<ActionEvent>() { //if the start button gets pressed
		    			@Override
		    		    public void handle(ActionEvent event) {
		    				background.stopMusic();
		    	            Platform.exit();
		    			}
		    		});
            	}
            }
        };
    }
	
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 500 - shift, 30));
    		  shift+=30;
    	}
    }
}
