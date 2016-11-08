# FoodSatisfaction
This app finds the maximum satisfaction with given set of times

Place the input file in `C:\\fileread\\input-data.txt` from 
the location FoodSatisfaction\src\com\techolution\input-data.txt

or change the `INPUT_FILE_PATH` in Demo.java file and run using main method
final String INPUT_FILE_PATH = "C:\\fileread\\input-data.txt";


Files 
-----------------------------------------------------------
1) RestaurantDemo.java
2) FoodSatisfaction.java
3) FoodFileParser.java
4) Food.java
5) restaurant-data.txt (which has the data to parse)

Here is the approach which I followed.
-----------------------------------------------------------------------------------
1) parsed the file `restaurant-data.txt` to get the input data
2) Took the first line and stored `maximum` time and `food count` 
    in maxTime and foodCount
3) Did a table comparison like 
4) Is the current food time taken less than or equal to running time

       if (times[foodCount - 1] <= time) {

    Given a time, check if the satisfaction of the current food +
    time of the food that we could afford with the remaining
    time is greater than the satiscation without the current food itself

V[foodCount][time] = Math.max(satisfaction[foodCount - 1]
		+ V[foodCount - 1][time - times[foodCount - 1]], V[foodCount - 1][time]);

5) else If the current food's time is more than the running
    time, just carry forward the value without the current food

   V[foodCount][time] = V[foodCount - 1][time];

6) Finally it returns the maximum satisfaction value.

   V[itemCount][totalTime];

Output: 
=================================
Maximum satisfaction is : 2493893