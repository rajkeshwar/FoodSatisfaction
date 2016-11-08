package com.restaurant;

/**
 * @author Rajkeshwar Prasad
 *
 */
public class Food {
	  
	private int timeTaken;
	private int satisfaction;
	
	public Food() {
		super();
	}

	public Food(int timeTaken, int satisfaction) {
		super();
		this.timeTaken = timeTaken;
		this.satisfaction = satisfaction;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}	
}
