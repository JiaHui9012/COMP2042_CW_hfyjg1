package p4_group_8_repo.EndScene;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * this class represents the ending score list 
 * it is to save and read the score for each round into/from a file
 * @author Jia Hui
 *
 */
public class ScoreList {

	ArrayList<Integer> arrayscore = new ArrayList<Integer>();
	ArrayList<String> arrayname = new ArrayList<String>();
	Map<String, Integer> unsortedresult;
	Map<String, Integer> result;
	
	public ScoreList() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * method to write and read the scores
	 * @param point the player's score
	 * @param name the player's name
	 */
	public void WriteReadFile(int point, String name) {
		File file= new File("Score.txt");
		try { 
			if (!file.exists()) {  //if the file is not exist then create a new one
				file.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(file, true)); //write the score into the file
	        output.append(name + " " + point); //write the name and score
	        output.newLine();
	        output.close();
			System.out.println("File Written Successfully");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(file));  //read the file
	        String line = reader.readLine();
	        while (line != null) 
	        {
	        	String [] words = line.split(" "); //separate name and score by indicate space bar
	            arrayscore.add(Integer.parseInt(words[1])); //add the score into the array list
	            arrayname.add(words[0]); //add name to array list
	            line = reader.readLine();
	        }
	        reader.close();
	        unsortedresult = new HashMap<String, Integer>(); //map the name and score 
	        for(int i=0;i<arrayscore.size();i++) {
	        	unsortedresult.put(arrayname.get(i), arrayscore.get(i));
	        }
	        result = unsortedresult
	        		.entrySet()
	        		.stream()
	        		.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // sort the score in descending order
	        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
	    }
		catch (FileNotFoundException e1) {
	            System.out.println("The specified file not found" + e1);
	    }
		catch (IOException ex) {
	        System.err.println("ERROR reading scores from file");
	    }
	}
	
	/**
	 * get the score list
	 * @return return the sorted array list which have the scores from the file
	 */
	public Map<String, Integer> getScoreList() {
		return result;
	}

}
