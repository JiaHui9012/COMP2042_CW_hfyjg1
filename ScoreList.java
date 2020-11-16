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

public class ScoreList extends StartEndScreen {

	ArrayList<Integer> arrayscore = new ArrayList<Integer>();
	
	public ScoreList() {
		// TODO Auto-generated constructor stub
	}

	public ScoreList(String imageLink, int size, int xpos, int ypos, double s) {
		super(imageLink, size, xpos, ypos, s);
		// TODO Auto-generated constructor stub
	}
	
	public ScoreList(int point) {
		
		File file= new File("Score.txt");
		try { 
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(file, true)); //write the score into the file
	        output.append("" + point);
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
	            int score = Integer.parseInt(line.trim()); 
	            arrayscore.add(score); //add the score into the array list
            	Collections.sort(arrayscore,Collections.reverseOrder()); //sort the array in descending order
	            line = reader.readLine();
	        }
	        reader.close();
	    }
		catch (FileNotFoundException e1) {
	            System.out.println("The specified file not found" + e1);
	    }
		catch (IOException ex) {
	        System.err.println("ERROR reading scores from file");
	    }
		
	}
	
	public ArrayList<Integer> getScoreList() {
		return arrayscore;
	}

}
