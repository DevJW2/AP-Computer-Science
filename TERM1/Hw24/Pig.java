// Jeffrey Weng
// APCS1 pd 5
// Hw24 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay 
// 2016-10-29

//class Pig
//a Pig Latin translator
//SKELETON

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           9
     ,--.-'-,--.
     \  /-~-\  /
    / )' a a `( \
   ( (  ,---.  ) )
    \ `(_o_o_)' /
     \   `-'   /
      | |---| |     
      [_]   [_]
      PROTIP: Make this class compilable first, 
      then develop and test one method at a time.
      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class Pig 
{
    //Q: How does this initialization make your life easier?
    private static final String VOWELS = "aeiou";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") → true  
      hasA("cat", "p") → false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	if (w != null && letter.length()== 1){ 
	    for(int x = 0; x < w.length(); x++){
		    if (w.substring(x,x+1).equals(letter)){ //tests if the letter is in w
		      return true;
		    }
	    }
	}
	return false;
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	if (letter.length() == 1){
	    for(int x = 0; x <  VOWELS.length(); x++){
        if (VOWELS.substring(x,x+1).equals(letter)){ //tests if the letter is in vowels
          return true;
        }
      }
	}
  return false;
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") → 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
    int count = 0;
    if(w != null){
      for(int x = 0; x < w.length(); x++){
        if(VOWELS.indexOf(w.substring(x,x+1)) >= 0){ // if the character in w is in vowels
          count +=1;
        }
      }
    }
    return count;
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") → true
      hasAVowel("zzz") → false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
    if(w != null){
      for(int x = 0; x < w.length(); x++){
        if(VOWELS.indexOf(w.substring(x,x+1)) >= 0){
          return true;
        }
      }
    }
    return false;

    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") → "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
    String retValue = "";
    if(w != null){
      for(int x = 0; x < w.length(); x++){
        if(VOWELS.indexOf(w.substring(x,x+1)) >= 0){
          retValue += w.substring(x,x+1);
        }
      }
    }
    return retValue;
    }


    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
    if(w != null){
      for(int x = 0; x < w.length(); x++){
        if(VOWELS.indexOf(w.substring(x,x+1)) >= 0)
          return w.substring(x,x+1);
      }
    }
    return "";
    }


    /*=====================================
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
    public static boolean beginsWithVowel( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
    if (w != null && w.length() > 0){
      if(VOWELS.indexOf(w.substring(0,1)) >= 0){
        return true;
      } 
    }
    return false;
    }


    /*=====================================
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      =====================================*/
    public static String engToPig( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
    String retString = "";
    if(w.length() > 0){
      if(beginsWithVowel(w)){
        return retString += w + "way"; //if it begins with a vowel, just add the string + 'way'
      }
      else{
        if(hasAVowel(w)){
          // if the string doesnt begin with a vowel but has a vowel, makes the first few consonants before the vowel
          // go to the end with the addition of "ay"
          return retString += w.substring(w.indexOf(firstVowel(w))) + w.substring(0,w.indexOf(firstVowel(w))) + "ay";
        }
        else{
          // if it doesnt have a vowel, just add "ay"
          return retString += w + "ay";
        }
      }

    }
    return retString;
    }


    public static void main( String[] args ) {

	/* YOUR TEST CALLS HERE */
  /*
        System.out.println(hasA("cat", "p")); //→ false
        System.out.println(hasA("cat", "a")); //-> true
        System.out.println(isAVowel("a")); // -> true
        System.out.println(isAVowel("b")); // -> false
        System.out.println(countVowels("meatball"));//→ 3
        System.out.println(hasAVowel("cat")); //→ true
        System.out.println(hasAVowel("zzz"));//→ false
        System.out.println(allVowels("meatball")); //→ "eaa"
        System.out.println(firstVowel("")); //--> ""
        System.out.println(firstVowel("zzz")); //--> ""
        System.out.println(firstVowel("meatball")); //--> "e"
        System.out.println(beginsWithVowel("apple"));  //--> true
        System.out.println(beginsWithVowel("strong")); //--> false
        System.out.println(engToPig("apple"));  //--> "appleway"
        System.out.println(engToPig("strong")); //--> "ongstray"
        System.out.println(engToPig("java"));   //--> "avajay"
	      System.out.println(engToPig("meatball")); 
    */ 
        for (String thing : args){
          System.out.println( allVowels(thing) );
          System.out.println( firstVowel(thing) );
          System.out.println( countVowels(thing) );
          System.out.println( engToPig(thing) );
        }
    }//end main()

}//end class Pig
