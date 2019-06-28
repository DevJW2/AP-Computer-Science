// Jeffrey Weng 
// APCS1 pd 5
// HW 17 -- Do I repeat myself? Very well, then I repeat myself 
// 2016-10-15


public class Repeater{
	static String postString = "|";
	static int postNum = 1;
	//Regular while loop
	public static String fenceW(int posts){
		int postNum = 1; 
		String postString = "|";
		if (posts == 1){
			return "|";
		}
		while (postNum < posts){
			postNum += 1;
			postString += "--|";
		}
		return postString;
	}
	//Recursion
	public static String fenceR(int posts){
		if (postNum < posts){
			postString += "--|";
			fenceR(posts -= 1);
		}
		return postString;

	}

	//Creates the instances for the two classes
	public static void main(String[] args){
		Repeater boy = new Repeater();
		System.out.println(boy.fenceW(5));
		System.out.println(boy.fenceR(5));
	}
}
