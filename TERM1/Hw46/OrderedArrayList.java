//Jeffrey Weng 
//APCS1 pd5
//HW 46 -- Ascending
//2016-12-14

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
        _data = new ArrayList<Comparable>();
    }

    //Uses the already built toString in SuperArray
    public String toString() { 
        String foo = "[";
        for(int i = 0; i < _data.size(); i++){
            foo += _data.get(i) + ",";
        }
        if(foo.length() > 1){
            foo = foo.substring(0, foo.length() - 1);
        }
        foo += "]";
        return foo; 
    }


    public Comparable remove( int index ) { 
        for(int i = index; i < _data.size() - 1; i++){
            _data.set(i,_data.get(i+1));
        }
        return _data.get(index);
    }

    public int size() { 
        return _data.size(); 
    }

    
    public Comparable get( int index ) { 
        return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) {
        int lastLargestIndex = -1; //created a variable for the lastLargestIndex 
        if(_data.size() == 0){
            _data.add(newVal); //if the data set is empty, add the newVal
        }
        else{ 
            for(int i = 0; i < _data.size(); i++){
                /*
                test if the newVal is greater than the values inside of data
                then set the lastLargestIndex to the last index of the value that was
                smaller than the newVal.
                */
                if((int)(newVal) > (int)(_data.get(i))){ 
                    lastLargestIndex = i;
                    }
                }
                //if the newVal was smaller than all the values in data, add the newVal at the beginning
                if(lastLargestIndex == -1){
                    _data.add(0, newVal);
                }
                //else, add the newVal right after the last index of the value that was smaller
                else{
                _data.add(lastLargestIndex + 1, newVal);
            }
            }
        }

    // main method solely for testing purposes
    public static void main( String[] args ) {
	

	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");
    // testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addLinear( valToAdd );
	}

	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println();
/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
 
