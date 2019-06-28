//Jeffrey Weng
//APCS1 pd5
//HW45 -- Al<B> Sorted! 
//2016-12-13

import java.util.ArrayList;
public class ALTester{
    public static void main(String[] args){
    	ArrayList<Integer> arr = new ArrayList<Integer>(); //crates arr, and tests populate, and testsort
    	populate(arr);
    	System.out.println(arr);
    	System.out.println(testSort(arr));
    }
    public static void populate(ArrayList<Integer> thing){ //populates a arraylist with the integer generic
    	for(int i = 0; i < 23; i++){
    		thing.add(i);
    	}
    }
    public static boolean testSort(ArrayList<Integer> thing){ //tests if the numbers are in ascending order
    	for(int i = 0; i < thing.size() - 1; i++){
    		if(thing.get(i) > thing.get(i + 1)){
    			return false;
    		}
    	}
    	return true;
    }
}