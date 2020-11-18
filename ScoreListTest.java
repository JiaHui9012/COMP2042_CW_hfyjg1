package p4_group_8_repo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

public class ScoreListTest {

	ScoreList score1 = new ScoreList();
	
	@Test
	public void testArrayListSizeNotEmpty() {
		score1.WriteReadFile(666, "Ben");
		assertTrue(score1.getScoreList().size()!=0);
	}

	@Test
	public void testArrayListIsSorted() {
		boolean sorted = false;
		score1.WriteReadFile(666, "Ben");
		Set <String> keys = score1.getScoreList().keySet();
		ArrayList<String> arrayScore = new ArrayList<String>();
		for(String key:keys) {
		arrayScore.add(Integer.toString(score1.getScoreList().get(key)));
		}
		for (int i = 1; i < arrayScore.size(); i++) {
	        if (arrayScore.get(i-1).compareTo(arrayScore.get(i)) > 0) 
	        	sorted = true;
	    }
	    assertTrue(sorted);

	}

}
