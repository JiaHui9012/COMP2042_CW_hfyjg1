package p4_group_8_repo;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartEndScreen extends Actor {

	public StartEndScreen() {}
	
	public StartEndScreen(String imageLink, int size, int xpos, int ypos, double s) {
		setImageXY(xpos, ypos, new Image(imageLink, size,size, true, true));
	}
	
	public void addText(Text text, String font, double fontsize, Color color, double x, double y) {
		text.setFont(Font.font (font, fontsize));
		text.setFill(color);
		text.setX(x);
		text.setY(y);
	}
	
	public void addButton(Button button, double x, double y, double a, double b) {
    	button.setLayoutX(x);
		button.setLayoutY(y);
		button.setMinSize(a,b);
		button.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 2em; -fx-font-weight: bold;");
	}
	
	public void addTextField(TextField text, double x, double y) {
		text.setLayoutX(x);
		text.setLayoutY(y);
		text.setMinSize(10, 10);
		text.setEditable(true);
	}
	
	@Override
	public void act(long now) {	}

}
