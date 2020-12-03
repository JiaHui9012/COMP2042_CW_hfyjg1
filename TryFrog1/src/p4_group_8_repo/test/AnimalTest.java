package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import p4_group_8_repo.Actor.Animal;

/**
 * this is a JUnit test to test Actor class's subclasses by using JUnit 4
 * @author Jia Hui
 *
 */
public class AnimalTest {

	Animal animal = new Animal();
	
	@Test
	public void testPoints() { //test if the points is set correctly
		animal.setPoints(666); //set the points
		assertEquals(666,animal.getPoints());
	}
	
	@Test
	public void testDeductPoints() { //test if the points is set correctly
		animal.setPoints(666);
		animal.deductPoints(); //set the points
		assertEquals(616,animal.getPoints());
	}
	
	@Test
	public void testChangeScore() { //test if the points is set correctly
		boolean changeScore = animal.changeScore();
		assertEquals(false,changeScore);
	}

}
