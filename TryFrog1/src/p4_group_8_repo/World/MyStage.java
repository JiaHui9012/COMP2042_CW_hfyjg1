package p4_group_8_repo.World;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * this class represents the stage and background music of the game
 * it is a subclass of World
 * @author Jia Hui
 *
 */
public class MyStage extends World{
	private MediaPlayer mediaPlayer;
	
	@Override
	public void act(long now) {}
	
	public MyStage() {}
	
	public void playMusic() {
		String musicFile = "src/p4_group_8_repo/resources/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
}
