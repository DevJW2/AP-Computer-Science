// Jeffrey Weng
// APCS1 pd 5
// Hw 13 -- OutSourcing
// 2016-10-05

public class Teller {
    public static void main(String[] args){

    	//Creates a bankaccount called jeffrey, which tests every method, plus tests the withdraw error

		BankAccount jeffrey = new BankAccount("jeffrey","hello",1234,123456789,50.0);

		//Creates a bankaccount called tim, which tests the nine digit account number, and pin number.
		BankAccount tim = new BankAccount("tim", "random",20001,1234567,50.00);

        System.out.println(jeffrey);

        jeffrey.withdrawMoney(10.00);

        jeffrey.depositMoney(20.00);

        System.out.println(jeffrey.authenticate(123456789,"hola"));

        System.out.println(jeffrey.authenticate(123456789,"adios"));

        // Withdraw Error
        jeffrey.withdrawMoney(1000.00);

        System.out.println(jeffrey);

        //C
        System.out.println(tim);
}	

}