package p4_group_8_repo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * this class represents the starting and ending scene for the game
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
		Text abouttext = new Text("Frogger is a classic arcade \ngame, developed by Konami \nin 1981. The object of the \ngame is to help the frog \ncross from the bottom of \nthe screen to the top. This \nversion of Frogger consists \nof five levels.");
		BackgroundImage info1 = new BackgroundImage("file:src/p4_group_8_repo/resources/WASD.png",220,220);
		BackgroundImage info2 = new BackgroundImage("file:src/p4_group_8_repo/resources/bottomhalf.png",220,220);
		BackgroundImage info3 = new BackgroundImage("file:src/p4_group_8_repo/resources/middleriver.png",220,220);
		BackgroundImage info4 = new BackgroundImage("file:src/p4_group_8_repo/resources/topdestinations.png",220,220);
		Text infotext1 = new Text("Use WASD Keys/Arrow Keys to Play");
		Text infotext2 = new Text("On the bottom half of the screen, \nthe player must successfully guide \nthe frog between opposing lanes of \ntrucks, cars, and other vehicles, to \navoid becoming roadkill.");
		Text infotext3 = new Text("The middle of the screen, after the \nroad, contains a median where the \nplayer must prepare to navigate the \nriver by jumping on swiftly moving \nlogs and the backs of turtles. Be aware \nthere will be a snake in the middle \nroad after level 3.");
		Text infotext4 = new Text("The top of the screen contains five \n\"frog homes\" which are the \ndestinations. When all five frogs are \ndirected home, the game ends. After \nlevel 2, flies will appear at the \ndestinations at certain times, player \ncan catch them to earn more points.");
		
		background.add(froggerback); //add background
		
		//setting up all the details into the starting scene 
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
		
		infoButton.setOnAction(new EventHandler<ActionEvent>() { //if the info button gets pressed then show the info contents about the game
			@Override
		    public void handle(ActionEvent event) {
				//remove the previous contents
				background.remove(start);
				background.getChildren().remove(about);
				background.getChildren().remove(abouttext);
		    	background.getChildren().remove(startButton);
				background.getChildren().remove(infoButton);
				background.getChildren().remove(name);
				background.getChildren().remove(nameEnter);
				//set up the new contents
				info1.setX(20);
				info1.setY(155);
				background.add(info1);
				addText(infotext1,"Verdana",15,Color.WHITE,260,205);
				background.getChildren().add(infotext1);
				info2.setX(20);
				info2.setY(260);
				background.add(info2);
				addText(infotext2,"Verdana",15,Color.WHITE,260,288);
				background.getChildren().add(infotext2);
				info3.setX(20);
				info3.setY(407);
				background.add(info3);
				addText(infotext3,"Verdana",15,Color.WHITE,260,420);
				background.getChildren().add(infotext3);
				info4.setX(20);
				info4.setY(600);
				background.add(info4);
				addText(infotext4,"Verdana",15,Color.WHITE,260,570);
				background.getChildren().add(infotext4);
				addButton(startButton, 215, 700, 130, 50);
				background.getChildren().add(startButton);
		    }
		});

		startButton.setOnAction(new EventHandler<ActionEvent>() { //if the start button gets pressed then start level 1
			@Override
		    public void handle(ActionEvent event) {
				//remove the previous contents
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
				
				new Level1(background,animal,froggerback); // go to level 1
			}
		});
	}
	
	/**
	 * set up the text
	 * @param text it is the text going to add on the screen
	 * @param font it is to indicate what font to use
	 * @param fontsize it is to indicate the size of the font
	 * @param color it is to indicate the color of the text
	 * @param x it is to set up the x position of the text
	 * @param y it is to set up the y position of the text
	 */
	public void addText(Text text, String font, double fontsize, Color color, double x, double y) {
		text.setFont(Font.font (font, fontsize));
		text.setFill(color);
		text.setX(x);
		text.setY(y);
	}
	
	/**
	 * set up the button
	 * @param button it is the Button object
	 * @param x it is to set up the x position of the button object
	 * @param y it is to set up the y position of the button object
	 * @param a it is to set up the size of the button object
	 * @param b it is to set up the size of the button object
	 */
	public void addButton(Button button, double x, double y, double a, double b) {
    	button.setLayoutX(x);
		button.setLayoutY(y);
		button.setMinSize(a,b);
		button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 2em; -fx-font-weight: bold;");
	}
	
	/**
	 * set up the text field
	 * @param text the object of the text field
	 * @param x it is to set up the x position of the object
	 * @param y it is to set up the y position of the object
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
