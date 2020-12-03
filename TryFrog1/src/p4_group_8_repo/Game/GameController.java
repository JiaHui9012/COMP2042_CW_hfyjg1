package p4_group_8_repo.Game;

import javafx.scene.text.Text;
import p4_group_8_repo.Actor.Animal;
import p4_group_8_repo.Actor.GameLife;
import p4_group_8_repo.World.MyStage;

public class GameController {

	private GameModel model;
	private GameView view;
	
	public GameController(GameModel model, GameView view) {
		// TODO Auto-generated constructor stub
		this.model = model;
		this.view = view;
	}

	public void setPoints(int points) {
		model.setPoints(points);
	}
	public void setLifeNumber(int lifeNumber) {
		model.setLifeNumber(lifeNumber);
	}
	public void setMyStage(MyStage background){
		model.setMyStage(background);
	}
	public void setAnimal(Animal animal){
		model.setAnimal(animal);
	}
	public void setText(Text text) {
		model.setText(text);
	}
	
	public int getPoints() {
		return model.getPoints();
	}
	public int getLifeNumber() {
		return model.getLifeNumber();
	}
	public MyStage getMyStage() {
		return model.getMyStage();
	}
	public Animal getAnimal() {
		return model.getAnimal();
	}
	public GameLife getLife1() {
		return model.getLife1();
	}
	public GameLife getLife2() {
		return model.getLife2();
	}
	public GameLife getLife3() {
		return model.getLife3();
	}
	public GameLife getLife4() {
		return model.getLife4();
	}
	public GameLife getLife5() {
		return model.getLife5();
	}
	public Text getText() {
		return model.getText();
	}
	
	public void setNumber() {
		view.setNumber();
	}
	
	public void removeLife() {
		view.removeLife();
	}
	
	public Text LevelTitleText() {
		return view.LevelTitleText();
	}
}
