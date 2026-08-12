/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4_2;

/**
 *
 * @author GAAMA
 */
public abstract class Account {
    private Customer customer;
    private double balance;
   private AccountStatus status;
   private static int successfultransaction=0;
   private int accountId;
   private static int nextAccount=101;

   
   public  void withdraw(double amount){successfultransaction++;};
   public  void deposite(double amount){successfultransaction++;};
    public Account(double balance, AccountStatus status,Customer customer) {
        this.balance = balance;
        this.status = status;
        this.customer=customer;
        accountId=nextAccount++;
    }

    public int getAccountId() {
        return accountId;
    }

    
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public  int getSuccessfultransaction() {
        return successfultransaction;
    }

    public Customer getCustomer() {
        return customer;
    }

  
   
   
   
}
