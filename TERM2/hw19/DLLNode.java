//Jeffrey Weng
//APCS2 pd3
//Hw19 -- On the DLL
//2017-03-15

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode<T>
{

    private T _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next DLLNode
    private DLLNode _prevNode; //pointer to previous DLLNode
    
    // constructor -- initializes instance vars
    public DLLNode( T value, DLLNode next, DLLNode prev )
    {
        _cargo = value;
        _nextNode = next;
        _prevNode = prev;
    }

    

    //--------------v  ACCESSORS  v--------------
    public T getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() {return _prevNode;}
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setCargo( T newCargo ) 
{
    _cargo = newCargo;
    return _cargo;
    }

    public DLLNode setNext( DLLNode newNext ) 
{
    _prevNode = _nextNode;
    _nextNode = newNext;
    
    return _nextNode;
    }
    
    public DLLNode setPrev(DLLNode newPrev){
        _prevNode = newPrev;
        return _prevNode;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
     public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args ) 
    {

	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( "cat", null, null );

	//Create a new node after the first
	first.setNext( new DLLNode( "dog", null, first));

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( "cow", null, first.getNext() ) );


		/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	while( first != null ) {
	    System.out.println( first );
	    first = first.getNext();
	}
	

	//Q: When head ptr moves to next node in list,
	//   what happens to the node it just left?
	/*
	  Since each node references the one to the right of it, the one to the left goes unchanged, however the head will change 
	  to the next node. 

	 */
	}

//end main

}//end class DLLNode
