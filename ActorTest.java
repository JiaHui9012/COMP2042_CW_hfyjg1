package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * this is a JUnit test to test Actor class's subclasses by using JUnit 4
 * @author Jia Hui
 *
 */
public class ActorTest {

	Animal animal = new Animal();
	End end =  new End();
	
	@Test
	public void testPoints() { //test if the points is set correctly
		animal.setPoints(666); //set the points
		assertEquals(666,animal.getPoints());
	}
	
	@Test
	public void testEndActivated() { //test the initiate value of the method isActivated in the End class
		assertFalse(end.isActivated()); //the initiate value should be false
	}

}
