package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import p4_group_8_repo.Actor.Fly;

public class FlyTest {

	Fly fly = new Fly();
	
	@Test
	public void testEndActivated() { //test the initiate value of the method isActivated in the End class
		assertFalse(fly.isActivated()); //the initiate value should be false
	}
	
	@Test
	public void testFlyOccupied() { //test the initiate value of the method isActivated in the End class
		assertFalse(fly.isOccupied()); //the initiate value should be false
	}
	
}
