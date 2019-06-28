// Jeffrey Weng
// APCS1 pd 5
// HW11-- Iterative Improvement
// 2016-09-28

//Worked with: Tim Wang, Allan Wang
//TeamName: W^3


public class BankAccount {
    String accountName;
    int accountPass; 
    int pin;
    int accountNumber;
    float accountBalance;
    
    public BankAccount(){
	   accountName = "Anonymous";
    }
    
    public BankAccount(String name, int pass){
        accountName = name;
        accountPass = pass;
    }

    public static void main(String[] args){
        BankAccount jeffrey = new BankAccount("jeffrey", 12345);
        BankAccount daniel = new BankAccount("daniel",54321);
        BankAccount bob = new BankAccount();
        /*
        CHECK CODE

        jeffrey.editAccount(8888,234456567,987.3f);
        jeffrey.showAccount();
        System.out.println("deposit:");
        jeffrey.deposit(10);
        System.out.println("widthdraw");
        jeffrey.withdraw(10);

        bob.editAccount(8888,234456567,987.3f);
        bob.showAccount();
        System.out.println("deposit:");
        bob.deposit(10);
        System.out.println("widthdraw");
        bob.withdraw(10);

        */

    }


    //extra info about your account
    public void editAccount(int fourPin,int nineNumber,float balance){
        pin = fourPin;
        accountNumber = nineNumber;
        accountBalance = balance;
    }

    //displays all instance variables
    public void showAccount(){
        System.out.println("account name:");
        System.out.println(accountName);
        System.out.println("account pass:");
        System.out.println(accountPass);
        System.out.println("account pin:");
        System.out.println(pin);
        System.out.println("account nine digit number:");
        System.out.println(accountNumber);
        System.out.println("account balance:");
        System.out.println(accountBalance);
    }

    public void deposit(float amount){
        accountBalance += amount;
        System.out.println(accountBalance);
    }

    public void withdraw(float amount){
        accountBalance -= amount;
        System.out.println(accountBalance);
    }
    

}
