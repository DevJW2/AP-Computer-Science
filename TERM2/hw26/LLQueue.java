//Jeffrey Weng
//APCS2 - PD3
//Hw#26 -- The English Do Not Wait In Line for Soup or Anything Else; They “Queue Up”
//2017-03-28

/*****************************************************
 * class LLQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    private int _size;

    // default constructor creates an empty queue
    public LLQueue()
    { 
	_front = null;
	_end = null;
    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
	if (_front == null){
	    _front = new LLNode(enQVal, null);
	}
	else{
	    LLNode tmp = _front;
	    while(tmp.getNext() != null){
		tmp = tmp.getNext();
	    }
	    tmp.setNext(new LLNode(enQVal, null));
	}
	    //_end = new LLNode(enQVal, _end);
	
    }//O(1)

    
    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    {
	T tmp = _front.getValue();
	_front = _front.getNext();
	return tmp;
    }//O(?)


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
	return _front.getValue();
    }//O(?)


    public boolean isEmpty() 
    {
	if(_front == null){
	    return true;
	}
	return false;
    }//O(?)


    // print each node, separated by spaces
    public String toString() 
    { 
	String retStr = "";
	LLNode<T> tmp = _front; //init tr
	while( tmp != null ) {
	    retStr += tmp.getValue() + "->";
	    tmp = tmp.getNext();
	}
	return retStr;
    }//O(?)

    

    public static void main( String[] args ) {

	Queue<String> LLQueuelJ = new LLQueue<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	LLQueuelJ.enqueue("James");
	LLQueuelJ.enqueue("Todd");
	LLQueuelJ.enqueue("Smith");

	System.out.println("\nnow testing toString()...");
	
	System.out.println( LLQueuelJ ); //for testing toString()...


	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( LLQueuelJ.dequeue() );
		System.out.println( LLQueuelJ.dequeue() );
		System.out.println( LLQueuelJ.dequeue() );
	System.out.println(LLQueuelJ);

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( LLQueuelJ.dequeue() );

		/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue
