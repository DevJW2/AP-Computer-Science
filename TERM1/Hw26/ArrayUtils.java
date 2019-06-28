//Jeffrey Weng
//APCS1 pd 5
//HW26 I Demand Arrays!
//2016-11-02-16

public class ArrayUtils{
	//Creates a private static integer array called items;
	private static int[] items; 

	//generates random integers and places them into the array;
	public static void generate(){
		items = new int[5];
		for(int i = 0; i < items.length; i++){
			items[i] = (int)(Math.random() * 100) + 1;
		}

	}

	//gets the int array called items, and using the for each loop, returns the String version of the array of ints;
	public static String getItems(){
		String retStr = "";
		for(int i : items){
			retStr += i + "\n";
		}
		return retStr;
	}

	//Calls generate and prints out the stringified results;
	public static void main(String[] args){
		ArrayUtils.generate();
		System.out.println(ArrayUtils.getItems());

	}

} 