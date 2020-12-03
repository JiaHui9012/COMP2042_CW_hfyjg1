package p4_group_8_repo.StartScene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import p4_group_8_repo.StartScene.StartSceneController;
import p4_group_8_repo.StartScene.StartSceneModel;
import p4_group_8_repo.StartScene.StartSceneView;
import p4_group_8_repo.World.MyStage;

/**
 * this class represents the starting scene of the game
 * @author Jia Hui
 *
 */
public class StartScene extends Application {

	private MyStage background = new MyStage();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("StartScene.fxml"));
			primaryStage.setScene(new Scene(root,564,800));
			primaryStage.setResizable(false);
			primaryStage.show();
			
			Button start = new Button("Start");
			Button info = new Button("How To Play");
			TextField nameEnter = new TextField("Player");
			
			StartSceneModel model = new StartSceneModel();
			model.setMyStage(background);
			model.setEnterName(nameEnter);
			model.setStart(start,200,580);
			model.setInfo(info);
			model.setStage(primaryStage);
			StartSceneView view = new StartSceneView(model);
			StartSceneController controller = new StartSceneController(model,view);
			
			root.getChildren().addAll(view.nameEnter(),view.startButton(),view.infoButton());
			
			controller.buttonAction();
			
			background.playMusic();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
