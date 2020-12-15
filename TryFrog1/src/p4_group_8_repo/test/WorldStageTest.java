package p4_group_8_repo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import p4_group_8_repo.Actor.Fly;
import p4_group_8_repo.World.MyStage;

public class WorldStageTest {

	MyStage worldStage = new MyStage();
	ActorImp actor = new ActorImp();

	@Test
	public void addTest() { //test the add method from World class
		worldStage.add(actor);
		assertSame(worldStage, actor.getWorld());
	}
	
	@Test
	public void removeTest() { //test the remove method from World class
		worldStage.remove(actor);
		assertNotSame(worldStage, actor.getWorld());
	}

	@Test
	public void getObjectsTest() { //test the getObjects method from World class
		ActorImp Object1 = new ActorImp();
		ActorImp Object2 = new ActorImp();
		worldStage.add(Object1);
		worldStage.add(Object2);
		assertEquals(0, worldStage.getObjects(Fly.class).size());
		assertEquals(2, worldStage.getObjects(ActorImp.class).size());
	}


}
