//Jeffrey Weng, Matteo Wong
//APCS2 pd3
//HW02 -- I Am Still Searching
//2017-2-2

//Team: Marmalade 

/*
Starting from the top right of the 2D array, since the array is increasing from top to bottom and left to right, we can say that if the target is less than the chosen number we can go back one column, and if the target is more than the chosen number we can increase one row. 

 */

public class MatrixFinder{
    public static String algo(int[][] arr, int target){
	int row = 0;
	int column = arr.length - 1;
	while(arr[row][column] != target){
	    if(arr[row][column] > target && column > 0){
		column -= 1;

	    }
	    else if(arr[row][column] < target && row < arr.length - 1){
		row += 1;

	    }
	    else{
		return "(-1,-1)";
        
	    }

	}
	return "(" + row + "," + column + ")"; 
	
	
    }
    public static void main(String[] args){
	int[][] item = {{1,3,5},{3,7,8},{5,12,15}};
	int[][] test = {
	    {1, 5, 8, 10, 13},
	    {3, 7, 9, 11, 15},
	    {6, 12, 13, 16, 17},
	    {11, 13, 15, 19, 21},
	    {14, 17, 18, 22, 30}
	};
	System.out.println(algo(item, 0));
	System.out.println(algo(test,1));
	System.out.println(algo(test,13));
	System.out.println(algo(test,14));
	System.out.println(algo(test,30));
	System.out.println(algo(test,15));
    }
}
