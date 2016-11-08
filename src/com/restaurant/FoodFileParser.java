package com.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rajkeshwar Prasad
 *
 */
public class FoodFileParser {
	
	private int maxTime = 0;
	private int foodCount = 0;
	private String filePath;
	
	public FoodFileParser( final String filePath ) {
		this.filePath = filePath;
	}
	public int getMaxTime() {
		return maxTime;
	}
	private void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	public int getFoodCount() {
		return foodCount;
	}
	private void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	public String getFilePath() {
		return filePath;
	}
	
	/**
     * @param : No need to pass any parameter. It takes the filepath
     * 			while creating the object of this class
     *
     * @return List<Food> by parsing the text file
     * @throws FileNotFoundException if the iteration has no more elements
     */
	
	public List<Food> fileToFoodList() throws FileNotFoundException {
		
		// Reading the input file from the file path passed
		Scanner scan = new Scanner(new File(this.getFilePath()));

		List<Food> foodList = new ArrayList<Food>();
		
		Food food = null;
		int lineCounter = 0;
		
		// Iterating line by line 
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			
			// Splitting each line to get the left part ie. satisfaction
			// and right most part ie. time taken
			String[] splitStr = line.split("\\s+");
			
			lineCounter += 1;
			
			// Checking if it is the first record to get the 
			// maximum time and food count
			if( lineCounter == 1 ) {
				this.setMaxTime(Integer.parseInt(splitStr[0]));
				this.setFoodCount(Integer.parseInt(splitStr[1]));
			} else {
				food = new Food();
				food.setSatisfaction(Integer.parseInt(splitStr[0]));
				food.setTimeTaken(Integer.parseInt(splitStr[1]));

				foodList.add(food);
			}
		}
		
		return foodList;
	}
}
