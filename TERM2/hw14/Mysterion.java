//Jeffrey Weng
//APCS2 pd3
//HW12 -- We Be Dem
//2017-03-06

/*

The function mysterious which I now call sortPosition  essentially takes in three parameters. The first parameter is the starting position(startPos), second parameter is the max position(maxPos), and the last parameter: which position to sort(posSort). 

These parameters help the the function determine how to sort a specific value in the array. For example, in a list of 5 {1,2,3,4,5}, the maxPos would be 4(since we're taking the index value), and the startPos would be 0. We can then choose the value we want to sort, so if I choose 2, then I'll be sorting the number 3. After the function runs, the list stays the same because the specific number is already sorted.

 However if we use a list like: {1,2,1082,4,5}, and we use the same parameters, the new list would have the 1082 at the end. 

The s value which I called newPosSorted, is the value of the sorted value in the new list. In the past example, that'll be 4. In the previous example to that, it would be 2 since 3 is still in the same position. 


 */


public class Mysterion{
    

    public static void printSol(int[] arr){
	String retStr = "";
	for (int i = 0; i < arr.length; i++){
	    retStr += arr[i] + ", ";
	}
	System.out.println(retStr);
    }

    public static void swap(int[] arr, int num1, int num2){
	int old = arr[num1];
	arr[num1] = arr[num2];
	arr[num2] = old;	   
    }

    public static int sortPosition(int[] arr, int startPos, int maxPos, int posSort){
	int v = arr[posSort];
	System.out.println("Before: ");
	printSol(arr);
	   
	swap(arr, posSort, maxPos);
	System.out.println("After first swap: ");
	printSol(arr);
	
	int s = startPos;
	for(int i = startPos; i < maxPos; i++){
	    if (arr[i] < v){
		swap(arr, s, i);
		System.out.println("i: " + i);
		System.out.println("In For Loop, list: ");
		printSol(arr);
		s += 1;
	    }
	}
	System.out.println(s);
	System.out.println("Before Final Swap: ");
	printSol(arr);
	swap(arr, maxPos, s);
	System.out.println("After Final Swap: ");
	printSol(arr);
	return s;
	    
    }


        
    public static void main(String[] args){
	int[] thing = {1,8,9,4,6};
	int[] item = {1,2,1082,3,4};
	int[] weird = {1,2,3,4,5};
	int[] longer = {1,2,4,6,12,4,2,45,10,87,9};
	System.out.println("----------------------------------");
	System.out.println(sortPosition(thing,0,4,4));
	System.out.println("----------------------------------");
	System.out.println(sortPosition(item,0,4,2));
	System.out.println("----------------------------------");
	System.out.println(sortPosition(weird,0,4,3));
	System.out.println("----------------------------------");
	System.out.println(sortPosition(longer,0,10,7));
	System.out.println("----------------------------------");
	
	
    }
}
