//Jeffrey Weng 
//APCS1 pd 5
//Hw 14 -- stAtistically sPeaking
//2016-10-06

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
}

    
    
    public static void main(String[] args){
	   System.out.println(Stats.mean(4,5));
       System.out.println(Stats.mean(4.0,5.0));
       System.out.println(Stats.max(4,5));
       System.out.println(Stats.max(5,5));
       System.out.println(Stats.max(4.0,5.0));
       System.out.println(Stats.max(5.5,5.5));
       System.out.println(Stats.geoMean(4,5));
       System.out.println(Stats.geoMean(4.0,5.0));
}
}
