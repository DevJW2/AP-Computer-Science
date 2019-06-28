// Jeffrey Weng
// APCS1 pd5
// HW 21 -- For the Love of Strings
// 2016-10-24

public class Foresrever{
	//Creating fence posts based on the post number, using the for loop
	public static String fenceF(int posts){
		String fence = "|"; 
		for(int x = 1; x < posts; x++){
			fence += "--|";
		}
		return fence;
	}
	//Reversing the string, using the for loop
	public static String reverseF(String s){
		String newWord = "";
		for(int x = s.length(); x > 0; x--){
			newWord += s.charAt(x-1);
		}
		return newWord; 

	}
	//Reverse the string, using recursive, slowly making hello, smaller, while getting the first character and adding it 
	public static String reverseR(String s){
		if (s.length() != 0){
			return reverseR(s.substring(1)) + s.charAt(0);
		}
		else{
			return s;
		}
	}
	//Calling the static methods
	public static void main(String[] args){
		System.out.println(Foresrever.fenceF(3));
		System.out.println(Foresrever.reverseF("Hello"));
		System.out.println(Foresrever.reverseR("Hello"));
	}
}