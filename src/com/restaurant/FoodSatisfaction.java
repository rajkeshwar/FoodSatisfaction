package com.restaurant;

/**
 * @author Rajkeshwar Prasad
 *
 */
public class FoodSatisfaction {

	/**
	 * @param satisfaction : int[] satisfaction as int array
	 * @param times        : int[] time taken as int array
	 * @param totalTime    : Total given time
	 * @param itemCount    : No of items count
	 * @return             : Return the maximum satisfaction as integer
	 */
	public int findMaxSatisfaction(int satisfaction[], int times[], int totalTime,
			int itemCount) {
		
		// Create a matrix. foods are in rows and time at in columns +1 on each
		// side
		int[][] V = new int[itemCount + 1][totalTime + 1];
		// What if the knapsack's capacity is 0 - Set all columns at row 0 to be
		// 0	
		for (int col = 0; col <= totalTime; col++) {
			V[0][col] = 0;
		}
		// What if there are no foods at home. Fill the first row with 0
		for (int row = 0; row <= itemCount; row++) {
			V[row][0] = 0;
		}
		for (int foodCount = 1; foodCount <= itemCount; foodCount++) {
			// Let's fill the values row by row
			for (int time = 1; time <= totalTime; time++) {
				// Is the current food time taken less than or equal to running
				// time
				if (times[foodCount - 1] <= time) {
					// Given a time, check if the satisfaction of the current food +
					// time of the food that we could afford with the remaining
					// time is greater than the satiscation without the current food itself
					V[foodCount][time] = Math.max(satisfaction[foodCount - 1]
							+ V[foodCount - 1][time - times[foodCount - 1]],
							V[foodCount - 1][time]);
				} else {
					// If the current food's time is more than the running
					// time, just carry forward the value without the current
					// food
					V[foodCount][time] = V[foodCount - 1][time];
				}
			}
		}
		// Printing the matrix
		// printMatrix(V);

		return V[itemCount][totalTime];
	}

	/**
	 * @param V : Two dimensional int array 
	 * Takes the matrix as input and prints in table 
	 * format on console.
	 */
	private void printMatrix(int[][] V) {
		for (int[] rows : V) {
			for (int col : rows) {
				System.out.print(col + "  ");
			}
			System.out.println();
		}
	}	
}
