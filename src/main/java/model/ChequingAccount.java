package model;

public class ChequingAccount extends BankAccount{
    private double overdraftLimit = 250.0;


    public ChequingAccount(String accName, int accNumber, double accBalance){
        super(accName, accNumber, accBalance);
    }
    @Override
    public void withdraw(double withdrawAmount){
        if (withdrawAmount <= 0){
            System.out.printf("Error, cannot withdraw that amount! Account balance: %.2f\n", accBalance);
            return;
        }

        if (accBalance >= withdrawAmount){
            accBalance -= withdrawAmount;
            System.out.printf("Withdrawal successful! Account balance: %.2f\n", accBalance);
            return;
        }

        double overdraftNeeded = withdrawAmount - accBalance;

        if (overdraftNeeded > overdraftLimit){
            System.out.printf("Insufficient funds! Account balance: %.2f\n", accBalance);
            return;
        }
        else{
            accBalance -= withdrawAmount;
            System.out.printf("Withdrawal successful! Account balance: %.2f\n", accBalance);
        }
    }
}
