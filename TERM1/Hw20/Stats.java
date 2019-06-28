//Jeffrey Weng 
//APCS1 pd 5
//Hw 20 -- GCD Three Ways
//2016-10-19

//Worked with - Bayan

public class Stats {
    // Returns integer mean that is floored
    public static int mean(int a, int b){
	   return (a + b)/2;
}
    // Returns double mean that isn't floored
    public static double mean(double a, double b){
	   return (a + b)/2;
}
    // Returns the largest integer
    public static int max(int a, int b){
        if (a > b){
            return a;
        }
        else if(a < b){
            return b;
        }
        else{
            return a;
        }
    }
    // Returns the largest double
    public static double max(double a, double b){
        if (a > b){
            return a;
        }
        else if(a < b){
            return b;
        }
        else{
            return a;
        }
    }
    //Returns the integer geometric mean
    public static int geoMean(int a, int b){
        return (int) Math.sqrt(a * b);
    }
    //Returns the double geometric mean
    public static double geoMean(double a, double b){
        return Math.sqrt((a * b));
}   //Returns the max of three integers
    public static int max(int a, int b,int c){
        if (a > b){
            if(a > c){
                return a;
            }
            else {
                return c;
                }
            }
        else if(b > c){
            return b;
        }
        else{
            return c;
        }
    }
    //Returns the max of three doubles
    public static double max(double a, double b, double c){
        if (a > b){
            if(a > c){
                return a;
            }
            else {
                return c;
                }
            }
        else if(b > c){
            return b;
        }
        else{
            return c;
        }
    }
    // Returns the geometric mean of three int numbers, finding the cubic root of the product
    public static int geoMean(int a, int b, int c){
        return (int) Math.cbrt(a*b*c);
    }
    // Returns the geometric mean of the three double numbers, finding the cubic root of the product
    public static double geoMean(double a, double b, double c){
        return Math.cbrt(a*b*c);
    }
    //BRUTE FORCE METHOD
    public static int gcd(int a, int b) { 
        int x = 1; 
        int temp = 0;
        if (a > b){
            while (x <= b){
            if (b % x == 0 && a % x == 0){
                temp = x;
            }
            x += 1;
        }
    }
        else {
            while (x <= a){
                if (a % x == 0 && b % x == 0){
                    temp = x;
                }
                x += 1;
            }
        }
        return temp;   
    }

    /*
        Euclid Algorithm to find the GCD. Starting with the larger number, dividing the smaller number,
        and finding the remainder1. Then using the smaller number to divide the remainder1, getting remainder2.
        The remainder1 then divides remainder2.
        Continue this process, continue dividing the quotient / remainder
        until the remainder is zero, and use the quotient that was used to obtain a remainder of zero. 
        This Quotient is the GCD. 

    */
    //RECURSIVE EUCLID GCD METHOD
    public static int gcdER(int a, int b){
        if (a > b){
            if(a == 0){
                return b;
            }
            else if (b == 0){
                return a;
            }
            else{
                return gcdER(b,a % b);
            }

        }
        else{
            if(a == 0){
                return b;
            }
            else if (b == 0){
                return a;
            }
            else{
                return gcdER(a,b % a);
            }

        }
    }
    //ITERATIVE EUCLID GCD METHOD

    public static int gcdEW(int a, int b){
        if (b % a == 0) {
            return a;
        } 
        else if (a % b == 0) {
            return b;
        }
        while (a != 0 && b != 0) {
            if (a > b) {
                a -= b;
            } 
            else {
                b -= a;
            }
        }
        if (a == 0) {
            return b;
        }       

        return a;
    }

    public static void main(String[] args){
    System.out.println(gcd(15,20));
    System.out.println(gcd(20,15));
    System.out.println(gcdER(15,20));
    System.out.println(gcdER(20,15));
    System.out.println(gcdEW(15,20));
    System.out.println(gcdEW(20,15));
    }

}


