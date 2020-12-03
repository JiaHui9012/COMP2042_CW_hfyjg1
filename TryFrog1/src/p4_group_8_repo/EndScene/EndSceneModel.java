package p4_group_8_repo.EndScene;

import p4_group_8_repo.Actor.Animal;
import p4_group_8_repo.World.MyStage;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EndSceneModel {

	private Stage stage;
	private MyStage background;
	private Animal animal;
	private Text PlayerScore;
	private Button restart, quit;
	private Text GameOver, Win, score;
	private int i;
	
	public EndSceneModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public void setMyStage(MyStage background){
		this.background = background;
	}
	public void setAnimal(Animal animal){
		this.animal = animal;
	}
	public void setPlayerScore(Text PlayerScore){
		this.PlayerScore = PlayerScore;
	}
	public void setRestart(Button restart) {
		this.restart = restart;
	}
	public void setQuit(Button quit) {
		this.quit = quit;
	}
	public void setGameOverText(Text GameOver) {
		this.GameOver = GameOver;
	}
	public void setWinText(Text Win) {
		this.Win = Win;
	}
	public void setScoreText(Text score, int i) {
		this.score = score;
		this.i = i;
	}

	public Stage getStage() {
		return stage;
	}
	public MyStage getMyStage() {
		return background;
	}
	public Animal getAnimal() {
		return animal;
	}
	public Text getPlayerScore() {
		return PlayerScore;
	}
	public Button getRestart() {
		return restart;
	}
	public Button getQuit() {
		return quit;
	}
	public Text getGameOverText() {
		return GameOver;
	}
	public Text getWinText() {
		return Win;
	}
	public Text getScoreText() {
		return score;
	}
	public int getI() {
		return i;
	}


}
