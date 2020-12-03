package p4_group_8_repo.EndScene;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import p4_group_8_repo.StartScene.StartScene;

public class EndSceneController {

	private EndSceneModel model;
	
	public EndSceneController(EndSceneModel model) {
		this.model=model;
	}
	
	public void buttonAction() {
		model.getRestart().setOnAction(new EventHandler<ActionEvent>() { //if the start button gets pressed then restart the game
			@Override
		    public void handle(ActionEvent event) {
				System.out.println("restart");
		    	try {
		    		model.getMyStage().stopMusic(); //stop music
		    		model.getMyStage().getChildren().clear(); // clear everything
    				model.getAnimal().setPoints(0);  //reset points to 0
    				model.getAnimal().setEnd();  //reset the destinations
    				StartScene main = new StartScene(); 
    				main.start(model.getStage()); //back to start scene
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		model.getQuit().setOnAction(new EventHandler<ActionEvent>() { //if the quit button gets pressed then quit game
			@Override
		    public void handle(ActionEvent event) {
				System.out.println("quit");
				try {
					model.getMyStage().stopMusic(); //stop music
    	            Platform.exit();  //exit the game
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
