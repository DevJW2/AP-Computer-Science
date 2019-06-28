//Jeffrey Weng
//APCS2 Pd3
//HW14 -- SO SO Fast
//2017-03-07


public class FastSelect{
    /*
      Algorithm uses the S value in the Mysterion method to find the yth smallest value. Since the S value is the last
      value to which the number will be in a sorted list, you can tell the yth smallest value by finding out the position of the 
      value. Therefore my algorithm, loops through the list, testing each number's position, and finding out which number is the yth-
      smallest value. For example, if I had a testcase {1,8,9,4,6}:

      The algorithm will run through the list, first checking one, which returns a 1, so therefore 1 is the 1st smallest value, then it will check 8
      which returns 4, which is the 4th smallest value, and so forth. 


     */

    public static int findYth(int y, int[] arr){      
	int[] tempArray = new int[arr.length];
	for(int x = 0; x < arr.length; x ++){
	    tempArray[x] = arr[x];
	}
	for(int i = 0; i < arr.length; i++){
	    int[] temp = new int[tempArray.length];
	    for(int z = 0; z < tempArray.length; z++){
		temp[z] = tempArray[z];
	    }	  
	    if(Mysterion.sortPosition(temp,0,arr.length - 1,i) == (y - 1)){
		return tempArray[i];
		
	    }
	}
	return 0;
	
    }


    public static void main(String[] args){
	int[] thing = {1,8,9,4,6};
	System.out.println(findYth(5, thing));
    }

}
