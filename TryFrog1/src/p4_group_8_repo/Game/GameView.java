package p4_group_8_repo.Game;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import p4_group_8_repo.Actor.Digit;
import p4_group_8_repo.World.MyStage;

public class GameView {

	private GameModel model;
	
	public GameView(GameModel model) {
		// TODO Auto-generated constructor stub
		this.model = model;
	}

	/**
     * this method is to set up the digits on the screen based on the points to show the current score
     */
    public void setNumber() {
    	int shift = 0, n = model.getPoints();
    	MyStage background=model.getMyStage();
    	while (n > 0) {
    		int d = n / 10;
    		int k = n - d * 10;
    		n = d;
    		background.add(new Digit(k, 30, 500 - shift, 30));
    		if(model.getAnimal().getChangeDigit()) {  //this is to avoid the error on setting up the digits, especially when the points is being deducting from longer length to shorter length  
    		background.add(new Digit(0, 30, 470 - shift, 30)); //example: when the previous point is 1030, the current point is 980 after deducting, the 1 digit from 1030 has to be set to 0 digit
    		}
    		shift+=30;
    	}
    	model.getAnimal().resetChangeDigit();
    }
    
    /**
	 * this method is to remove the life if the animal dies
	 */
	public void removeLife() {
		int life = model.getLifeNumber();
		if(life==5) {	}
		else if(life==4) {
			model.getMyStage().remove(model.getLife5());
		}
		else if(life==3) {
			model.getMyStage().remove(model.getLife4());
		}
		else if(life==2) {
			model.getMyStage().remove(model.getLife3());
		}
		else if(life==1) {
			model.getMyStage().remove(model.getLife2());
		}
		else if(life==0) {
			model.getMyStage().remove(model.getLife1());
		}
	}
	
	/**
	 * setting the view of level title text
	 * @return level title text
	 */
	public Text LevelTitleText() {
		Text title = model.getText();
		title.setFont(Font.font ("Verdana", 18));
		title.setFill(Color.WHITE);
		title.setX(10);
		title.setY(780);
		return title;
	}
}
