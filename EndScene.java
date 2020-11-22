package p4_group_8_repo;

import java.util.ArrayList;
import java.util.Set;

import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * this class represents the ending stage of the game
 * @author Jia Hui
 *
 */
public class EndScene extends MyStage {

	public EndScene(MyStage background, Animal animal, TextField nameEnter) {
		// TODO Auto-generated constructor stub
		int size=10;
		int i=0;
		ArrayList<String> arrayScoreString = new ArrayList<String>();
		ScoreList scorelist = new ScoreList();
		Text ScoreTitle = new Text("Game Over!");
		Text ScoreTitle1 = new Text("You Have Won The Game!");
        Text ScoreTitle2 = new Text("Your Score: "+animal.getPoints()+"!");
        //Text ScoreTitle3 = new Text("Highest Possible Score: 4750");
        Text ScoreTitle4 = new Text("High Scores");
        
		background.add(new BackgroundImage("file:src/p4_group_8_repo/resources/iKogsKW.png",600,800)); //add background image
		scorelist.WriteReadFile(animal.getPoints(), nameEnter.getText()); //write the score into file and read all the scores from the file 
		
		if(animal.getStop()) { //if animal reaches all the five destinations, then add text about the player wins the game
			addText(ScoreTitle1,"Verdana",30,Color.WHITE,90,200);
			background.getChildren().add(ScoreTitle1);  //add texts
		}
		else if(animal.getLife()==0) { //if all the life are finished, then add text about game over 
			addText(ScoreTitle,"Verdana",30,Color.WHITE,180,200);
			background.getChildren().add(ScoreTitle);
		}
		addText(ScoreTitle2,"Verdana",25,Color.WHITE,170,240);
		background.getChildren().add(ScoreTitle2); //show the score of the player gets in this round
		//addText(ScoreTitle3,"Verdana",15,Color.WHITE,170,270);
		//background.getChildren().add(ScoreTitle3);
		addText(ScoreTitle4,"Verdana",25,Color.WHITE,100,320);
		background.getChildren().add(ScoreTitle4);

		Set <String> keys = scorelist.getScoreList().keySet();
		if(scorelist.getScoreList().size()<10){ //if all the scores from the file is less than 10, then set the size = the size of the file 
			size=scorelist.getScoreList().size(); }
		for(String key:keys) {
			arrayScoreString.add(Integer.toString(scorelist.getScoreList().get(key))); //change the integer to string
		}
		for(String key:keys) {
			Text t = new Text((i+1)+")  "+key+"   "+arrayScoreString.get(i));
			addText(t, "Verdana", 20, Color.WHITE, 100, 360+(i*30));
			background.getChildren().add(t); //show at least 10 high scores to the screen
			i++;
			if(i==size) { //when i = size, then stop showing the high scores
				break;
			}
		}

	}

}
