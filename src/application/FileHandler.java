package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// class final so no object can be created;
// cannot be extended and in it
// attributes and methods are all static
public final class FileHandler {
	
    // read assuming data is well formatted, if not
    // make sure the csv is in the correct format
    // This program needs be modified to checking data format	
    public  static void readCSVFile(String fileName) {
	BufferedReader reader = null;
        try{
	    //Create a new list of ratings from CSV file data 
	    List<MovieRating> ratings = new ArrayList<MovieRating>();
            reader = new BufferedReader(new FileReader(fileName));
            String line = " ";          
            //Skip the CSV file header 
	    reader.readLine();           
            //Read the file line by line starting from the second line
            while ((line = reader.readLine()) != null) {
                //Get all tokens by splitting using the comma
		//We know the data has 3 columns 0, 1, 2
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
		    //Create a new rating object and fill his  data
		    try {
			long uid = Long.parseLong(tokens[0]);
			long mid = Long.parseLong(tokens[1]);
			double val = Double.parseDouble(tokens[2]);
			MovieRating rating = new MovieRating(uid, mid, val);
			ratings.add(rating);
		    } catch (Exception e) { // a bit lazy here but its OK!
			System.out.println("Wrong data format in the file!");
			System.exit(0);
		    }
		}
            }
            
            //Print the new ratings list
            for (MovieRating rating : ratings) {
		System.out.println(rating.toString());
	    }
        } 
        catch (Exception e) {
	    System.out.println("Error in reading CSV file !!!");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing Reader !!!");
                e.printStackTrace();
            }
        }
    }

    // Writing to a CSV File in appending mode
    public static  void write2CSVFile(String fileName) {		
	//Create an array of rating objects
	MovieRating[] ratings = {new MovieRating(100, 200, 4.8), new MovieRating(101, 100,2.8)};
	FileWriter writer = null;				
	try {
	    writer = new FileWriter(fileName, true);		
	    //Write the new ratings into the CSV file
	    for (MovieRating rating : ratings) {
		writer.append(String.valueOf(rating.getUserID()));
		writer.append(",");
		writer.append(String.valueOf(rating.getMovieID()));
		writer.append(",");
		writer.append(String.valueOf(rating.getValue()));
                writer.append(",");
	    }	
	} catch (Exception e) {
	    System.out.println("Error in CsvFileWriter!");
	    e.printStackTrace();
	} finally {			
	    try {
		writer.flush();
		writer.close();
	    } catch (IOException e) {
		System.out.println("Error while flushing/closing fileWriter!");
		e.printStackTrace();
	    }
			
	}
    }
}
