//Jeffrey Weng 
//APCS1 pd 5
//Hw 15 -- May ah Hahv S'maur, Please?
//2016-10-07

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

}
