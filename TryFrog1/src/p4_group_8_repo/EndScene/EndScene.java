package p4_group_8_repo.EndScene;

import java.util.ArrayList;
import java.util.Set;

import p4_group_8_repo.Actor.Animal;
import p4_group_8_repo.World.MyStage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * this class represents the ending scene of the game
 * @author Jia Hui
 *
 */
public class EndScene extends Application {

	private int size=10, i=0;
	private ArrayList<String> arrayScoreString = new ArrayList<String>();
	private ScoreList scorelist = new ScoreList();
	private MyStage background;
	private Animal animal;
	private TextField nameEnter;
	private AnimationTimer timer;
	
	public EndScene(MyStage background, Animal animal, TextField nameEnter,AnimationTimer timer) {
		// TODO Auto-generated constructor stub
		this.background = background;
		this.animal = animal;
		this.nameEnter = nameEnter;
		this.timer = timer;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("EndScene.fxml"));
		primaryStage.setScene(new Scene(root,564,800));
		primaryStage.setResizable(false);
		primaryStage.show();
		System.out.print("STOPP\n");
		timer.stop();
        background.stop(); // stop actors' animation
		
		Button restart = new Button("Play Again");
		Button quit = new Button("Quit");
		Text GameOver = new Text("Game Over!");
		Text Win = new Text("You Have Won The Game!");
		Text PlayerScore = new Text("Your Score: "+animal.getPoints()+"!");
		
		EndSceneModel model = new EndSceneModel();
		model.setStage(primaryStage);
		model.setMyStage(background);
		model.setAnimal(animal);
		model.setPlayerScore(PlayerScore);
		model.setRestart(restart);
		model.setQuit(quit);
		model.setGameOverText(GameOver);
		model.setWinText(Win);
		EndSceneView view = new EndSceneView(model);
		EndSceneController controller = new EndSceneController(model);
		
		root.getChildren().addAll(view.PlayerScore(),view.restartButton(),view.quitButton());
		
		controller.buttonAction();		
        
		scorelist.WriteReadFile(animal.getPoints(), nameEnter.getText()); //write the score into file and read all the scores from the file 
		
		if(animal.getStop()) { //if animal reaches all the five destinations, then add text about the player wins the game
			root.getChildren().addAll(view.WinText());
		}
		else if(animal.getLife()==0) { //if all the life are finished, then add text about game over 
			root.getChildren().addAll(view.GameOverText());
		}

		Set <String> keys = scorelist.getScoreList().keySet();
		if(scorelist.getScoreList().size()<10){ //if all the scores from the file is less than 10, then set the size = the size of the file 
			size=scorelist.getScoreList().size(); }
		for(String key:keys) {
			arrayScoreString.add(Integer.toString(scorelist.getScoreList().get(key))); //change the integer to string
		}
		for(String key:keys) {
			Text score = new Text((i+1)+")  "+key+"   "+arrayScoreString.get(i));
			model.setScoreText(score,i); //set score text
			root.getChildren().addAll(view.ScoreText()); //show the scores
			i++;
			if(i==size) { //when i = size, then stop showing the high scores
				break;
			}
		}
	}

}
