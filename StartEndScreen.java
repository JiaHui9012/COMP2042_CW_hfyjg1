package p4_group_8_repo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * this class represent the starting and ending scene for the game
 * @author Jia Hui
 *
 */
public class StartEndScreen extends World {

	public StartEndScreen() {}
	
	public StartEndScreen(MyStage background, Animal animal, TextField nameEnter, BackgroundImage froggerback) {
		BackgroundImage start = new BackgroundImage("file:src/p4_group_8_repo/resources/theFrog.png",230,230);
		Text name = new Text("Enter Your Name:");
		Button startButton = new Button("Start");
		Button infoButton = new Button("How To Play");
		Text about = new Text("About");
		Text abouttext = new Text("Frogger is a classic arcade \ngame, developed by Konami \nin 1981. The object of the \ngame is to help the frog \ncross from the bottom of \nthe screen to the top. This \nversion of Frogger consists \nof three levels.");
		BackgroundImage info1 = new BackgroundImage("file:src/p4_group_8_repo/resources/WASD.png",220,220);
		BackgroundImage info2 = new BackgroundImage("file:src/p4_group_8_repo/resources/bottomhalf.png",220,220);
		BackgroundImage info3 = new BackgroundImage("file:src/p4_group_8_repo/resources/middleriver.png",220,220);
		BackgroundImage info4 = new BackgroundImage("file:src/p4_group_8_repo/resources/topdestinations.png",220,220);
		Text infotext1 = new Text("Use WASD Keys/Arrow Keys to Play");
		Text infotext2 = new Text("On the bottom half of the screen, \nthe player must successfully guide \nthe frog between opposing lanes of \ntrucks, cars, and other vehicles, to \navoid becoming roadkill.");
		Text infotext3 = new Text("The middle of the screen, after the \nroad, contains a median where the \nplayer must prepare to navigate the \nriver by jumping on swiftly moving \nlogs and the backs of turtles.");
		Text infotext4 = new Text("The top of the screen contains five \n\"frog homes\" which are the \ndestinations for each frog. When all \nfive frogs are directed home, the \ngame ends.");
		
		background.add(froggerback); //add background
		start.setX(20);
		start.setY(170);
		background.add(start);
		addText(about,"Verdana",25,Color.WHITE,260,200);
		background.getChildren().add(about);
		addText(abouttext,"Verdana",19,Color.WHITE,260,230);
		background.getChildren().add(abouttext);
		addText(name,"Verdana",25,Color.WHITE,80,550);
		background.getChildren().add(name);
		addTextField(nameEnter,330,530);
		background.getChildren().add(nameEnter);
		addButton(startButton, 200, 580, 150, 50);
		background.getChildren().add(startButton);
		addButton(infoButton, 200, 630, 150, 50);
		background.getChildren().add(infoButton);
		
		infoButton.setOnAction(new EventHandler<ActionEvent>() { //if the info button gets pressed
			@Override
		    public void handle(ActionEvent event) {

				background.remove(start);
				background.getChildren().remove(about);
				background.getChildren().remove(abouttext);
		    	background.getChildren().remove(startButton);
				background.getChildren().remove(infoButton);
				background.getChildren().remove(name);
				background.getChildren().remove(nameEnter);
				
				info1.setX(20);
				info1.setY(165);
				background.add(info1);
				addText(infotext1,"Verdana",15,Color.WHITE,260,220);
				background.getChildren().add(infotext1);
				info2.setX(20);
				info2.setY(280);
				background.add(info2);
				addText(infotext2,"Verdana",15,Color.WHITE,260,310);
				background.getChildren().add(infotext2);
				info3.setX(20);
				info3.setY(430);
				background.add(info3);
				addText(infotext3,"Verdana",15,Color.WHITE,260,460);
				background.getChildren().add(infotext3);
				info4.setX(20);
				info4.setY(600);
				background.add(info4);
				addText(infotext4,"Verdana",15,Color.WHITE,260,590);
				background.getChildren().add(infotext4);
				addButton(startButton, 215, 700, 130, 50);
				background.getChildren().add(startButton);
		    }
		});

		startButton.setOnAction(new EventHandler<ActionEvent>() { //if the start button gets pressed
			@Override
		    public void handle(ActionEvent event) {
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
				background.getChildren().remove(name);
				background.getChildren().remove(nameEnter);
				new Level1(background,animal,nameEnter,froggerback); // go to level 1
			}
		});
	}
	
	/**
	 * set up the text
	 */
	public void addText(Text text, String font, double fontsize, Color color, double x, double y) {
		text.setFont(Font.font (font, fontsize));
		text.setFill(color);
		text.setX(x);
		text.setY(y);
	}
	
	/**
	 * set up button
	 */
	public void addButton(Button button, double x, double y, double a, double b) {
    	button.setLayoutX(x);
		button.setLayoutY(y);
		button.setMinSize(a,b);
		button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 2em; -fx-font-weight: bold;");
	}
	
	/**
	 * set up text field
	 */
	public void addTextField(TextField text, double x, double y) {
		text.setLayoutX(x);
		text.setLayoutY(y);
		text.setMinSize(10, 10);
		text.setEditable(true);
	}
	
	@Override
	public void act(long now) {	}

}
