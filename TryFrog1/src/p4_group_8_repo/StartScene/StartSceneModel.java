package p4_group_8_repo.StartScene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p4_group_8_repo.World.MyStage;

public class StartSceneModel {

	private MyStage background;
	private Stage stage;
	private Button start;
	private Button info;
	private TextField nameEnter;
	private int startX, startY;
	
	public StartSceneModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMyStage(MyStage background){
		this.background = background;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public void setStart(Button start,int startX, int startY) {
		this.start = start;
		this.startX = startX;
		this.startY = startY;
	}
	public void setInfo(Button info) {
		this.info = info;
	}
	public void setEnterName(TextField nameEnter) {
		this.nameEnter = nameEnter;
	}
	
	
	public MyStage getMyStage() {
		return background;
	}
	public Stage getStage() {
		return stage;
	}
	public Button getStart() {
		return start;
	}
	public Button getInfo() {
		return info;
	}
	public TextField getEnterName() {
		return nameEnter;
	}
	public int getStartX() {
		return startX;
	}
	public int getStartY() {
		return startY;
	}

}
