//Jeffrey Weng
//APCS2 pd3
//HW08 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2017-02-21

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard 
{
    int queenCounter = 0;
    //2D array to represent n*n chessboard
    private int[][] _board;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     1) place queen at a position in the first column
     2) place a queen at an available position in the column after that
     3) Continue until queens are all placed 
     4) If you reach a point where the queens is not equal to the board length
     and did not reach the last column then go to the column before it 
     5) Continue searching from the position after the last queen placement 
     and delete the previous queen
     6) Find a new position for a new queen, if found start back at step 1
     7) Else start from 4
     */

    
    public boolean solve()
    {
	//Calls the solveH method, starting at the zeroth column
	return solveH(0);
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	//stores temp coordinates for each Queen that's placed
	int x = 0;
	int y = 0;
	for(int i = 0; i < _board.length; i++){
	    /* --------DEBUGGING---------------------
	    System.out.println("COLUMN1: " + col);
	    System.out.println("Start Loop");
	    System.out.println("index: " + i);
	    System.out.println("queens: " + queenCounter);
	    -----------------------------------------*/

	    
	    if(queenCounter != _board.length && col < _board.length){
		//System.out.println("Initiate first if");
		//Goes through each column, testing if it's possible to add a queen or not
		if(addQueen(i,col)){
		    queenCounter++;
		    x = i;
		    y = col;
		    //Solves next column
		    solveH(col + 1);
		    //System.out.println("COLUMN2: " + col);

		    //after all columns are solved, and the recursive calls back track, remove the previous queen placed
		    //if queenCounter is not yet the board size and is not at the last col
		    if (queenCounter != _board.length && col < _board.length){
			removeQueen(x,y);
			queenCounter--;
		    }    
		    
		}
		
		//System.out.println("Out of if statement");
	    }
	    else{
		return true;
	    }
	}
	
	return false;
    }


    //print a valid placement of n queens
    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
	String board= "";
	//if a solution is possible print out a board, with one's as queens and anything else that is negative or zero as "-"
	if(solve()){
	    for( int r = 0; r < _board.length; r++ ) {
		for( int c = 0; c < _board[0].length; c++ ) {
		    if(_board[r][c] <= 0){
			board += "-" +  "|";
		    }
		    else{
			board += "Q"  +"|";
       
		    }
		
		}
		board += "\n";
	    }
	}
	//else print out a board filled with zeroes
	else{
	    for( int r = 0; r < _board.length; r++ ) {
		for( int c = 0; c < _board[0].length; c++ ) {
		    board += "0" + "\t";
		}
		board += "\n";

	    }
	    board += "No Solution\n";
	}
	System.out.println(board);
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * <General description>
     * precondition: requires an actual board position: with integer row and column number
     * postcondition: if board position is occupied or can't be placed, then will return false
     if not, then the board will update and the queen will be placed, with inaccessible board positions updated as well
     */
    private boolean addQueen(int row, int col)
    {
	// Won't add a queen if the designated position is not zero
	if(_board[row][col] != 0){
	    return false;
	}

	// if the condition above is not run, then the position is set to 1 
	_board[row][col] = 1;

	// set the offset to 1, which is how many spaces from the original position
	int offset = 1;

	// sets all the positions to the right, diagonally up, diagonally down to values that is one less, showing that these places are not accessible
	while(col+offset < _board[row].length) {
	    //Values will become negative or even more negative because the original number is either a zero or a negative number
	    
	    // sets all the positions to the right of the original position to be one less 
	    _board[row][col+offset]--;
	    
	    // sets all positions that is one up and one right, in a diagonal shape to one less 
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
		//_board[row-offset][col]--;
	    }
	    // sets all positions that is one down and one right, in a diagonal shape to one less
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
		//_board[row+offset][col]--;
	    }
	    
	    // increase offset, to increase the spaces from the original position, which will further along the setting of inaccessible board placements
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: requires an actual board position: with integer row and column number
     * postcondition: if there is no queen, then it will return false
     if there is a queen, then the value will be set to zero and the inaccessible positions will be updated
     */
    private boolean removeQueen(int row, int col)
    {
	// checks if the position specified has a queen or not
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// after the above condition is false, then it removes the queen and sets the value back to zero
	int offset = 1;	        // sets the offset to 1, which is how many spaces from the original specified position 

	// sets all the positions to the right, diagonally up, diagonally down to values that is one more, showing that these places are now accessible or that these places
	// will not be specifically blocked by this queen anymore
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
		//_board[row-offset][col]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
		//_board[row+offset][col]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: requires a board of n*n size
     * postcondition: returns a string called ans that contains a 2D representation of the board
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c] + "\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(20);
        System.out.println(b);
	b.printSolution();
        System.out.println(b);
    }//end main()
    
}//end class
