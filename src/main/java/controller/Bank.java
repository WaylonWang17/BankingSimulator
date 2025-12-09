package controller;
//store all acounts
//create accounts
//look up accounts
//perform deposits and withdrawals using bankaccount
//perform transfers
//list all accounts

import java.util.HashMap;
import java.util.Map;

import model.BankAccount;


public class Bank {
    private Map<Integer, BankAccount> accountList; //mapping objects not types (acc no, bank account)
    private int accountCounter;

    public Bank(){
        accountList = new HashMap<Integer, BankAccount>();
        this.accountCounter = 1;
    }

    public void createAccount(String accName, double accBalance){
        BankAccount b = new BankAccount(accName, accountCounter, accBalance);
        accountList.put(accountCounter, b);
        accountCounter++;
    }

    public void listAllAccounts(){
        for (Map.Entry<Integer, BankAccount> entry : accountList.entrySet()) {
            System.out.println("Account Number: " + entry.getKey());
            entry.getValue().displayInfo();
        }
    }
}
