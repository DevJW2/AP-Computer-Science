//Jeffrey Weng
//APCS2 - pd3
//Hw23 -- Stack: What Is It Good For? 
//2017-03-23

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 * SKELETON
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
	String retStr = "";
        Latkes item = new Latkes(s.length());
	//Creates the stack, pushes all the string characters into new stack
	for(int i = 0; i < s.length(); i++){
	    item.push(s.substring(i,i+1));
	}
	//if the stack isn't empty, we'll make retStr equal to the last value, until all values are removed
	while(!item.isEmpty()){
	    retStr += item.pop();
	}
	return retStr;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    {


	
	//Characters, the matching pairs
 	String characters = "{}()[]";
	//Counter to test how many times we need to run a program
	int counter = 0;
	//Created two stacks, one to keep all the characters that weren't matched, and one that has been iterated through
	Latkes item = new Latkes(s.length());
	Latkes item2 = new Latkes(s.length());
	for(int i = 0; i < s.length(); i ++){
	    item.push(s.substring(i,i+1));
	}
	while(!item.isEmpty() || !item2.isEmpty()){
	    System.out.println("item: " +  item.getStack());
	    System.out.println("item2: " + item2.getStack());

	    //Automatically stop while loop if goes over a certain counter, not that efficient....
	    //Supposed to exit while loop when you realize that the matching pairs are not going to be popped.
	    //The characters will stay in the item forever,  which will run forever unless stopped.
	    //Can't figure out a way to determine that these characters will never be matched.
	    if(counter > s.length()){
	    	return false;
	    }

	    //if item stack is empty, set item stack to item2 stack
	    else if(item.isEmpty()){
		System.out.println("yes empty");
		int value = item2.getStack();
		for(int n = 0; n < value; n++){
		    item.push(item2.pop());
		}
		counter += 1;
	    }
	    //tests if it's matching pairs, and gets rid of them + used xray vision for peekAfter :) 
	    else if(Math.abs(characters.indexOf(item.peek()) -  characters.indexOf(item.peekAfter())) == 1 && (characters.indexOf(item.peek()) % 2 == 1)){
		item.pop();
		item.pop();
		System.out.println("i popped two times");        
	    }
	    //continues to get rid of them but pushes to item2, to re-iterate through when item is empty
	    else{	
		item2.push(item.pop());
		System.out.println("i popped once");
	    }	    
	}
	return true;
	
	

       


	
														
    }//end allMatched()


    //main method to test
    public static void main( String[] args ) { 

	System.out.println(flip("stressed"));

        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
		/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
