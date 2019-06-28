//Jeffrey Weng
//APCS2 pd5
//Hw06 -- Step 1. Split, Step 2: ?, Step 3: Sorted!
//2017-02-11

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int indexA = 0;
	int indexB = 0;
	int counter = 0;
	int[] arr = new int[a.length + b.length];
	//compares index values, that are saved until a value is shown to be bigger
	//while the lower value is appended to the int[] arr
	while(indexA < a.length || indexB < b.length){
	    //if indexA of the the int[] a is greater than the length, then just append 
	    //indexes from int[] b
	    if(indexA >= a.length){
		arr[counter] = b[indexB];
		indexB += 1;
	
	    }
	    //same procedure as above
	    else if(indexB >= b.length){
		arr[counter] = a[indexA];
		indexA += 1;
	    }
	    //checks if the current a[indexA] is greater than b[indexB], if it is then append
	    //b[indexB] and increment the indexB value
	    else{
		if(a[indexA] > b[indexB]){
		    arr[counter] = b[indexB];
		    indexB += 1;
		}
		//does the same thing as above but for A, when b[indexB] is greater than a[indexA]
		else{
		    arr[counter] = a[indexA];
		    indexA += 1;     
		}
	    }
	    counter += 1;
	}	    
    
	return arr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
 public static int[] sort( int[] arr ) 
  {
      //Sets the floor and ceil of the divided values since the arr length can be even or odd
      //for example if the number is 7, it'll be separated into: 3 and 4
      int[] a = new int[(int)(Math.floor(arr.length/2.0))];
      int[] b = new int[(int)(Math.ceil(arr.length/2.0))];
      
      int counter = 0;
      
      //copies the half of arr list into the newly set a and b.
      for(int i = 0; i < (int)(Math.floor(arr.length/2.0)); i++){
	  if (a.length != 0){
	       a[i] = arr[i];
	  }
      }
      
      for(int i = (int)(Math.floor(arr.length/2.0)) ; i < arr.length ; i++){
	  if(b.length != 0){
	      b[counter] = arr[i];
	      counter += 1;
	  }	  
      }
      
      // if the length of a is equal to zero or oen and if the length of b is equal to zero
      // or one, then merge the two lists, because we know it's already sorted
      if((a.length == 1 || a.length == 0) && (b.length == 1 || b.length == 0)){
	  return merge(a, b);

      }
      // if the length is not, then merge the sort <-- which cuts the list in half again. Then
      // tests the same condition...etc
      else{
	 return merge(sort(a), sort(b));

      }
      //A Recursive Solution
  
  }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {0,1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,4,5,6};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
       
    }//end main()

}//end class MergeSort

