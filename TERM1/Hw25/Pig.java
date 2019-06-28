// Jeffrey Weng,Federico Tondolo,Zilin Wang
// APCS1 pd 5
// Hw25 -- ? ? ? 
// 2016-11-01

// Team Name - FTW

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
          import java.util.Scanner;
          public class Pig 
          {
        //Q: How does this initialization make your life easier?
            private static final String VOWELS = "aeiouAEIOU";
            private static final String YVOWELS = "aeiouAEIOUYy";
            private static final String PUNCS = ".,:;!?";

        /*=====================================
          boolean hasA(String,String) -- checks for a letter in a String
          pre:  w != null, letter.length() == 1
          post: hasA("cat", "a") → true  
          hasA("cat", "p") → false
          =====================================*/
          public static boolean hasA( String w, String letter ) 
          {
           /* YOUR IMPLEMENTATION HERE */
           return w.indexOf(letter) != -1;
        }//end hasA()


        /*=====================================
          boolean isAVowel(String) -- tells whether a letter is a vowel
          precondition: letter.length() == 1
          =====================================*/
          public static boolean isAVowel( String letter ) 
          {
           /* YOUR IMPLEMENTATION HERE */
           return VOWELS.indexOf( letter ) != -1;
         }


        /*=====================================
          int countVowels(String) -- counts vowels in a String
          pre:  w != null
          post: countVowels("meatball") → 3
          =====================================*/
          public static int countVowels( String w ) 
          {
           /* YOUR IMPLEMENTATION HERE */
           return allVowels(w).length();
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
              if(YVOWELS.indexOf(w.substring(x,x+1)) >= 0){
                return true;
              }
            }
          }
          return false;

        }



    /*=====================================
      boolean hasPunc(String) -- tells whether a String contains punctuation
      pre:  w != null
      post: hasPunc(“cat.”) -> true
            hasPunc(“cat”) -> false
            =====================================*/
            public static boolean hasPunc( String w ) {


              boolean retBoo = false; //init return var


              //iterate through word, checking if each letter is punctuation
              for( int i = 0; i < w.length(); i++ ) {
                if ( PUNCS.indexOf( w.substring(i,i+1) ) != -1 ) {
                retBoo = true;
                break;
              }
              }
              return retBoo;
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
      boolean isPunc(String) -- tells whether a character is punctuation
      pre:  symbol.length() == 1
      post: isPunc(".") -> true
            isPunc("b") -> false
      =====================================*/
    public static boolean isPunc( String symbol ) {
 return PUNCS.indexOf( symbol ) != -1;
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
           return isAVowel( w.substring(0,1) );
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

            String beginPunc = "";
            String endPunc = "";

            boolean needsPunWork = hasPunc(w);

            String retString = "";
            boolean cap = false;

            if ( needsPunWork ) {


              while( hasPunc(w) ) {


               String first = w.substring( 0, 1 );
               String last  = w.substring( w.length()-1 );


                //strip punctuation at beginning
               if ( isPunc( first ) ) {
                beginPunc += first;
                w = w.substring(1);
              }


                //strip punctuation at end
              if ( isPunc(last) )  {
                endPunc = last + endPunc;
                w = w.substring( 0, w.length()-1 );
              }
            }
          } 


            if (w.substring(0,1).equals(w.substring(0,1).toUpperCase())){
              cap = true;
            }
            else if((PUNCS.indexOf(w.substring(0,1)) >= 0) && w.substring(1,2).equals(w.substring(1,2).toUpperCase())){
              cap = true;
            }
            if(w.length() > 0){
              if(allVowels(w).length() > 0){
                if(beginsWithVowel(w)){
                  retString += w + "way";
                }
                else{
                  retString += w.substring(w.indexOf(firstVowel(w))) + w.substring(0,w.indexOf(firstVowel(w))) + "ay";
                }
              }
              else{
                if(hasAVowel("y")){
                  retString += w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay";
                }
                else{
                  retString += w + "ay";
                }
              }
            }
            if (cap == true){
            return beginPunc + retString.substring(0,1).toUpperCase() + retString.substring(1).toLowerCase() + endPunc; 
          }
            else{
              return beginPunc + retString.toLowerCase() + endPunc;
            }
  }



      /* =========================================
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
        ==================================================*/ 

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
            Scanner sc = new Scanner(System.in);
        while( sc.hasNext() ) {
          String newValue = sc.next();
          System.out.println( allVowels(newValue) );
          System.out.println( firstVowel(newValue) );
          System.out.println( countVowels(newValue) );
          System.out.println( engToPig(newValue) );
        }
            for (String thing : args){
             System.out.println( allVowels(thing) );
             System.out.println( firstVowel(thing) );
             System.out.println( countVowels(thing) );
             System.out.println( engToPig(thing) );
           }
        }//end main()

    }//end class Pig
