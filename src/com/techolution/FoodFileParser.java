package com.techolution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public List<Food> fileToFoodList() throws FileNotFoundException {

		Scanner scan = new Scanner(new File(this.getFilePath()));

		List<Food> foodList = new ArrayList<Food>();
		Food food = null;
		int lineCounter = 0;
		
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] splitStr = line.split("\\s+");
			
			lineCounter += 1;
			
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
