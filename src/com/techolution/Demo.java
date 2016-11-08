package com.techolution;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {
	
	public static void main(String[] args) {
		
		final String INPUT_FILE_PATH = "C:\\fileread\\input-data.txt";
		List<Food> foodList = new ArrayList<Food>();
		FoodFileParser foodFileParser = new FoodFileParser(INPUT_FILE_PATH);
		
		try {
			foodList = foodFileParser.fileToFoodList();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Integer> satisfactionList = new ArrayList<Integer>();
	    List<Integer> timeList = new ArrayList<Integer>();
	    
	    for (Food eachFood : foodList) {
	    	satisfactionList.add(eachFood.getSatisfaction());
	    	timeList.add(eachFood.getTimeTaken());
		}
	    
	    int[] satisfactions = toArray(satisfactionList);
	    int[] times = toArray(timeList);
	    
	    for (int i = 0; i < times.length; i++) {
			System.out.println(satisfactions[i] + " - " + times[i]);
		}
	    
	    FoodSatisfaction  foodSatisfaction = new FoodSatisfaction();
	    int maxValue = foodSatisfaction.findMaxSatisfaction(satisfactions, times, foodFileParser.getMaxTime(), foodFileParser.getFoodCount());
	    
	    System.out.println("Maximum satisfaction is : " + maxValue);
		
	}
	
	private static int[] toArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		int i = 0;

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			ret[i++] = it.next();
		}

		return ret;
	}
	
}

