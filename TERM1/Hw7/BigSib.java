// Jeffrey Weng
// APCS1 pd 5
// HW 7 -- On BigSib Individuality and the Elimination of Radio Fuzz
// 2016-09-22

public class BigSib {
    public String helloMsg;

    public void setHelloMsg(String newMsg){
		helloMsg = newMsg;
    }
    public String greet(String person){
		return helloMsg + " " + person;
	}

}
