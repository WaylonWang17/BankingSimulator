package view;

import controller.Bank;

public class Main {
    public static void main(String[] args) {
        Bank b = new Bank();
        b.createAccount("Willus", 0);
        b.listAllAccounts();
    }
}
