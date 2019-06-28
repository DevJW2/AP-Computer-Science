public class driver{
    public static void main(String[] args){
		//testing mean
	   	System.out.println(Stats.mean(4,5));
       	System.out.println(Stats.mean(4.0,5.0));
       	//testing max
       	System.out.println(Stats.max(4,5));
       	System.out.println(Stats.max(5,5));
       	System.out.println(Stats.max(6,5));
       	System.out.println(Stats.max(4.0,5.0));
       	System.out.println(Stats.max(5.0,4.0));
       	System.out.println(Stats.max(5.5,5.5));
       	//testing geoMean
       	System.out.println(Stats.geoMean(4,5));
       	System.out.println(Stats.geoMean(4.0,5.0));
       	//testing max values
       	System.out.println(Stats.max(4,5,6));
       	System.out.println(Stats.max(5,4,6));
       	System.out.println(Stats.max(5,6,4));
       	System.out.println(Stats.max(4,6,5));
       	System.out.println(Stats.max(6,5,4));
       	System.out.println(Stats.max(6,4,5));
       	//Similar max values
       	System.out.println(Stats.max(6,6,5));
       	System.out.println(Stats.max(6,6,6));
       	System.out.println(Stats.max(6,5,6));
       	System.out.println(Stats.max(5,6,6));	

       	//testing double max values
      	System.out.println(Stats.max(4.0,5.0,6.0));
       	System.out.println(Stats.max(5.0,4.0,6.0));
       	System.out.println(Stats.max(5.0,6.0,4.0));
       	System.out.println(Stats.max(4.0,6.0,5.0));
       	System.out.println(Stats.max(6.0,5.0,4.0));
       	System.out.println(Stats.max(6.0,4.0,5.0));
       	//testing geoMean with 3 numbers
       	System.out.println(Stats.geoMean(4,5,6));
       	System.out.println(Stats.geoMean(4.0,5.0,6.0));
	}
}