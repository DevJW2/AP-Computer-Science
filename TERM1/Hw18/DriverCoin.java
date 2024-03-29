// Jeffrey Weng 
// APCS1 pd 5
// HW 18 -- Loopy
// 2016-10-17
// Base Code provided by Mr.Brown

/*=============================
  driver for class Coin -- v1
  by Clyde "Thluffy" Sinclair

  ~~~ SUGGESTED WORKFLOW: ~~~
  1. Compile this file and run.
  2. Cut&paste the "TOP" line below the first statement. 
     (with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
  3. Compile and run again. 
  4. Resolve errors 1 at a time until it works
  5. Repeat 2-4 until TOP meets BOTTOM

  NOTE: Repeated execution should yield different results.
  =============================*/

public class DriverCoin {

    public static void main( String[] args ) {

	//build Objects from blueprint specified by class Coin

	//test default constructor
	Coin mine = new Coin();

	//test 1st overloaded constructor
	Coin yours = new Coin( "quarter" );

	//test 2nd overloaded constructor
	Coin wayne = new Coin( "dollar", "heads" );

	//test toString() methods of each Coin
	System.out.println("mine: " + mine);
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);

	//test flip() method
	System.out.println("\nAfter flipping...");
	yours.flip();
	wayne.flip();
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);

	//test equals() method
	if ( yours.equals(wayne) ) 
	    System.out.println( "Matchee matchee!" );
	else
	    System.out.println( "No match. Firestarter you can not be." );

	//hw18

	Coin test = new Coin();
	int x = 24;
	boolean value = true;
	while (test.getFlipCtr() < x){
		test.flip();
		if (test.getHeadsCtr() < x){
			System.out.print("headsCtr: ");
			System.out.println(test.getHeadsCtr());
			System.out.print("flips: ");
			System.out.println(test.getFlipCtr());
		}
		if (test.getFlipCtr() < 13 || (2000 % test.getFlipCtr()) == 0){
			System.out.println("not all conditions satisfied");
		}
		else{
			System.out.println("Conditions satisfied");
		}

	}

    }//end main

}//end class