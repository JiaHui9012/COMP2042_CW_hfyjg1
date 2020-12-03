package p4_group_8_repo.EndScene;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * setting the view of the end scene
 * @author Jia Hui
 *
 */
public class EndSceneView {

	private EndSceneModel model;
	
	public EndSceneView(EndSceneModel model) {
		// TODO Auto-generated constructor stub
		this.model=model;
	}
	
	/**
	 * setting the view of the player's score text 
	 * @return the player's score text
	 */
	public Text PlayerScore() {
		Text PlayerScore = model.getPlayerScore();
		PlayerScore.setFont(Font.font ("Verdana", 25));
		PlayerScore.setFill(Color.WHITE);
		PlayerScore.setX(165);
		PlayerScore.setY(260);
		return PlayerScore;
	}
	
	/**
	 * setting the view of restart button
	 * @return restart button
	 */
	public Button restartButton() {
		Button restart = model.getRestart();
		restart.setLayoutX(110);
		restart.setLayoutY(700);
		restart.setMinSize(150,50);
		restart.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 2em; -fx-font-weight: bold;");
		return restart;
	}
	
	/**
	 * setting the view of quit button
	 * @return quit button
	 */
	public Button quitButton() {
		Button info = model.getQuit();
		info.setLayoutX(300);
		info.setLayoutY(700);
		info.setMinSize(150,50);
		info.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 2em; -fx-font-weight: bold;");
		return info;
	}
	
	/**
	 * setting the view of game over text
	 * @return game over text
	 */
	public Text GameOverText() {
		Text GameOver = model.getGameOverText();
		GameOver.setFont(Font.font ("Verdana", 30));
		GameOver.setFill(Color.WHITE);
		GameOver.setX(180);
		GameOver.setY(220);
		return GameOver;
	}
	
	/**
	 * setting the view of the winning message
	 * @return winning message text
	 */
	public Text WinText() {
		Text Win = model.getWinText();
		Win.setFont(Font.font ("Verdana", 30));
		Win.setFill(Color.WHITE);
		Win.setX(90);
		Win.setY(220);
		return Win;
	}
	
	/**
	 * setting the view of the score list text
	 * @return the score list text
	 */
	public Text ScoreText() {
		Text score = model.getScoreText();
		score.setFont(Font.font ("Verdana", 20));
		score.setFill(Color.WHITE);
		score.setX(100);
		score.setY(360+(model.getI()*30));
		return score;
	}

}
