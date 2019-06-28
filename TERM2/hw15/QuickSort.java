//Jeffrey Weng
//APCS2 pd3
//Hw15 -- So So Quick
//2017-03-08

/*****************************************************
 * class QuickSort
 * 
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
1) Pick Pivot
2) Partition the Array, so now you have all greater than or equal numbers to the right of the pivot
and all less than pivot to the left
3) Since the pivot is sorted, recursively solve left and right lists, going back to step 1
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
 *First and last elements of a list is the worse pivot choice/ order of O(n^2)
 * 2b. Best pivot choice / array state and associated runtime:
 *Best would be right in the middle of the list/O(n log n)
 * 3. Approach to handling duplicate values in array:
 *Greater or equal to the pivot set it to the right, which accounts for duplicates.
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/


/***
algo qsort(arr, left, right)
 if left < right
  pvtPos = partition(arr, left, right)
  qsort(arr, left, pvtPos - 1)
  qsort(arr, pvtPos + 1, right)


 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int[] o, int x, int y ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap(d, i, swapPos );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );

	return retArr;
    }


    public static int partition(int[] arr, int startPos, int maxPos, int posSort){
	int v = arr[posSort];
	//System.out.println("Before: ");
	//printSol(arr);
	   
	swap(arr, posSort, maxPos);
	//System.out.println("After first swap: ");
	//printSol(arr);
	
	int s = startPos;
	for(int i = startPos; i < maxPos; i++){
	    if (arr[i] < v){
		swap(arr, s, i);
		//System.out.println("i: " + i);
		//System.out.println("In For Loop, list: ");
		//printSol(arr);
		s += 1;
	    }
	}
	//System.out.println(s);
	//System.out.println("Before Final Swap: ");
	//printSol(arr);
	swap(arr, maxPos, s);
	//System.out.println("After Final Swap: ");
	//printSol(arr);
	return s;
	    
    }
    
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/

    public static void qsort(int[] d){
	qsort(d, 0, d.length - 1);
    }

    
    public static void qsort( int[] d, int left, int right ){
	if(left < right){
	    int pvtPos = partition(d, left,right, (left + right)/2);
	    qsort(d, left, pvtPos - 1);
	    qsort(d, pvtPos + 1, right);
	}
    } 
    
	

    

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.




    //main method for testing
    public static void main( String[] args ) 
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1);	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN);
	System.out.println("arrN after sort: " );
	printArr(arrN);
		/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);

		/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main
}//end class QuickSort
