import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Score {
	
	private static ArrayList <String> temp = new ArrayList <String>();
	
	public static void createScoreFile() {
		
	    try {
	    	
	        File score = new File("TopScore.txt");
	        score.createNewFile();
	        
	      }
	    catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		
		
	}
	
	public static void readScores() { //this method reads the top 5 scores only
		
		sortScores();
		
		int n = 0;
		System.out.println("\n");
		System.out.println("TOP SCORES");
		System.out.println("Score: Name:");
		System.out.println("____________");
		try{
			
		FileReader fr = new FileReader("TopScore.txt"); 
		BufferedReader br = new BufferedReader(fr); 
		String name;
		while(n<5) { 
		
			name = br.readLine();
			System.out.println(name); 
			n++;
		
		} 
		
		fr.close(); 
		
		}
		catch(Exception e){
			
		System.err.println("Error" + e.getMessage());
		
		}
		
		
		
	}
	
	public static void writeScore(String name, String score) { //all winner scores are written into a new line in the TopScore file
		
		try{
			FileWriter writer = new FileWriter("TopScore.txt", true);
			BufferedWriter bufferWriter = new BufferedWriter(writer);
			
			bufferWriter.write(score + "	"); //writing the winner score
			bufferWriter.write(name); //writing the winner name and score to the text file
			bufferWriter.newLine();
			bufferWriter.flush();
			writer.close();
			
			
			
			}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			}
		
	}
	
	private static void sortScores() { // this method reads the file, sorts it and writes it back to the file
		
		temp.clear();
		
		try{
			
		FileReader fr = new FileReader("TopScore.txt"); 
		BufferedReader br = new BufferedReader(fr); 
		String name;
		while((name = br.readLine())!= null) { 
		
			temp.add(name);
		} 
		
		Collections.sort(temp, Collections.reverseOrder());
		fr.close(); 
		
		FileWriter writer = new FileWriter("TopScore.txt");
		
		int count = 0;
		
		for (String s:temp) {
			
			writer.write(s + "\n");
			count++;
			
			
			if (count==5) {
				break;
			}
		}
		writer.close();
		
		
		}

		
		catch(Exception e){	
			
		System.err.println("Error" + e.getMessage());
		
		}
	}
	
	

}
