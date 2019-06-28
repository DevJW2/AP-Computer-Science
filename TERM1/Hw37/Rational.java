//Jeffrey Weng
//APCS1 pd5
//HW 37 -- Be More Rational
//2016-11-30

public class Rational{
    //Made private variables numerator and denominator
    private int numerator; 
    private int denominator;
   
    //Default constructor, initiates numerator and denominator
    public Rational(){
	numerator = 0;
	denominator = 1;
    }
    //Constructor with parameters numer and denomi
    public Rational(int numer,int denomi){
	//tests if inserted denominator is not zero
	if (denomi == 0){
	    System.out.println("Do not insert a zero as your denominator");
	    numerator = 0; 
	    denominator = 1;
	}
	//set numerator and denominator to numer and denomi respectively
	else {
	    numerator = numer;
	    denominator = denomi;
	}
    }
    //Returns a string p/q
    public String toString(){
	return numerator + "/" + denominator; 
    }
    //returns a float of numerator / denominator, by typecasting the result
    public float floatValue(){
	return (float)(numerator/denominator);
    }
    //multiples this classes numerator and denominator with the rational number in the parameter
    public void multiply(Rational number){
	this.numerator = number.numerator * this.numerator; 
	this.denominator = number.denominator * this.denominator; 
    }
    //divides this classes numerator and denominator with the rational number in the parameter, by multiplying the numerator by the denominator, and the denominator by the numerator
    public void divide(Rational number){
	this.numerator = this.numerator * number.denominator; 
	this.denominator = this.denominator * number.numerator; 
    }
    //gets common denominator by multiplying, then adds the two fractions numerator
    public void add(Rational number){
	if(this.denominator != number.denominator){
	    int denom1 = this.denominator;
	    int denom2 = number.denominator;
	    this.numerator *= denom2;
	    this.denominator *= denom2; 
	    number.numerator *= denom1; 
	    number.denominator *= denom1;
	    this.numerator += number.numerator;
	}
    //has common denominator already, adds numerators
	else{
	    this.numerator += number.numerator;
	}
    }
    //gets common denominator by multiplying, then subtracts the two fractions numerator
    public void subtract(Rational number){
	if(this.denominator != number.denominator){
	    int denom1 = this.denominator;
	    int denom2 = number.denominator;
	    this.numerator *= denom2;
	    this.denominator *= denom2; 
	    number.numerator *= denom1; 
	    number.denominator *= denom1;
	    this.numerator -= number.numerator;
	}
    //has common denominator already, subtracts number
	else{
	    this.numerator -= number.numerator;
	}
    }
    //finds GCD, recursively
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
    //gets gcd value
    public int gcd(){
	return gcdER(numerator, denominator);
    }
    //a static gcd method
    public static int gcdS(Rational number){
    	return gcdER(number.numerator,number.denominator);
    }
    //compares the values of the two rational numbers, testing if its greater, equal, or less
    public int compareTo(Rational number){
    	if ((this.numerator * 1.0 / this.denominator) > (number.numerator * 1.0 / number.denominator)){
    		return 1;
    	}
    	else if((this.numerator * 1.0 / this.denominator) < (number.numerator * 1.0 / number.denominator)){
    		return -1;
    	}
    	else {
    		return 0;
    	}


    }
    // recudes the values, by dividing the GCD from the numerator and denominator
    public void reduce(){
	int GCD = gcd();
	numerator /= GCD;
	denominator /= GCD;
    }
    //Testing
    public static void main(String[] args){
	Rational r = new Rational(2,3);
	Rational s = new Rational(1,2); 
	Rational t = new Rational(1,0); // testing zero denominator
	Rational a = new Rational(4,5); // used mainly for adding and subtracting
	Rational b = new Rational(2,3); // used mainly for adding and subtracting
    Rational c = new Rational(4,5); //used mainly for compareTo method
	r.multiply(s);
	System.out.println(r.toString()); // 2/6
	r.divide(s);
	System.out.println(r.toString());// 4/6
	System.out.println(t.toString());// 0/1, prints a message
	a.add(b); //adds fraction
	System.out.println(a.toString()); // 22/15
	a.subtract(b); // subtracts fraction
	System.out.println(a.toString()); // 12/15
	System.out.println(a.gcd()); //prints out gcd: of 3
	a.reduce(); // reduces fraction
	System.out.println(a.toString()); // 12/15 --> 4/5
    System.out.println(a.compareTo(c)); // 4/5 == 4/5, returns zero


    } 
   	


}
