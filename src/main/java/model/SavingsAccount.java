package model;

public class SavingsAccount extends BankAccount{
    double interestRate = 0.12;
    public SavingsAccount(String accName, int accNumber, double accBalance){
        super(accName, accNumber, accBalance);
    }

    public void applyInterest(){
        accBalance = accBalance + accBalance*interestRate;
    }
}
