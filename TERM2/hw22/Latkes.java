//Jeffrey Weng
//APCS2 - pd3
//Hw22 -- Stacks on Stacks on Stacks on Stacks...
//2017-03-22

/***
 * class Latkes
 * SKELETON
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
	/* YOUR IMPLEMENTATION HERE */
	_stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	for(int i = 0; i < _stack.length; i++){
	    if(_stack[i] == null){
		_stack[i] = s;
		_stackSize += 1;
		return;
	    }
	    
	}
	
    }

    //means of removal
    public String pop( ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
	String ret = _stack[_stack.length - 1];
	_stack[_stack.length - 1] = null;
	_stackSize -= 1;
	return ret;
	
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
	/* YOUR IMPLEMENTATION HERE */
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull() 
    {
	/* YOUR IMPLEMENTATION HERE */
	return _stackSize ==  _stack.length;
    }

    public void getStack(){
	String ret = "";
	for(int i = 0; i < _stack.length; i++){
	    ret += _stack[i] + ", ";
	}
	System.out.println(ret);
    }


    public static void main(String[] args){
	Latkes item = new Latkes(10);
	System.out.println("PRINTING OUT LIST");
	item.getStack();
	System.out.println("");
	System.out.print("IS IT EMPTY(should be true): ");
	System.out.println(item.isEmpty());
	
	for(int i = 0; i < 10; i++){
	    item.push("thing");
	}
	System.out.println("");
	System.out.println("PRINTING OUT LIST");
	item.getStack();
	System.out.println("");
	System.out.print("IS IT FULL(should be true): ");
	System.out.println(item.isFull());
	System.out.println("");
	System.out.println("Remove last element and return it.........");
	System.out.println(item.pop());
	System.out.println("");
	System.out.println("PRINTING OUT LIST");
	item.getStack();
	System.out.println("");
	System.out.print("is it empty: ");
	System.out.println(item.isEmpty());
	System.out.print("is it full: ");
	System.out.println(item.isFull());
    }
}//end class Latkes

