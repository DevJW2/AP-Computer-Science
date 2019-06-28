//Jeffrey Weng
//APCS1 Pd 5
//Hw44 -- In America, the Driver Sits on the Left
//2016-12-12

/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion on-demand, and read/write capability on elements.
  ==================================================*/

public class SuperArray implements List //implementing interface ListInt
{
    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
	_data = new Object[10];
	_lastPos = -1;
	_size = 0;	
    }


    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
	Object[] temp = new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    /*
    //accessor method -- return value at specified index
    public int get( int index ) 
    {
	return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) 
    {
 	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }
*/


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( int newVal ) 
    { 
	//first expand if necessary
	if ( _size >= _data.length )
	    expand(); 
	_data[_lastPos+1] = newVal;
	_lastPos++;
	_size++;
    }


    //inserts an item at index
    //shifts existing elements (starting at index) right 1 slot
    public void add( int index, int newVal )
    {
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();
	else {
	    for( int i = _size; i > index; i-- ) {
		_data[i] = _data[i-1]; 
	    } 
	    _data[index] = newVal;
	    _lastPos++;
	    _size++;
	}
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) 
    { 
	for( int i=index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_data[_size-1] = 0; //unnecessary
	_size--;
	_lastPos--;
    }

    

    //-----------------NEW INTERFACE METHODS---------------
    public boolean add(Object x){
    	if ( _size >= _data.length )
	    expand(); 
		_data[_lastPos+1] = x;
		_lastPos++;
		_size++;
		
		return true; 
    }

    public Object get(int index){
		return _data[index];
    }

    public Object set(int index, Object o){
    	 Object temp = _data[index];
		_data[index] = o;
		return temp;
    }


    //return number of meaningful items in _data
    public int size() 
    { 
	return _size;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	List curtis = new SuperArray(); //Creates a new SuperArray with type ListInt
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);
	//Typecasted all curtis with SuperArray
	for( int i = 0; i < ((SuperArray)curtis)._data.length; i++ ) {
	    ((SuperArray)curtis).set(i,i*2);
	    ((SuperArray)curtis)._size++; //necessary bc no add() method yet
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	System.out.println("testing get()...");
	for( int i = 0; i < ((SuperArray)curtis)._size; i++ ) {
	    System.out.print( "item at index" + i + ":\t" );
	    System.out.println( ((SuperArray)curtis).get(i) );
	}

	System.out.println("Expanded SuperArray curtis:");
	((SuperArray)curtis).expand();
	System.out.println(curtis);

	List mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);
	//typecasts mayfield with superarray, because the list interface has now changed
	((SuperArray)mayfield).add(5); 
	((SuperArray)mayfield).add(4);
	((SuperArray)mayfield).add(3);
	((SuperArray)mayfield).add(2);
	((SuperArray)mayfield).add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	((SuperArray)mayfield).remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	((SuperArray)mayfield).remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	((SuperArray)mayfield).add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	((SuperArray)mayfield).add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	((SuperArray)mayfield).add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class SuperArray
