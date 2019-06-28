//Jeffrey Weng
//APCS1 pd5
//HW27 Recurse, Recurse, on Elements Not the First!
//2016-11-03


public class Loopier{
	static int frequencyx = 0;

	//iterative linsearch
    public static int linSearch(int[] a, int target){
	for(int i = 0; i < a.length; i++){
	    if(a[i] == target){
			return i;
	    }
	}
		return -1;
    }
    //recursive part of linSearchR, creates a smaller list, that takes out the last element.
    public static int linSearchR(int[] a, int target){
		if(a.length == 0){
			return -1; 
		}
		else{
			 
			if(target == a[a.length - 1]){
				return a.length - 1;
			}
			else{
				int[] b = new int[a.length - 1];
				for(int i = 0; i < a.length - 1; i ++){
					b[i] = a[i];
				}
				return linSearchR(b, target);
			}
			 
		}
    }
    //iterative freq
    public static int freq(int[] a, int target){
	int frequency = 0;
	for(int i = 0; i < a.length; i++){
	    if(a[i] == target){
		frequency += 1;
	    }
	}
	return frequency;
    }
    // Reuses the linSearch recursive but adds to static defined frequency
    public static int freqRec(int[] a, int target){
    	if(a.length == 0){
			return frequencyx; 
		}
		else{
			 
			if(target == a[a.length - 1]){
				return frequencyx += 1;
			}
			else{
				int[] b = new int[a.length - 1];
				for(int i = 0; i < a.length - 1; i ++){
					b[i] = a[i];
				}
				return linSearchR(b, target);
			}
			 
		}

    }
    
    //Calls the methods
    public static void main(String[] args){
    	int[] a = {1,2,3,3,4,5};
    	System.out.println(linSearch(a, 3));
    	System.out.println(linSearchR(a, 2));
    	System.out.println(freq(a, 3));
    	System.out.println(freq(a, 3));
    }
}