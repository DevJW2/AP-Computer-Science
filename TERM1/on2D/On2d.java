public class On2d{
    public static void main(String[] args){
        int[][] arr = {{1,3,5},{3,7,8},{5,12,15}};
	for(int n = 0; n < (arr.length * arr[0].length); n++){
	    if(arr[n % arr.length][n / arr.length] == 0){
		System.out.println("true");
	    }
	   
	}

	
    }
}
