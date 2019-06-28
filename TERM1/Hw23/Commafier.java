//Jeffrey Weng and Ryan Siu -- Team J-S
//APCS1 pd 5
//HW 23 -- Karmacomma
//2016-10-26

public class Commafier {
	//Recursive, Uses Ryan's way of breaking down into ones, tens, and hundreds
	public static String commafyR(int num){
		if (num < 1000){
			return num + "";
		}
		else{
			int ones = num % 10;
			int tens = (num /= 10) % 10;
			int hundreds = (num/=10) % 10;
			return commafyR(num/10) + "," + hundreds + tens + ones;
		}

	}
	//Uses iterative, creates a separate counter that loops through the string, and the general for loop
	public static String commafyF(int num){
		String newNum = num + "";
		String retStr = "";
		int counter = 0;
		if (num < 1000){
			return retStr += newNum;
		}
		else{
			for(int x = newNum.length(); x > 0; x--){
				counter += 1;
				if (x % 3 == 0){
					retStr += ",";
					retStr += newNum.substring(counter-1,counter);
				}
				else{
					retStr += newNum.substring(counter-1,counter);
				}
			} 
		}
		return retStr;
	}

	public static void main(String[] args){
		for (String s: args){
			//Makes the string s into a integer 
			int num = Integer.parseInt(s);
			System.out.println(commafyR(num));

		}
		/*
	System.out.println(commafyR(1));  // 1
	System.out.println(commafyR(10));  // 10
	System.out.println(commafyR(101));  // 101
	System.out.println(commafyR(1000));  // 1,000
	System.out.println(commafyR(12345));  // 12,345

	System.out.println(commafyF(1));  // 1
	System.out.println(commafyF(10));  // 10
	System.out.println(commafyF(101));  // 101
	System.out.println(commafyF(1000));  // 1,000
	System.out.println(commafyF(1234567879));  // 1,234,567,879
	*/
	}

//Failed code...
	/*
		if (num < 1000){
			return num + "";
		}
		else{
			if(num % 1000 != 0){
				return commafyR(num/1000) + "," + commafyR();
			}
			else{
				return commafyR(num/1000) + "," + commafyR(num % 1000)+ commafyR(num % 1000)+ commafyR(num % 1000);
			}
		}
	*/

}