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
	private MyStage background = new MyStage();;
	private Animal animal;
	private TextField nameEnter;
	
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
		animal = new Animal("file:src/p4_group_8_repo/resources/froggerUp.png");
	    BackgroundImage froggerback = new BackgroundImage("file:src/p4_group_8_repo/resources/iKogsKW.png");
		StartEndScreen start = new StartEndScreen("file:src/p4_group_8_repo/resources/theFrog.png", 230, 20, 170, 0.75);
		Text name = new Text("Enter Your Name");
		Button startButton = new Button("Start");
		Button infoButton = new Button("How To Play");
		Text about = new Text("About");
		Text abouttext = new Text("Frogger is a classic arcade \ngame, developed by Konami \nin 1981. The object of the \ngame is to help the frog \ncross from the bottom of \nthe screen to the top.");
		StartEndScreen info1 = new StartEndScreen("file:src/p4_group_8_repo/resources/WASD.png", 220, 20, 165, 0.75);
		StartEndScreen info2 = new StartEndScreen("file:src/p4_group_8_repo/resources/bottomhalf.png", 220, 20, 280, 0.75);
		StartEndScreen info3 = new StartEndScreen("file:src/p4_group_8_repo/resources/middleriver.png", 220, 20, 430, 0.75);
		StartEndScreen info4 = new StartEndScreen("file:src/p4_group_8_repo/resources/topdestinations.png", 220, 20, 600, 0.75);
		Text infotext1 = new Text("Use WASD Keys/Arrow Keys to Play");
		Text infotext2 = new Text("On the bottom half of the screen, \nthe player must successfully guide \nthe frog between opposing lanes of \ntrucks, cars, and other vehicles, to \navoid becoming roadkill.");
		Text infotext3 = new Text("The middle of the screen, after the \nroad, contains a median where the \nplayer must prepare to navigate the \nriver by jumping on swiftly moving \nlogs and the backs of turtles.");
		Text infotext4 = new Text("The top of the screen contains five \n\"frog homes\" which are the \ndestinations for each frog. When all \nfive frogs are directed home, the \ngame ends.");
		
		background.add(froggerback);
		background.add(start);
		start.addText(about,"Verdana",25,Color.WHITE,260,210);
		background.getChildren().add(about);
		start.addText(abouttext,"Verdana",20,Color.WHITE,260,250);
		background.getChildren().add(abouttext);
		start.addText(name,"Verdana",25,Color.WHITE,80,550);
		background.getChildren().add(name);
		nameEnter = new TextField("Player");
		start.addTextField(nameEnter,330,530);
		background.getChildren().add(nameEnter);
		start.addButton(startButton, 200, 580, 150, 50);
		background.getChildren().add(startButton);
		start.addButton(infoButton, 200, 630, 150, 50);
		background.getChildren().add(infoButton);
		
		infoButton.setOnAction(new EventHandler<ActionEvent>() { //if the info button gets pressed
			@Override
		    public void handle(ActionEvent event) {

				background.getChildren().remove(name);
				background.getChildren().remove(nameEnter);
				background.remove(start);
				background.getChildren().remove(about);
				background.getChildren().remove(abouttext);
		    	background.getChildren().remove(startButton);
				background.getChildren().remove(infoButton);
				
				background.add(info1);
				info1.addText(infotext1,"Verdana",15,Color.WHITE,260,220);
				background.getChildren().add(infotext1);
				background.add(info2);
				info2.addText(infotext2,"Verdana",15,Color.WHITE,260,310);
				background.getChildren().add(infotext2);
				background.add(info3);
				info3.addText(infotext3,"Verdana",15,Color.WHITE,260,460);
				background.getChildren().add(infotext3);
				background.add(info4);
				info4.addText(infotext4,"Verdana",15,Color.WHITE,260,590);
				background.getChildren().add(infotext4);
				start.addButton(startButton, 215, 700, 130, 50);
				background.getChildren().add(startButton);
		    }
		});

		startButton.setOnAction(new EventHandler<ActionEvent>() { //if the start button gets pressed
			@Override
		    public void handle(ActionEvent event) {
		        
				background.getChildren().remove(name);
				background.getChildren().remove(nameEnter);
				background.remove(start);
				background.getChildren().remove(about);
				background.getChildren().remove(abouttext);
		    	background.getChildren().remove(startButton);
		    	background.getChildren().remove(infoButton);
		    	background.remove(info1);
		    	background.remove(info2);
		    	background.remove(info3);
		    	background.remove(info4);
		    	background.getChildren().remove(infotext1);
		    	background.getChildren().remove(infotext2);
		    	background.getChildren().remove(infotext3);
		    	background.getChildren().remove(infotext4);
		    	background.getChildren().remove(startButton);
		    	
				background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 0, 166, 0.75));
				background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 220, 166, 0.75));
				background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 440, 166, 0.75));
				background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 0, 276, -2));
				background.add(new Log("file:src/p4_group_8_repo/resources/logs.png", 300, 400, 276, -2));
				background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 50, 329, 0.75));
				background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 270, 329, 0.75));
				background.add(new Log("file:src/p4_group_8_repo/resources/log3.png", 150, 490, 329, 0.75));
				
				background.add(new Turtle(500, 376, -1, 130, 130));
				background.add(new Turtle(300, 376, -1, 130, 130));
				
				background.add(new WetTurtle(700, 376, -1, 130, 130));
				background.add(new WetTurtle(600, 217, -1, 130, 130));
				background.add(new WetTurtle(400, 217, -1, 130, 130));
				background.add(new WetTurtle(200, 217, -1, 130, 130));
				
				background.add(new End(10,96));
				background.add(new End(130,96));
				background.add(new End(130 + 130-10,96));
				background.add(new End(130 + 130-10+130-10,96));
				background.add(new End(130 + 130-10+130-10+130-10+3,96));
				
				background.add(animal);
				
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 0, 649, 1, 120, 120));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 300, 649, 1, 120, 120));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck1Right.png", 600, 649, 1, 120, 120));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 100, 597, -1, 50, 50));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 250, 597, -1, 50, 50));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 400, 597, -1, 50, 50));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 550, 597, -1, 50, 50));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 0, 540, 1, 200, 200));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/truck2Right.png", 500, 540, 1, 200, 200));
				background.add(new Obstacle("file:src/p4_group_8_repo/resources/car1Left.png", 500, 490, -5, 50, 50));
				
				background.add(new Digit(0, 30, 500, 30));
				background.start();
		 
		    }
		});
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		int size=10;
            		int i=0;
            		ArrayList<String> arrayScoreString = new ArrayList<String>();
            		ScoreList scorelist = new ScoreList(); //store the score to file
            		BackgroundImage endingBackground = new BackgroundImage("file:src/p4_group_8_repo/resources/iKogsKW.png");
            		Text ScoreTitle1 = new Text("You Have Won The Game!");
    	            Text ScoreTitle2 = new Text("Your Score: "+animal.getPoints()+"!");
    	            Text ScoreTitle3 = new Text("Highest Possible Score: 800");
    	            Text ScoreTitle4 = new Text("High Scores");
    	            
            		background.add(endingBackground);
            		scorelist.WriteReadFile(animal.getPoints(), nameEnter.getText());
    						
            		System.out.print("STOPP\n");
    	            stop();
    	            background.stop();
    						
		            scorelist.addText(ScoreTitle1,"Verdana",30,Color.WHITE,100,200);
		    		background.getChildren().add(ScoreTitle1);
		    		scorelist.addText(ScoreTitle2,"Verdana",25,Color.WHITE,180,240);
		    		background.getChildren().add(ScoreTitle2);
		    		scorelist.addText(ScoreTitle3,"Verdana",15,Color.WHITE,180,270);
		    		background.getChildren().add(ScoreTitle3);
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
		    		
		    		Button playAgain = new Button("PLay Again");
		    		scorelist.addButton(playAgain, 110, 700, 150, 50);
		    		background.getChildren().add(playAgain);
		    		playAgain.setOnAction(new EventHandler<ActionEvent>() { //if the start button gets pressed
		    			@Override
		    		    public void handle(ActionEvent event) {
		    				background.getChildren().clear();
		    				start();
		    				startGame();
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
