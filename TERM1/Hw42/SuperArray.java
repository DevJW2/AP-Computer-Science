/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/
// Jeffrey Weng, Mark Shafran
// APCS1 pd05
// HW42 -- Array of Grade 316
// 2016-12-08   

public class SuperArray 
{
    private int[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
    _data = new int[10]; // makes _data inst var an empty 10 item array
	_lastPos = -1;
	_size = 0;
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
        String retStr = "[" + _data[0]; // starts string with bracket and first item in array
	for (int x = 1; x < _data.length ; x++) { // loops through entire array, starting with second item
	    retStr += "," + _data[x];// appends a comma and next item to retStr
	}
	retStr += "]";//finishes retStr with a bracket
	return retStr;//returns retStr
    }

    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
        int[] narr = new int[_data.length*2 ];// initializes a new temporary array with size _data.length*2
	for (int x = 0; x < _data.length ; x++) {// loops through old array
	    narr[x] = _data[x];// copies values from old array into new array
	}
	_data = narr;// sets old array equal to the new, larger array
    }

    //accessor method -- return value at specified index
    public int get( int index ) 
    {
        return _data[index];// returns value in _data at index
    }

    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) 
    {
    int oldVal = _data[index];// creates a var with the old value of _data[index]
	_data[index] = newVal; // replaces old value at index with newVal
	return oldVal;// returns old value
    }


    //adds an item after the last item
    public void add( int newVal ) 
    { 
        int[] narr = new int[_data.length + 1]; // Creates a new array called narr with a _data size + 1
		for (int x = 0; x < _data.length ; x++) { 
	    	narr[x] = _data[x]; //Copies values from _data into narr
		}
	narr[_data.length] = newVal; //Sets the last value as the new value
	_data = narr;  //Makes old _data equal to the changed narr
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal ) 
    {

	/* YOUR IMPLEMENTATION HERE */

	int[] narr = new int[_data.length  + 1]; //Creates a new array called narr with a _data size + 1
	for(int x =0; x < index + 1; x++){ //Loops till it reaches the index value
		if(x == index){
			narr[x] = newVal; //if the current index equals to the index we're looking for, set it to newVal
		}
		else{ // if it doesn't equal the index, just continue copying values from _data
			narr[x] = _data[x];
		}
	}
	for(int x = index; x < _data.length; x++){ //another for loop, that starts from index
		narr[x + 1] = _data[x]; //Copies the values and adds it to the right of the newVal added
	}
	_data = narr; //Makes old _data equal to the changed narr
    }

    

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	int[] narr = new int[_data.length - 1]; //Creates a new array with one less space
	for(int x = 0; x < _data.length -1; x++){ //Loops through data, to copy values, except the specified index
		if(x != index){ // if it's not the specified index, just keep copying values
			narr[x] = _data[x];
		}
    }
    _data = narr; //Makes old _data equal to the changed narr
}

    //return number of meaningful items in _data
    public int size() 
    {
	/* YOUR IMPLEMENTATION HERE */
	return _size; 
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++;
	}

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(curtis);

	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	/*===========================================
	  ===========================================*/
    }//end main()

}//end class SuperArray
