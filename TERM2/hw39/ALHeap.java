//Jeffrey Weng
//APCS2 pd3
//Hw39 -- Heaping Piles of Sordidness
//2017-05-10

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap 
{
    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers
    int _size = 0;
    
    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    { /*
	String ret = "";
	for(int i = 0; i < _heap.size(); i++){
	    ret += _heap.get(i) + ", ";
	}
	return ret;
      */
	return _heap.toString();
    }//O(1)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 

	return _heap.isEmpty(); 
    } //O(1)


    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    {
	return _heap.get(0);

    } //O(1)

    
    public int size(){
	return _size;
    }


    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.

     Algorithm
1. Add value to the end of the arraylist
2. Swap with parent, if addValue is less than the parent
3. Continue until, addvalue is not less than the parent, and does not need to be swapped

     *****************************************************/
    
    public void add( Integer addVal ) 
    { 
	_heap.add(addVal);
	int index = _heap.size() - 1;
	int parent = (index - 1)/2;
	_size += 1;
	while(_heap.get(index) < _heap.get(parent)){
	    swap(index, parent);
	    index = parent;
	    parent = (index-1)/2;
	}
    } //O(n)

    public void addEnd(int addVal){
	_heap.add(addVal);
	_size += 1;
    }



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.

Algorithm
1. Remove the last value in the arraylist, and put that in the front
2. If that value placed at root, is not the smallest, switch it with it's smallest child
3. Continue doing this until the value is smaller than its children

     *****************************************************/
     public Integer removeMin() 
    {
	int min = _heap.get(0);
	int index = 0;

	
	_heap.set(index, _heap.get(_heap.size() - 1));
	_heap.remove(_heap.size() - 1);
	
	_size -= 1;
	//Must test if the parent has children and also if the child is smaller than the parent
	while(minChildPos(index) != -1 && _heap.get(minChildPos(index)) < _heap.get(index)){
	    int value = minChildPos(index);
	    swap(index,minChildPos(index));
	    index = value;
	}

	
	return min;
	//return _heap.remove(index);
    }//O(n)
    
        public Integer removeMinPartition(int value) 
    {
	int min = _heap.get(0);
	int index = 0;
	
	_heap.set(index, _heap.get(_heap.size() - 1 - value));
	_heap.remove(_heap.size() - 1 - value);
	
	_size -= 1;
	//Must test if the parent has children and also if the child is smaller than the parent
	while(minChildPos(index, value) != -1 && _heap.get(minChildPos(index, value)) < _heap.get(index)){
	    int val = minChildPos(index, value);
	    swap(index,minChildPos(index,value));
	    index = val;
	}

	
	return min;
	//return _heap.remove(index);
    }//O(n)

    
    
    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos) 
    {
	int firstChild = 2 * pos + 1;
	int secondChild = 2 * pos + 2;
	//If no children
	if(firstChild >= _heap.size() && secondChild >= _heap.size()){
	    return -1;
	}
	//If one children return child
	else if(secondChild >= _heap.size()){
	    return firstChild;
	}
	//If one children, return child
	else if(firstChild >= _heap.size()){
	    return secondChild;
	}
	//If has two children, return the one that is smaller
        else if(_heap.get(firstChild) < _heap.get(secondChild)){
	    return firstChild;
	}
	//return the other child
	else{
	    return secondChild;
	}
    }//O(1)

    
    private int minChildPos( int pos , int end) 
    {
	int firstChild = 2 * pos + 1;
	int secondChild = 2 * pos + 2;
	//If no children
	if(firstChild >= (_heap.size() - end) && secondChild >= (_heap.size() - end)){
	    return -1;
	}
	//If one children return child
	else if(secondChild >= (_heap.size() - end)){
	    return firstChild;
	}
	//If one children, return child
	else if(firstChild >= (_heap.size() - end)){
	    return secondChild;
	}
	//If has two children, return the one that is smaller
        else if(_heap.get(firstChild) < _heap.get(secondChild)){
	    return firstChild;
	}
	//return the other child
	else{
	    return secondChild;
	}
    }//O(1)
    


    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {

	/*	

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

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	*/
	/*--V--------------MOVE ME DOWN------------------V---
	  ==|============================================|===*/
	

    }//end main()

}//end class ALHeap
