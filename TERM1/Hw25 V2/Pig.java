// Jeffrey Weng,Federico Tondolo,Zilin Wang
// APCS1 pd 5
// Hw25 -- ? ? ? 
// 2016-11-01

//Team Name - FTW


//class Pig
//a Pig Latin translator
//v1


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
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      import java.util.Scanner;
      public class Pig
      {
        private static final String VOWELS = "aeiou";




    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") → true
      hasA("cat", "p") → false
      =====================================*/
      public static boolean hasA( String w, String letter )
      {
        return w.indexOf(letter) != -1;
    }//end hasA()




    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
      public static boolean isAVowel( String letter )
      {
        return VOWELS.indexOf( letter ) != -1;
      }




    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") → 3
      =====================================*/
      public static int countVowels( String w )
      {
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
        return w.indexOf(w) >= 0;
      }




    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") → "eaa"
      =====================================*/
      public static String allVowels( String w )
      {
  String ans = ""; //init return String


  for( int i = 0; i < w.length(); i++ ) {
    if ( isAVowel( w.substring(i,i+1) ) )
    ans += w.substring( i, i+1 ); //grow return String
}
return ans;
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
        String ans = "";
        if (countVowels(w)<1){
          return "";
        }
  if ( hasAVowel(w) ) //Q: Why this necessary?
  ans = allVowels(w).substring(0,1);


  return ans;
}




    /*=====================================
      boolean beginsWithVowel(String) --
            tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
      public static boolean beginsWithVowel( String w )
      {
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
        String ans = "";
        if ( beginsWithVowel(w) ){
          ans = w + "way";
        }
        if (countVowels(w)<1){
          int yPos=0;
          while (yPos<w.length()){
            if (w.substring(yPos,yPos+1).equals("y")){
              return ans=w.substring(yPos,yPos+1).toUpperCase()+w.substring(yPos+1)+w.substring(0,yPos)+"ay";
            }
            if (w.substring(yPos,yPos+1).equals("Y")){
              return ans=w.substring(yPos,yPos+1).toUpperCase()+w.substring(yPos+1)+w.substring(0,yPos)+"ay";
            }
            if (w.substring(yPos,yPos+1).equals(".")){
              return engToPig(w.substring(0,yPos))+".";
            }
            yPos+=1;
          }
        }
        else {
          int vPos = w.indexOf( firstVowel(w) );
          int yPos=0;
          while (yPos<w.length()){
            if (w.substring(yPos,yPos+1).equals(".")){
              return engToPig(w.substring(0,yPos))+".";
            }
            yPos+=1;
          }
          ans = w.substring(vPos,vPos+1).toUpperCase()+w.substring(vPos+1) + w.substring(0,vPos).toLowerCase() + "ay";
        }


        return ans;
      }




      public static void main( String[] args )
      {
        Scanner sc = new Scanner(System.in);
        while( sc.hasNext() ) {
          String newValue = sc.next();
          System.out.println( allVowels(newValue) );
          System.out.println( firstVowel(newValue) );
          System.out.println( countVowels(newValue) );
          System.out.println( engToPig(newValue) );
        }
        for( String word : args ) {
          System.out.println( allVowels(word) );
          System.out.println( firstVowel(word) );
          System.out.println( countVowels(word) );
          System.out.println( engToPig(word) );
        }
    }//end main()


}//end class Pig
