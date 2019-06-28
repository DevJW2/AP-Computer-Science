//Jeffrey Weng
//APCS pd3
//Hw18b -- On the DLL
//2017-03-15


/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of DLLNodes.
 *****************************************************/

public class LList<T> implements List<T> 
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_head = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    /* YOUR IMPLEMENTATIONS HERE */
    public boolean add( T x ){
	if (_head == null){
	    _head = new DLLNode(x, null, null);
	    _size += 1;
	}
	else{
	    DLLNode<T> tmp = _head;
	    while(tmp.getNext() != null){
		tmp = tmp.getNext();
	    }
	    tmp.setNext(new DLLNode(x, null, null));
	    _size += 1;
	}
	return true;
    }
    
    public T get( int i ){
	DLLNode<T> tmp = _head;
	/*
	int counter = 0;
	while(tmp != null){
	    
	    if(counter == i){
		return tmp.getCargo();
	    }
	    else{
		counter += 1;
	    }
	    tmp = tmp.getNext();
	}
	return "Nothing Found";
	*/
	for(int x = 0; x < i - 1; x++){
	    tmp = tmp.getNext();
	}
	return tmp.getCargo();
    } 

    public T set( int i, T x ){
	DLLNode<T> tmp = _head;
       	for (int b = 0; b < i - 1; b++){
	    tmp = tmp.getNext();
	    // tmp.getCargo();
	}
	tmp.setCargo(x);
	return x;
    }
    
    public void add(int index, String newVal){
	DLLNode<T> tmp = _head;

	if(_head == null){
	    return;
	}
	if(index == 0){
	    _head = new DLLNode(newVal, _head, null);
	    return;
	}
	for(int i = 0; i < index - 1; i++){
	    tmp = tmp.getNext();
	}
	if(tmp != null){
	    tmp.setNext(new DLLNode(newVal, tmp.getNext(), null));
	    //tmp.setCargo(newVal);
	}
	
	
    }
    
    /*
    public void add(int index, String newVal){
	DLLNode prev = null;
	DLLNode current = _head;
	
	if(_head == null){
	    return;
	}
	if(index == 0){
	    _head = new DLLNode(newVal, _head);
	    return;
	}
	for(int i = 0; i < index; i++){
	    prev = current;
	    current = current.getNext();
	}
	if(current != null){
	    prev.setNext(new DLLNode(newVal, current));
	}
    }
    */
    public T remove(int index){
    DLLNode<T> tmp = _head;
	DLLNode<T> prev = null;
	DLLNode<T> current = _head;
	if(_head == null){
	    return tmp.getCargo();
	}
    for(int i = 0; i < index; i++){
	    prev = current;
	    current = current.getNext();
	}
	if(current != null){
	    prev.setNext(current.getNext());
	}	

	return tmp.getCargo();
    }

    


    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(2) );

	james.set( 2, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(2,"got") );

	System.out.println( james );

	System.out.println("new Add method");
	james.add(3,"item");
	System.out.println(james);

	System.out.println("Removing...");
	james.remove(3);
	System.out.println(james);
		/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class LList


