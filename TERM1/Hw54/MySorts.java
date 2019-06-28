//Jeffrey Weng
//APCS1 pd5
//Hw 54 -- Never Fear, Big O Is Here! 
//2017-01-03

import java.util.ArrayList;


public class MySorts{

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    

    //bubbleSort is in the order of n^2, because it is a nested loop
    //goes through entire list, and at each pass, runs a for loop.

    public static void bubbleSort( ArrayList<Integer> data ) 
    {
    //loopCount tells us how many times we need to loop before the list is completely sorted
    int loopCount = data.size() - 1;
    while(loopCount != 0){
      loopCount -= 1;
      for(int i = 0; i < data.size() - 1; i++){
        //if the first item is greater than the second item, swap
        if((int)data.get(i) > (int)data.get(i+1)){
          int temp = (int)data.get(i);
          data.set(i, data.get(i + 1));
          data.set(i+1, temp);
      }
    }
  }
    }//end bubbleSort

    //insertionSort is in the order of n^2, because it also uses a nested loop
    //insertionSort becomes the order of n, if the data is in its best possible scenario
    //which is sorted, and it'll only loop through once with the for loop doing no operation
    //incrementing one. 
    public static void insertionSort( ArrayList<Integer> data ) 
    {
		//The boundary separating the sorted and the unsorted	
		int sortedBound = 1; 
		while (sortedBound != data.size()){
			for(int i = sortedBound; i > 0; i--){
				//test if less, then swap
				if((int)(data.get(i)) < (int)(data.get(i - 1))){
					int temp = (int)(data.get(i - 1));
					data.set(i-1, (int)(data.get(i)));
					data.set(i,temp);
				}
			}
			//increment boundary
			sortedBound += 1;
		}
    }//end insertionSort

    //selectionSort is in the order of n^2, because it also uses a nested loop
    //also goes through the entire list, and going through an entire list at each swap.
    public static void selectionSort( ArrayList<Integer> data ) 
	{
	//set looping boundaries, with index
	int index = data.size();
	while(index != 0){
		//resets maxPos to the start of the list, since we're limiting the right-most side values
		int maxPos = 0;
		//sets maxpos to the index of the greatest value
		for(int i = 0; i < index; i++){
			if((int)(data.get(i)) > (int)(data.get(maxPos))){
				maxPos = i;
			}
		}
		//obtains the max Value using maxpos
		int maxValue = (int)(data.get(maxPos));
		//swapping.....
		data.set(maxPos, data.get(index - 1));
		data.set(index - 1, maxValue);
		//Sets boundaries, making it loop through all the numbers besides the last one
		index -= 1;
		}
    }//end selectionSort


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public static void main(String[] args){
	System.out.print("INSERTION SORT: ");
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "\nArrayList coco before sorting:\n" + coco );
	insertionSort(coco);
	System.out.println( "\nArrayList coco after sorting:\n" + coco );
	System.out.println("");
	System.out.print("BUBBLE SORT: ");
	ArrayList coco1 = populate( 10, 1, 1000 );
	System.out.println( "\nArrayList coco before sorting:\n" + coco1 );
	bubbleSort(coco1);
	System.out.println( "\nArrayList coco after sorting:\n" + coco1 );
	System.out.println("");
	System.out.print("SELECTION SORT: ");
	ArrayList coco2 = populate( 10, 1, 1000 );
	System.out.println( "\nArrayList coco before sorting:\n" + coco2 );
	selectionSort(coco2);
	System.out.println( "\nArrayList coco after sorting:\n" + coco2 );
	/*===============for VOID methods=============
	  ============================================*/

    }





}
