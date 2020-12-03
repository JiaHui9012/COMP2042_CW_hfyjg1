package p4_group_8_repo.StartScene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import p4_group_8_repo.StartScene.StartSceneController;
import p4_group_8_repo.StartScene.StartSceneModel;
import p4_group_8_repo.StartScene.StartSceneView;

/**
 * a scene to instruct about how to play the game
 * @author Jia Hui
 *
 */
public class Instruction extends Application {

	private StartSceneModel model;
	private StartSceneView view;
	
	public Instruction(StartSceneModel model,StartSceneView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root= (AnchorPane)FXMLLoader.load(getClass().getResource("InfoScene.fxml"));
			primaryStage.setScene(new Scene(root,564,800));
			primaryStage.setResizable(false);
			primaryStage.show();
			
			Button start = new Button("Start");
			
			model.setStart(start,210,700); //set the start button
			view = new StartSceneView(model);
			StartSceneController controller = new StartSceneController(model,view);
			
			root.getChildren().addAll(view.startButton());
			
			controller.buttonAction();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
