//Jeffrey Weng
//APCS1 pd5
//Hw39 -- Put it together
//2016-12-4

/* 
Swapper will create a 2D array of 3 or 4 character Strings and display it in terminal.
It will then prompt the user to specify two locations, swapping the items at these locations,
and then redisplaying the array. 
Note:
The locations will be specified at the row and column number
using a reference printed out by the main method. 
*/

import cs1.Keyboard;
public class Swapper{
	//Creates a 2D array called two_dim with unique Strings
	private static String[][] two_dim = {{"boy","girl"},{"burn","dog","cat"}}; 
	public static void main(String[] args){
		//Prints out the different options to switch
		for(int i = 0; i < two_dim.length; i++){
			System.out.println("");
			System.out.println("row: " + i);
			System.out.println("-------------------");
			for(int n=0; n < two_dim[i].length; n++){
				System.out.println("column: " + n);
				System.out.println(two_dim[i][n]);
			}
		}
		//calls method swap
		swap();
		//Prints out again the results
		for(int i = 0; i < two_dim.length; i++){
			System.out.println("");
			System.out.println("row: " + i);
			System.out.println("-------------------");
			for(int n=0; n < two_dim[i].length; n++){
				System.out.println("column: " + n);
				System.out.println(two_dim[i][n]);
			}
		}

	}
	//Swap method
	public static void swap(){
		System.out.println("Which Strings do you want to swap?");
		//Obtains the first string, using the row and column
		System.out.println("First String: ");
		System.out.println("Row Number: ");
		int row1 = Keyboard.readInt();
		System.out.println("Column Number: ");
		int col1 = Keyboard.readInt();
		//Obtains the second string, using the row and column
		System.out.println("Second String: ");
		System.out.println("Row Number: ");
		int row2 = Keyboard.readInt();
		System.out.println("Column Number: ");
		int col2 = Keyboard.readInt();

		System.out.print("Your two Strings are: ");
		System.out.println(two_dim[row1][col1] + " " + two_dim[row2][col2]);
		System.out.println("Swapping.....");
		//Swaps the two Strings
		String item1 = two_dim[row1][col1];
		String item2 = two_dim[row2][col2];

		two_dim[row1][col1] = item2;
		two_dim[row2][col2] = item1;
		
		}
	}



