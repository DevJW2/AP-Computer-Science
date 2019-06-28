 //Jeffrey Weng
//APCS2 pd3
//Hw04--Where In the Array is Carmen San Numero?
//2017-2-05

//Obtained from GeeksforGeeks

//Marks indexes as negatives and sets the values of the array as them
public class MissingNum{
    public static void findNum(int[] arr){
	for(int i = 0; i < arr.length; i++){
	    if(arr[Math.abs(arr[i] - 1)] > 0){
		arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i])- 1];
	    }
	    else{
		System.out.println(Math.abs(arr[i]));
	    }
	}
	//Positive index + 1 is value your missing
	for(int i = 0; i < arr.length; i++){
	    if(arr[i] > 0){
		System.out.println(i + 1);
	    }
	}
    }
    public static void main(String[] args){
	int arr[] = {2,1,2,4};
	findNum(arr);
    }
}
