package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ActorTest {

	Animal animal = new Animal();
	End end =  new End();
	
	@Test
	public void testPoints() {
		animal.setPoints(666);
		assertEquals(666,animal.getPoints());
	}
	
	@Test
	public void testEndActivated() {
		assertFalse(end.isActivated());
	}

}
