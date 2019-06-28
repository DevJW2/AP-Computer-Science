//Jeffrey Weng
//APCS2 pd3
//Hw39 -- Heaping Piles of Sordidness
//2017-05-10

import java.util.ArrayList;


public class HeapSort{

    //Sort Method 
    public static void sort(ALHeap arr){
	for(int i = 0; i < arr.size(); i++){
	    //adds to the end of the heap, while removing the min of a partition
	    arr.addEnd(arr.removeMinPartition(i));
	    System.out.println(arr);
	}  
    }

    //For clarification
    //new size method, keeps track of the amount of elements in the heap
    //new addEnd method, which just adds the value to the end of the heap, without heapification
    //new removeMinPartition method, takes in a value that subtracts that value which creates a partition.removeMin only heapifies the values before the partition.
    //new removeMinPartition method, implements a new minChildPos which takes in a new parameter value, which essentially finds the minimum child position based off of the partition that was created from removeMinPartition.
    /*EXAMPLE:
      [2, 4, 3, 5, 9, 6, 10, 8, 7| 1]
      [3, 4, 6, 5, 9, 7, 10, 8| 1, 2]
      [4, 5, 6, 8, 9, 7, 10| 1, 2, 3]
      [5, 8, 6, 10, 9, 7| 1, 2, 3, 4]
      [6, 8, 7, 10, 9| 1, 2, 3, 4, 5]
      [7, 8, 9, 10| 1, 2, 3, 4, 5, 6]
      [8, 10, 9| 1, 2, 3, 4, 5, 6, 7]
      [9, 10| 1, 2, 3, 4, 5, 6, 7, 8]
      [10| 1, 2, 3, 4, 5, 6, 7, 8, 9]
      [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
      [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]    

     */
    public static void main(String[] args){
	  ALHeap pile = new ALHeap();
	  
	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("Sorted List....");
	  sort(pile);
	  System.out.println(pile);
	  
    }


}
