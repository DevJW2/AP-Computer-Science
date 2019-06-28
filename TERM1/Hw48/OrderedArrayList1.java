//Jeffrey Weng
//APCS1 pd 5
//HW48 -- Halving the Halves
//2016-12-19

//Unfinished, will work on tomorrow, sorry :( 

/*============================================
   class OrderedArrayList
   Wrapper class for ArrayList.
   Imposes the restriction that stored items 
   must remain sorted in ascending order
   ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList1 
{
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() 
    {
	_data = new ArrayList<Comparable>();
    }


    public String toString() 
    { 
	return _data.toString(); 
    }


    public Comparable remove( int index ) 
    { 
	return _data.remove(index); 
    }


    public int size() 
    { 
	return _data.size();
    }

    
    public Comparable get( int index ) 
    { 
	return _data.get(index); 
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    
    //addLinear is the order of n
    public void addLinear( Comparable newVal ) 
    { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
		//newVal < oal[p]
		_data.add( p, newVal );
		return; //Q:why not break?
	    }
	}
	_data.add( newVal ); //newVal > every item in oal, so add to end
    }
    //addBinar is the order of log base 2 of n 
    public void addBinary(Comparable newVal){
        int upperBound = _data.size() - 1;
        int lowerBound = 0;
        boolean value = true;
        int midPoint = (upperBound + lowerBound)/2;
        while(value){
            midPoint = (upperBound + lowerBound)/2;
            if(lowerBound + 1 == upperBound){
                _data.add(midPoint,newVal);
                value = false;
            }
            else{
            if ((int)(newVal) > (int)(_data.get(midPoint))){
                lowerBound = midPoint + 1;
            }
            else if((int)(newVal) < (int)(_data.get(midPoint))){
                upperBound = midPoint - 1;
            }
            else if((int)newVal == (int)(_data.get(midPoint))){
                _data.add(midPoint + 1,newVal);
                value = false;
            }
        }

        }              
    }




    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
    
	for( int i = 0; i < 15; i++ )
	    Franz.addLinear( (int)( 50 * Math.random() ) );
	System.out.println( Franz );
    
    Franz.addBinary(7);
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class OrderedArrayList
