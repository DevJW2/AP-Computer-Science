//Jeffrey Weng
//APCS pd3
//Hw17 -- Give and Take
//2017-03-14


/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_head = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    /* YOUR IMPLEMENTATIONS HERE */
    public boolean add( String x ){
	if (_head == null){
	    _head = new LLNode(x, null);
	    _size += 1;
	}
	else{
	    LLNode tmp = _head;
	    while(tmp.getNext() != null){
		tmp = tmp.getNext();
	    }
	    tmp.setNext(new LLNode(x, null));
	    _size += 1;
	}
	return true;
    }
    
    public String get( int i ){
	LLNode tmp = _head;
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

    public String set( int i, String x ){
	LLNode tmp = _head;
       	for (int b = 0; b < i - 1; b++){
	    tmp = tmp.getNext();
	    // tmp.getCargo();
	}
	tmp.setCargo(x);
	return x;
    }
    
    public void add(int index, String newVal){
	LLNode tmp = _head;

	if(_head == null){
	    return;
	}
	if(index == 0){
	    _head = new LLNode(newVal, _head);
	    return;
	}
	for(int i = 0; i < index - 1; i++){
	    tmp = tmp.getNext();
	}
	if(tmp != null){
	    tmp.setNext(new LLNode(newVal, tmp.getNext()));
	    //tmp.setCargo(newVal);
	}
	
	
    }
    
    /*
    public void add(int index, String newVal){
	LLNode prev = null;
	LLNode current = _head;
	
	if(_head == null){
	    return;
	}
	if(index == 0){
	    _head = new LLNode(newVal, _head);
	    return;
	}
	for(int i = 0; i < index; i++){
	    prev = current;
	    current = current.getNext();
	}
	if(current != null){
	    prev.setNext(new LLNode(newVal, current));
	}
    }
    */
    public String remove(int index){
	LLNode tmp = _head;
	LLNode prev = null;
	LLNode current = _head;
	if(_head == null){
	    return "empty";
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
	LLNode tmp = _head; //init tr
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


