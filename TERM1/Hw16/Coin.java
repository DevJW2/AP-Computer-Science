//Jeffrey Weng
//APCS1 pd5
//hw16 -- Wayne's World
//2016-10-12

public class Coin {
	double value;
	double bias = 0.5; //preset bias here
	String upFace = "head"; //preset face of the coin here
	String name;
	int flipCtr;
	int headsCtr;
	int tailsCtr;

	//default constructor, initializes variables
	public Coin(){
		flipCtr = 0;
		headsCtr = 0;
		tailsCtr = 0;
	}
	//overloaded constructor, sets name equal to denomination
	public Coin(String denomination){
		this();
		name = denomination; 
		
	}
	//another overloaded constructor, that has two parameters, with the currentface
	public Coin(String denomination,String currentFace){
		this();
		name = denomination; 
		upFace = currentFace; 

		
	}
	//flip method, that flips the coin, to either head or tails based on bias(1:always heads, 0: always tails)
	public String flip(){
		if (((int) Math.floor(Math.random() * 10)) < (bias * 10)) //makes bias into a digit 0-10
		{
			upFace = "head";
			headsCtr += 1;
			flipCtr += 1;
			return upFace;
		}
		else {
			upFace = "tails";
			tailsCtr += 1;
			flipCtr += 1;
			return upFace;
		}
	}
	//Overwritten toString method, to return name + upFace when printing out the instance
	public String toString(){
		return name + " -- " + upFace;
	}
	//Overwritten equals method, compared the classes face with the current face, and returns true or false
	public boolean equals(Coin obj){
		if (obj.upFace == upFace){ 
			return true;
		}
		return false;

	}
	//assigns values to whatever name the object is
	public void assignValue(){
		if (name == "quarter"){
			value = 0.25;
		}
		else if(name == "nickel"){
			value = 0.05;
		}
		else if(name == "dime"){
			value = 0.10;
		}
		else if(name == "dollar"){
			value = 1.00;
		}
		else if(name == "penny"){
			value = 0.01;
		}
		else{
			value = 0.0;
		}
	}
}