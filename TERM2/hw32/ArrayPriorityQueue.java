//Jeffrey Weng
//APCS2 pd3
//hw32 -- Getting Past the Velvet Rope
//2017-04-19

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue{

    private ArrayList _priorityQ;

    public ArrayPriorityQueue(){
	_priorityQ = new ArrayList();
    }
    
    public void add(int x){
	_priorityQ.add(x);
    }

    public boolean isEmpty(){
	return _priorityQ.size() == 0;
    }
    
    public int peekMin(){
	if(!isEmpty()){
	    int min = (int)_priorityQ.get(0);
	
	    for(int i = 1; i < _priorityQ.size(); i++){
		if((int)_priorityQ.get(i) < min ){
		    min = (int)_priorityQ.get(i);
		}
	    }
	    return min;
	}
	return -1;
	
	
    }

    public int removeMin(){
	for(int i = 0; i < _priorityQ.size(); i++){
	    if((int)_priorityQ.get(i) == peekMin()){
		int min =(int)_priorityQ.get(i);
		_priorityQ.remove(i);
		return min;
	    }
	}
	return -1;
    }

    public String toString(){
	return _priorityQ.toString();
    }
    
    public static void main(String[] args) {
	PriorityQueue item = new ArrayPriorityQueue();
	System.out.println(item);
	System.out.print("Empty?: ");
	System.out.println(item.isEmpty());
	item.add(5);
	item.add(1);
	item.add(3);
	item.add(4);
	item.add(6);
	item.add(1);
	System.out.println(item);
	System.out.print("min: ");
	System.out.println(item.peekMin());
	System.out.print("Empty?: ");
	System.out.println(item.isEmpty());

	System.out.println("Removing highest priority(minimum)");
	System.out.println(item.removeMin());

	System.out.println("Printing out queue");
	System.out.println(item);

	

	
    } 
  
}
