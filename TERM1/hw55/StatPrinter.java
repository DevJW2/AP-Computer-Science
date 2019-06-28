//Jeffrey Weng
//APCS1 pd5
//HW55 -- His Toe Grammar
//2017-01-04

/***
    An AP-style question, for practice...

    Write the StatPrinter class below. The StatPrinter Object receives an
    ArrayList of nonnegative integers, then builds a frequency ArrayList where
    the index values are the data and the entry at the index is the frequency.
    For example, if the received data is : 2,3,2,5,1,3 then the frequency 
    list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
    2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
    the maximum value of the data.

    A capability of the class is to calculate local modes from the frequency 
    list. A local mode is a value that is greater than the value at index - 1 
    and greater than the value at index + 1. A local mode is never at the end
    points of the list. For example if the frequency list is [1,2,1,4,2,3,5] 
    then the local modes are: 2 and 4.



    This class is also capable of printing a histogram of the frequencies, using
    ‘*’ to indicate a frequency amount. To print a histogram, the user specifies
    the longest sequence of ‘*’s used and then all other values are printed in 
    proportion to this value. For example, if longest bar is 10 and the frequency
    list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

    0 : **
    1 : ****
    2 : **
    3 : ********
    4 : ****
    5 : ******
    6 : **********

    For each method, state the run time efficiencies using Big O notation.
    =======================================
    Tip:
    * Develop 1 fxn at a time, test it, then move to next.
    * Look over all, think a bit, decide which to tackle first.
    ( Simplest?  Prerequisite? . . . )
    * Coding today, what extra code do you need to get past Mr. Compiler?
    ***/

import java.util.ArrayList;

public class StatPrinter 
{

    // instance variable for frequencies of each integer in input ArrayList
    private static ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]

    //This constructor, is going at an order of f(n^2)
    public StatPrinter( ArrayList <Integer> data ) 
    { 
	/* Your implementation hnyah */
	_frequency = new ArrayList<Integer>();
	int copyCount = 0;
	int frequency = 0;
	for(int i = 0; i < max(data) + 1; i++){
	    for(int n = 0; n < data.size(); n++){
		if(data.get(n) == copyCount){
		    frequency += 1; 
		}
	    }
	    _frequency.add(frequency);
	    frequency = 0;
	    copyCount += 1;
	}
	
    }


    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    
    //This method is running at an order of f(n)
    public Integer max( ArrayList <Integer> data ) 
    { 
	/* Your implementation hnyah */
	int maxNum = 0;
	for(int i = 0; i < data.size(); i++){
	    if (data.get(i) > maxNum){
		maxNum = data.get(i);
	    }
	}
	return maxNum;
    }


    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true

    //This method is running at an order of f(1)
    public boolean isLocalMode( int i ) 
    { 
	/* Your implementation hnyah */
	if((i > 0) && (i < _frequency.size() - 1) && (_frequency.get(i - 1)) < (_frequency.get(i)) && (_frequency.get(i + 1) < _frequency.get(i))){
	    return true;
	}
	else{
	    return false;
	}
	
    }


    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency

    //This method goes at an order of f(n)
    public ArrayList <Integer> getLocalModes() 
    {
	/* Your implementation hnyah */
	ArrayList<Integer> localModes = new ArrayList<Integer>();
	for(int i = 1; i < _frequency.size() - 1; i++ ){
	    if((_frequency.get(i) > _frequency.get(i - 1)) && (_frequency.get(i) > _frequency.get(i + 1))){
		localModes.add(_frequency.get(i));
	    }
	}
	return localModes;
    }//O(?)


    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0

    //this method goes at an order of f(n^2)
    public void printHistogram( int longestBar ) 
    { 
	/* Your implementation hnyah */
	String retString = "";
	for(int i = 0; i < _frequency.size(); i++){
	    retString += i + ": ";
	    for(int n = 0; n < _frequency.get(i) * longestBar/max(_frequency); n++){
		retString += "*";
	    }
	    retString += "\n";
	}
	System.out.println(retString);
       
    }//O(?)

     //This method goes at an order of f(n^3)
      public static void main(String[] args){
	      //eg, for _frequency [1,2,1,4,2,3,5]
      ArrayList<Integer> item = new ArrayList<Integer>();
      item.add(0);
      item.add(1);
      item.add(1);
      item.add(2);
      item.add(3);
      item.add(3);
      item.add(3);
      item.add(3);
      item.add(4);
      item.add(4);
      item.add(5);
      item.add(5);
      item.add(5);
      item.add(6);
      item.add(6);
      item.add(6);
      item.add(6);
      item.add(6);
      StatPrinter boy = new StatPrinter(item);
      System.out.println(_frequency);
      boy.printHistogram(10);
      System.out.println(boy.isLocalMode(2));
      System.out.println(boy.isLocalMode(4));
      System.out.println(boy.isLocalMode(5));
      System.out.println(boy.isLocalMode(0));
      System.out.println(boy.isLocalMode(1));
      System.out.println(boy.isLocalMode(3));
      System.out.println(boy.getLocalModes());
    }
    
 
}//end class StatPrinter
