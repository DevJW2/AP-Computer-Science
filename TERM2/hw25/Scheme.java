//Jeffrey Weng
//APCS2 pd3
//HW25 -- What A Racket
//2017-03-27

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *
 * 1) Loop throughs stack until reaches closing paren
 2) When reached closing paren, go backwards, and evaluate inner operations
 3) repeat steps 1 and 2
 * 
 * STACK OF CHOICE: ALStack
 * b/c ...
 Both stacks does the same thing besides the implemenation, there was no preference.
 ******************************************************/

public class Scheme 
{

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns simplified value of expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
      public static String evaluate( String expr ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	String[] exprArr = expr.split("\\s+");
	String ret = "";
	Stack<String> exprStack = new ALStack<String>();
	Stack<String> values = new ALStack<String>();
	int operation = 0;

	for(String s: exprArr){
	    if(!s.equals(")")){
		exprStack.push(s);
	    }
	    else{
		String current = exprStack.pop();
		while(!current.equals("(")){
		    if(current.equals("+")){
			operation = 1;
		    }
		    else if(current.equals("-")){
			operation = 2;
		    }
		    else if(current.equals("*")){
			operation = 3;
		    }
		    else{
			values.push(current);
		    }
		    current = exprStack.pop();
		}
		exprStack.push(unload(operation, values));
	    }
	}
	ret = exprStack.peek();
	return ret;
    }


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren
     *           is seen thru peek().
     *           Returns result of applying operand to
     *           sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	if(op == 1){
	    int sum = 0;
	    while(!numbers.isEmpty()){
		sum += Integer.parseInt(numbers.pop());
	    }
	    return ("" + sum);
	}
	else if(op == 2){
	    int difference = Integer.parseInt(numbers.pop());
	    while(!numbers.isEmpty()){
		difference -= Integer.parseInt(numbers.pop());
	    }
	    return ("" + difference);
	    
	}
	else{
	    int product = 1;
	    while(!numbers.isEmpty()){
		product *= Integer.parseInt(numbers.pop());
	    }
	    return ("" + product);
	    
	}
    }


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) 
    {
	/*
	Stack<String> item = new ALStack();
	item.push("4");
	item.push("3");
	
	evaluate("( + 4 3 )");
	System.out.println(unload(3, item));
	*/
	
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//main

}//end class Scheme
