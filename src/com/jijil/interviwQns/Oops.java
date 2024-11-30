package com.jijil.interviwQns;

public class Oops {
}
//How encapsulation and abstraction work together, explain with code.
// Abstraction - expose essential details while hiding internal complexity . Interface and abstract classes provides abstraction
// encapsulation -Access modifiers, restricting direct access to data , can access via methods. private fields and public method to access data


interface Bank {

    public double getBalance();

    public void deposit(double depositAmt);

    public void withdrawal(double withdrawingAmt);


}


class BankImpl implements Bank{

    private double balance;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double depositAmt) {
        //Added validation in methods to show encapsulation in practice.
        if(depositAmt > 0) {
            balance = balance + depositAmt;
        }
        else {
            System.out.println("Depositing amount should be Positive");
        }

    }

    @Override
    public void withdrawal(double withdrawingAmt) {
        //Validation to show encapsulation, check the withdrwal amount > 0 and < balance amount
        balance = balance -withdrawingAmt;

    }
}

class BankClient {


    public static void main(String[] args) {
        //Abstraction in action , Bank interface used
        Bank  bank = new BankImpl();

        //Encapsulation in action - using public methods to access balance so that controlled access only given
        bank.deposit(100);

    }
}