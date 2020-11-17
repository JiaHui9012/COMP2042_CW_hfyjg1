package p4_group_8_repo;

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

public class ScoreList extends StartEndScreen {

	ArrayList<Integer> arrayscore = new ArrayList<Integer>();
	ArrayList<String> arrayname = new ArrayList<String>();
	Map<String, Integer> unsortedresult;
	Map<String, Integer> result;
	String name;
	
	public ScoreList() {
		// TODO Auto-generated constructor stub
	}

	public ScoreList(String imageLink, int size, int xpos, int ypos, double s) {
		super(imageLink, size, xpos, ypos, s);
		// TODO Auto-generated constructor stub
	}
	
	public void WriteReadFile(int point, String name) {
		File file= new File("Score.txt");
		try { 
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(file, true)); //write the score into the file
	        output.append(name + " " + point);
	        output.newLine();
	        output.close();
			System.out.println("File Written Successfully");
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		
		//read the file
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line = reader.readLine();
	        while (line != null) 
	        {
	        	String [] words = line.split(" ");
	            arrayscore.add(Integer.parseInt(words[1])); //add the score into the array list
	            arrayname.add(words[0]);
	            line = reader.readLine();
	        }
	        reader.close();
	        unsortedresult = new HashMap<String, Integer>();
	        for(int i=0;i<arrayscore.size();i++) {
	        	unsortedresult.put(arrayname.get(i), arrayscore.get(i));
	        }
	        result = unsortedresult
	        		.entrySet()
	        		.stream()
	        		.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
	    }
		catch (FileNotFoundException e1) {
	            System.out.println("The specified file not found" + e1);
	    }
		catch (IOException ex) {
	        System.err.println("ERROR reading scores from file");
	    }
	}
	
	public Map<String, Integer> getScoreList() {
		return result;
	}

}
