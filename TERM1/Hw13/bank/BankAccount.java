// Jeffrey Weng
// APCS1 pd 5
// Hw 13 -- OutSourcing
// 2016-10-05

//TAKEN FROM TEAM CONSTRUCTOR

public class BankAccount {

    //setting up the instance variables

    private String ownerName;

    private String password;

    private int pinNumber;

    private int accountNum;

    private double balance;





    //default constructor

    public BankAccount (){

        ownerName = "Unknown";

        password = "";

        pinNumber = 9999;

        accountNum = 999999999;

        balance = 0.00;

    }





    //overloaded constructor

    public BankAccount ( String newOwnerName, String newPassword, int newPinNumber, int newAccountNumber, double newBalance) {

        ownerName = newOwnerName;

        password = newPassword;

        if (newPinNumber >= 1000 && newPinNumber <= 9998) {

            pinNumber = newPinNumber;

        }

        else {

            pinNumber = 9999;

            System.out.println ("Error: Invalid PIN Number");

        }

        if (newAccountNumber >= 100000000 && newAccountNumber <= 999999998 ) {

            accountNum = newAccountNumber;

        }

        else {

            accountNum = 999999999;

            System.out.println ("Error: Invalid Account Number");

        }

        balance = newBalance;

    }





    //Method for depositing money into the bank account

    public void depositMoney (double amount){

        balance += amount;

        System.out.println ("Your new balance is: " + balance);

    }





    //Method for withdrawing money from the bank account

    public boolean withdrawMoney (double amount) {

        if (balance > amount) {

            balance -= amount;

            System.out.println ("You new balance is: " + balance);

            return true;

        }

        else {

            System.out.println ("Error: Cannot withdraw money");

            return false;

        }

    }





    //Overwritten toString function which will return the account information

        public String toString (){

        String retstr;

        retstr = "\n" + "Account Information:" + "\n";

        retstr += "Name: " + ownerName + "\n";

        retstr += "Password: " + password + "\n";

        retstr += "Pin Number: " + pinNumber + "\n";

        retstr += "Account Number: " + accountNum + "\n";

        retstr += "Balance: " + balance + "\n";

        return retstr;

    }





    //Method for testing credentials

    public boolean authenticate (int AccountNumber, String Password) {

        if (accountNum == AccountNumber && password == Password){

            return true;

        }

        else{

            return false;

        }

    }

    

    //main method which tests all of the above methods

    public static void main (String [] args){

        BankAccount bob = new BankAccount ("Bob","hola",2000,123456789,50.00);

        System.out.println(bob);

        bob.withdrawMoney(10.00);

        bob.depositMoney(20.00);

        System.out.println(bob.authenticate(123456789,"hola"));

        System.out.println(bob.authenticate(123456789,"adios"));

        bob.withdrawMoney(1000.00);

        System.out.println(bob);





        BankAccount someone = new BankAccount("Someone","random",20001,1234568,50.00);

        System.out.println(someone);

    }

}
