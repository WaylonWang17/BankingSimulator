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
    private Map<Integer, BankAccount> accountList; // mapping objects not types (acc no, bank account)
    private int accountNumber;

    public Bank(){
        accountList = new HashMap<Integer, BankAccount>();
        this.accountNumber = 1;
    }

    public void createAccount(String accName, double accBalance){
        BankAccount b = new BankAccount(accName, accountNumber, accBalance);
        accountList.put(accountNumber, b);
        accountNumber++;
    }

    public BankAccount lookUpAccounts(int accountNumber){
        BankAccount account = accountList.get(accountNumber);
        if (account == null){
            System.out.println("Could not find account associated to " + accountNumber);
        }
        return account;
    }
    
    public void deposit(int accountNumber, double depositAmount){
        BankAccount account = lookUpAccounts(accountNumber);
        if (account != null){
            account.deposit(depositAmount);
        }
    }

    public void withdraw(int accountNumber, double withdrawalAmount){
        BankAccount account = lookUpAccounts(accountNumber);
        if (account != null){
            account.withdraw(withdrawalAmount);
        }
    }

    public void transfer(int accountNumberTo, int accountNumberFrom, double transferAmount){
        BankAccount accountTo = lookUpAccounts(accountNumberTo);
        BankAccount accountFrom = lookUpAccounts(accountNumberFrom);


        if (accountTo != null && accountFrom != null){
            double accountFromBalance = accountFrom.getBalance();
            if (accountFromBalance >= transferAmount){
                accountFrom.withdraw(transferAmount);
                accountTo.deposit(transferAmount);
            }
        }
    }

    public void listAllAccounts(){
        for (Map.Entry<Integer, BankAccount> entry : accountList.entrySet()) {
            System.out.println("Account Number: " + entry.getKey());
            entry.getValue().displayInfo();
        }
    }
}
