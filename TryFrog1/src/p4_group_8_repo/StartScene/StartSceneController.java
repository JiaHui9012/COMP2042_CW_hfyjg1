package p4_group_8_repo.StartScene;

import p4_group_8_repo.Game.Game;
import p4_group_8_repo.StartScene.Instruction;
import p4_group_8_repo.StartScene.StartSceneModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartSceneController {

	private StartSceneModel model;
	private StartSceneView view;
	
	public StartSceneController(StartSceneModel model, StartSceneView view) {
		// TODO Auto-generated constructor stub
		this.model=model;
		this.view=view;
	}
	
	public void buttonAction() {
		model.getStart().setOnAction(new EventHandler<ActionEvent>() { //if the start button gets pressed then start the game
			@Override
		    public void handle(ActionEvent event) {
				System.out.println("start");
		    	Game StartGame = new Game(model.getEnterName(),model.getStage(),model.getMyStage());
		    	try {
		    		StartGame.start(model.getStage()); //start the game section
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		model.getInfo().setOnAction(new EventHandler<ActionEvent>() { //if the info button gets pressed then go to the instruction scene
			@Override
		    public void handle(ActionEvent event) {
				System.out.println("info");
				Instruction info=new Instruction(model,view);
				try {
					info.start(model.getStage()); //start the instruction scene
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
