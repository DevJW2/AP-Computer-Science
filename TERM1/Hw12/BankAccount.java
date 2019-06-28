// Jeffrey Weng
// APCS1 pd 5
// HW12-- Mo Money Mo Problems
// 2016-10-04

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


    public boolean authenticate(String name, int pass){
        if (accountName != name || accountPass != pass){
            return false;
        }
        else {
            return true;
        }

    }

    //extra info about your account
    public void editAccount(int fourPin,int nineNumber,float balance){
        if (fourPin >= 1000 && fourPin <= 9998){
            pin = fourPin;
        }
        else {
            pin = 9999;
            System.out.println("PLEASE ENTER A 4 DIGIT NUMBER");
        }
        if (nineNumber >= 100000000 && nineNumber <= 999999998){
            accountNumber = nineNumber;
        }
        else {
            accountNumber = 999999999;
            System.out.println("PLEASE ENTER A 9 DIGIT NUMBER");
        }
        accountBalance = balance;
    }

    //displays all instance variables
    public void showAccount(){
        String ret_string = "";

        ret_string += "account name: ";
        ret_string += accountName + "\n";
        ret_string += "account pass: ";
        ret_string += accountPass + "\n";
        ret_string += "account pin: ";
        ret_string += pin + "\n";
        ret_string += "account nine digit number: ";
        ret_string += accountNumber + "\n";
        ret_string += "account balance: ";
        ret_string += accountBalance + "\n";

        System.out.println(ret_string);
    }

    public void deposit(float amount){
        accountBalance += amount;
        System.out.println(accountBalance);
    }

    public boolean withdraw(float amount){
        if (amount > accountBalance){
            System.out.println("Withdrawal: ERROR");
            return false;
        }
        else {
            accountBalance -= amount;
            System.out.println(accountBalance);
            return true;
        }
    }

    public static void main(String[] args){
        BankAccount jeffrey = new BankAccount("jeffrey", 12345);
        BankAccount daniel = new BankAccount("daniel",54321);
        BankAccount bob = new BankAccount();

        // Test Regular
        jeffrey.editAccount(8888,234456567,987.3f);
        jeffrey.showAccount();
        System.out.print("deposited: ");
        jeffrey.deposit(10);
        System.out.print("widthdrew: ");
        jeffrey.withdraw(10);
        System.out.println("");

        //Test Widthdrawal 
        jeffrey.withdraw(1000000);

        //Test authenticate
        System.out.print("Authentication: ");
        System.out.println(jeffrey.authenticate("jeffrey",12345));
        System.out.print("Authentication: ");
        System.out.println(jeffrey.authenticate("jeffery",12345));

        //Test No Account
        bob.editAccount(8888,234456567,987.3f);
        bob.showAccount();
        System.out.print("deposited: ");
        bob.deposit(10);
        System.out.print("widthdrew: ");
        bob.withdraw(10);
        System.out.println("");

        //Test Nine Digit
        jeffrey.editAccount(8888,22222,987.3f);
        System.out.println(jeffrey.accountNumber + "\n");

        //Test Four Digit
        jeffrey.editAccount(88,234456567,987.3f);
        System.out.println(jeffrey.pin + "\n");

        //Test Four Digit and Nine Digit
        jeffrey.editAccount(88,222,987.3f);
        System.out.println(jeffrey.accountNumber);
        System.out.println(jeffrey.pin);

    }
    

}
