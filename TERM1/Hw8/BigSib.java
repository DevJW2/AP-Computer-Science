// Jeffrey Weng
// APCS1 pd 5
// HW 8 -- On the Origins of a BigSib
// 2016-09-25

public class BigSib {
    public String helloMsg;

    public BigSib(String x){
    	helloMsg = x;
    }
    public String greet(String person){
		return helloMsg + " " + person;
	}

}
