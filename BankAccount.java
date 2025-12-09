public class BankAccount {
    private String accName;
    private final int accNumber;
    private double accBalance;

    public BankAccount(String accName, int accNumber, double accBalance){
        this.accName = accName;
        this.accNumber = accNumber;
        this.accBalance = accBalance;
    }

    public void deposit(double depositAmount){
        if (depositAmount <= 0){
            System.out.println("Error, cannot deposit that amount!\n");
        }else{
            accBalance += depositAmount;
            System.out.printf("Successfully deposited %.2f!\n", depositAmount);
        }
        return;
    }

    public void withdraw(double withdrawAmount){
        if (withdrawAmount <= 0){
            System.out.println("Error, cannot withdraw that amount!\n");
        }
        else{
            if (accBalance >= withdrawAmount){
                accBalance -= withdrawAmount;
                System.out.printf("Successfully withdrew %.2f!\n", withdrawAmount);
            }else{
                System.out.println("Error, insufficient funds!\n");
            }
        }
        return;
    }

    public double getBalance(){
        return accBalance;
    }

    public void displayInfo(){
        System.out.println("---------------------------------------------");
        System.out.printf("Account Name: %s\n", accName);
        System.out.printf("Account Number: %d\n", accNumber);
        System.out.printf("Account Balance: %.2f\n", accBalance);
        System.out.println("---------------------------------------------");
    }
}
