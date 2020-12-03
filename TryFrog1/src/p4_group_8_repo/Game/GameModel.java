package p4_group_8_repo.Game;

import javafx.scene.text.Text;
import p4_group_8_repo.Actor.Animal;
import p4_group_8_repo.Actor.GameLife;
import p4_group_8_repo.World.MyStage;

public class GameModel {

	private int points, lifeNumber;
	private MyStage background;
	private Animal animal;
	private GameLife life1 =  new GameLife(30, 500, 750);
	private GameLife life2 =  new GameLife(30, 470, 750);
	private GameLife life3 =  new GameLife(30, 440, 750);
	private GameLife life4 =  new GameLife(30, 410, 750);
	private GameLife life5 =  new GameLife(30, 380, 750);
	private Text text;
	
	public GameModel() {
		// TODO Auto-generated constructor stub
	}

	public void setPoints(int points) {
		this.points = points;
	}
	public void setLifeNumber(int lifeNumber) {
		this.lifeNumber = lifeNumber;
	}
	public void setMyStage(MyStage background){
		this.background = background;
	}
	public void setAnimal(Animal animal){
		this.animal = animal;
	}
	public void setText(Text text) {
		this.text = text;
	}
	
	public int getPoints() {
		return points;
	}
	public int getLifeNumber() {
		return lifeNumber;
	}
	public MyStage getMyStage() {
		return background;
	}
	public Animal getAnimal() {
		return animal;
	}
	public GameLife getLife1() {
		return life1;
	}
	public GameLife getLife2() {
		return life2;
	}
	public GameLife getLife3() {
		return life3;
	}
	public GameLife getLife4() {
		return life4;
	}
	public GameLife getLife5() {
		return life5;
	}
	public Text getText() {
		return text;
	}
}
