//Jeffrey Weng
//APCS2 - pd3
//Hw28 -- Now Let's Consider You Lot at Fake Terry's
//2017-03-30

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{ 
	    _front = null;
	    _end = null;
	    _size = 0;
	}

    //Adds another object to the line
    public void enqueue( T enQVal ) 
    {
	if(_front == null){
	    _front = new LLNode(enQVal, null);
	    _end = _front;
	    _size += 1;
	}
	else{
	    _end.setNext(new LLNode(enQVal, null));
	    _end = _end.getNext();
	    _size += 1;
	}
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    {
	sample();
	T tmp = _front.getValue();
	_front = _front.getNext();
	_size -= 1;
	return tmp; 
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
      1) Create two nodes 
      2) One node will point to teach element in the linked list 
      3) The other node will be the pointer that points to the element that has been randomly selected
      4) Loop through the list while generating a random position for the current number to swap with
      5) Swap numbers
      6) Reset second node
      7) Repeat from step 4 until first node has went through the entire linked list

     ******************************************/
    public void sample() 
    {

	LLNode<T> tmp = _front;
	LLNode<T> swapp = _front;

	while(tmp != null){
	    // System.out.println(tmp.getValue());
	    //toString();
	    int rand = (int)(Math.random() * _size);
	    // System.out.println(rand);
	    for(int n = 0; n < rand; n++){
		swapp = swapp.getNext();
	    }
	    //swap
	    T item = tmp.getValue();
	    tmp.setValue(swapp.getValue());
	    swapp.setValue(item);
	    //next object
	    tmp = tmp.getNext();
	    //reset
	    swapp = _front;
	 
	}
	
    }

    //tests if the linked list is empty or not
    public boolean isEmpty() 
    { 
	if(_front == null){
	    return true;
	}
	return false;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String retStr = "";
	LLNode<T> tmp = _front; //init tr
	while( tmp != null ) {
	    retStr += tmp.getValue() + "->";
	    tmp = tmp.getNext();
	}
	//System.out.println(retStr);
	return retStr;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	  	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue
