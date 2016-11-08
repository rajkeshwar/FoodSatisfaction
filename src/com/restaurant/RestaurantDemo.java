package com.restaurant;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rajkeshwar Prasad
 *
 */
public class RestaurantDemo {
	
	public static void main(String[] args) {
		
		final String INPUT_FILE_PATH = "restaurant-data.txt";
		URL url = RestaurantDemo.class.getClassLoader().getResource(INPUT_FILE_PATH);
		
		List<Food> foodList = new ArrayList<Food>();
		FoodFileParser foodFileParser = new FoodFileParser(url.getPath());
		
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
	    
	    System.out.println("=================================");
	    
	    FoodSatisfaction  foodSatisfaction = new FoodSatisfaction();
	    int maxValue = foodSatisfaction.findMaxSatisfaction(
	    		satisfactions, times, foodFileParser.getMaxTime(), foodFileParser.getFoodCount());
	    
	    System.out.println("Maximum satisfaction is : " + maxValue);
		
	}
	
	/**
	 * @param list; List<Integer>
	 * 	Takes list of Integer as input and return the primitive `int` array
	 * @return
	 */
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

