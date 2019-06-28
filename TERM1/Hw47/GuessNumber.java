//Jeffrey Weng 
//APCS1 pd 5
//HW 47 -- Keep Guessing
//2016-12-17

import cs1.Keyboard;
public class GuessNumber{
	public static void guess(){
		int randomNum = (int)(Math.random() * 100) + 1;
		boolean value = true;
		int guessCount = 0;
		int lowerBound = 1; 
		int upperBound = 100;
		//A while loop, to continue asking for the user to guess, until the got it right
		while(value){
			System.out.print("Guess a number from " + lowerBound + "-" + upperBound + ":");
			guessCount += 1;
			int input = Keyboard.readInt();
			//If and else if statements to test conditions, and set lowerBound and Upperbound
			if(input > randomNum){
				upperBound = input - 1;
				System.out.println("Too high, try again...");

			}
			else if(input < randomNum){
				lowerBound = input + 1;
				System.out.println("Too low, try again...");
			}
			else if(input == randomNum){
				value = false;
			}
		}
		System.out.println("Correct! It took " + guessCount + " guesses");

	}
	//Runs the guess method
	public static void main(String[] args){
		guess();

	}
}