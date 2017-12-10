package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {

	
	 public static void main(String[] argv) {	
//		 try{
//			 FileReader fr = new FileReader("myratings.csv");
//			 BufferedReader br = new BufferedReader(fr);
//			 String str;
//			 while((str = br.readLine()) != null){
//				 System.out.println(str + "\n");
//			 }
//			 br.close();
//		 }
//		 catch(Exception e ){
//			 //
//			 e.getStackTrace();
//			 //System.out.println("File not found");		 
//			 }
		 

	        String csvFile = "movies.csv";
	        String line = "";
	        String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] country = line.split(cvsSplitBy);

	                System.out.println(Arrays.toString(country));

	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
		 
		 
		 
		 
//		 try{
//			 List<String> lines = Files.readAllLines(Paths.get("/Resources/myratings.csv"));
//			for(String line : lines){
//				line = line.replace("\" , "");
//						System.out.println(line);
//			}
//		 }
//		 catch(Exception e){
//			 System.out.println(e.getMessage());
//	
//		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
//		 Scanner scanner;
//		 List<MovieRating> ratings = new ArrayList<MovieRating>();
//		 try{
//			 scanner = new Scanner(new File("/Resources/myratings.csv"));
//			 scanner.useDelimiter(",");
//		 }
//			String fileName = "myratings.csv"; // assume this file is already there
//			System.out.println("Write into CSV file:");
//			FileHandler.write2CSVFile(fileName);		
//			System.out.println("\nRead CSV file:");
//			FileHandler.readCSVFile(fileName);
//		    }


