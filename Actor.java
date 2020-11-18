package p4_group_8_repo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * this class represents 
 * the actors/characters/objects/images
 * that will appear inside the game
 * 
 * @author Jia Hui
 *
 */
public abstract class Actor extends ImageView{

	/**
	 * this method is used to move the objects
	 * @param dx this parameter is used for setX
	 * @param dy this parameter is used for setY
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * The method is to find out if the objects intersect.
     * 
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }
    
    /**
     * this method is to set the object's image and its initial position
     * @param x this parameter is used to set X
     * @param y this parameter is used to set Y
     * @param img this parameter is used to set the object image
     */
    public void setImageXY(double x, double y, Image img) {
    	setX(x);
		setY(y);
		setImage(img);
    }

    /**
     * this method is to represent the action of the object
     * @param now
     */
    public abstract void act(long now);

}
