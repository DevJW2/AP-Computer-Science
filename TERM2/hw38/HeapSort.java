//Jeffrey Weng
//APCS2 pd3
//Hw38 -- Sort of Like Magic
//2017-05-10

import java.util.ArrayList;


public class HeapSort{

    //Sort Method
    //removeMins the amount of elements in arr and adds it into a new sortedList
    //returns that new sortedList.
    public static ArrayList sort(ALHeap arr){
	ArrayList<Integer> _sortedHeap = new ArrayList<Integer>();

	while(!arr.isEmpty()){
	    _sortedHeap.add(arr.removeMin());
	}

	return _sortedHeap;
    }

    
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
	  System.out.println(sort(pile));
	  
    }


}
