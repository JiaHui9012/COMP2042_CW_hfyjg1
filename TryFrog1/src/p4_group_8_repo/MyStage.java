package p4_group_8_repo;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * this class represents the stage and background music of the game
 * it is a subclass of World
 * @author Jia Hui
 *
 */
public class MyStage extends World{
	private MediaPlayer mediaPlayer;
	
	@Override
	public void act(long now) {}
	
	public MyStage() {}
	
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/resources/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
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


}
