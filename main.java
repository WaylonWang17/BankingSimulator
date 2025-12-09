public class main {
    public static void main(String[] args) {
        double balance;

        BankAccount b = new BankAccount("Walton", 1840608, 100.23);

        b.displayInfo();
        b.deposit(30);
        balance = b.getBalance();
        System.out.printf("%.2f\n", balance);
        b.withdraw(56.58);
        balance = b.getBalance();
        System.out.printf("%.2f\n", balance);
        b.displayInfo();
    }
}
