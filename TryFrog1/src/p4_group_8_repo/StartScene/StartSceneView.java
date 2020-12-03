package p4_group_8_repo.StartScene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import p4_group_8_repo.StartScene.StartSceneModel;

public class StartSceneView {

	private StartSceneModel model;
	
	public StartSceneView(StartSceneModel model) {
		// TODO Auto-generated constructor stub
		this.model=model;
	}
	
	/**
	 * setting the view of start button
	 * @return start button
	 */
	public Button startButton() {
		Button start = model.getStart();
		start.setLayoutX(model.getStartX());
		start.setLayoutY(model.getStartY());
		start.setMinSize(150,50);
		start.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 2em; -fx-font-weight: bold;");
		return start;
	}
	
	/**
	 * setting the view of info button
	 * @return info button
	 */
	public Button infoButton() {
		Button info = model.getInfo();
		info.setLayoutX(200);
		info.setLayoutY(630);
		info.setMinSize(150,50);
		info.setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 2em; -fx-font-weight: bold;");
		return info;
	}
	
	/**
	 * setting up the view of the text field for entering player name
	 * @return text field of player name
	 */
	public TextField nameEnter() {
		TextField nameEnter = model.getEnterName();
		nameEnter.setLayoutX(305);
		nameEnter.setLayoutY(530);
		nameEnter.setMinSize(10, 10);
		nameEnter.setEditable(true);
		return nameEnter;
	}

}
