// skeleton file for 
// class TwoDimArray
// ...practice working with 2D arrays

public class TwoDimArray {

    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
    for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }


    //postcond: prints each row of 2D integer array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
    for (int[] row: a){
            System.out.println(row);
        }
    }


    //postcond: returns sum of all items in 2D integer array a
    public static int sum1( int[][] a )
    { 
	/* YOUR IMPLEMENTATION HERE */
        int total = 0;
        for(int[] row: a){
            for(int num: row){
                total += num;
            } 
        }
        return total;
    }


    //postcond: returns sum of all items in 2D integer array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
    int total = 0;
    for(int i = 0; i < m.length; i++){
            total += sumRow(i, m);
        }
    return total;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
    int totalR = 0;
    for(int i = 0; i < a.length; i++){
            if(i == r){
                for(int n = 0; n < a[i].length; n++){
                    totalR += a[i][n];
                }
            }
        }
    return totalR;
    }


    //postcond: returns sum of all items on row r of 2D integer array 
    //          uses a FOREACH loop
    public static int sumRow2( int r, int[][] m ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
    int totalR = 0;
    int counter = 0;
    for(int[] row: m){
        counter += 1;
        if (counter == r){
            for(int num: row){
                totalR += num;
            }    
        }
    }
    return totalR;
    }


    //postcond: returns sum of all items in column c of 2D integer array 
    public static int sumCol( int c, int[][] m ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
    int totalC = 0;
    for(int i = 0; i < m.length; i++){
        totalC += m[i][c];
        }
    return totalC; 
        
    }


    public static void main( String [] args ) 
    {
	
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	print1(m1);
	print1(m2);
	print1(m3);
	print2(m1);
	print2(m2);
	print2(m3);
	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1));
	System.out.println("sum m2 : " + sum1(m2));
	System.out.println("sum m3 : " + sum1(m3));
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));
    System.out.print("testing sumCol...\n");
    System.out.println("sumCol m1 : " + sumCol(0, m1));
    System.out.println("sumCol m2 : " + sumCol(0, m2));
    System.out.println("sumCol m3 : " + sumCol(0, m3));
    
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }

}//end class TwoDimArray
