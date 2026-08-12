/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4_2;

/**
 *
 * @author GAAMA
 */
public class FixedDepositeAccount extends Account{
    private double intersetRate;
    private int months;
    private int passedMonths;

    public FixedDepositeAccount(double intersetRate, int months, double balance, AccountStatus status,Customer customer) {
        super(balance, status,customer);
        this.intersetRate = intersetRate;
        this.months = months;
        this.passedMonths=0;
    }
    
    

    public double getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(double intersetRate) {
        this.intersetRate = intersetRate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    
    @Override
    public void withdraw(double amount) {
        
        if(amount<0)
        {
           System.out.println("Amount must be greater than 0");
            return;
        }
        if(passedMonths<months)
        {
          int remainMonths=months-passedMonths;
            System.out.println("Withdraw rejected");
            System.out.println("Remain  onths: "+remainMonths);
            return;
        }
        if(amount>super.getBalance())
        {
           System.out.println("Incoorect balance.");
            return;
        }
        double result=super.getBalance()-amount;
        super.setBalance(result);
        System.out.println("Success");
        System.out.println("New Balance= "+result);
    }

    @Override
    public void deposite(double amount) {
        if(amount<0)
        {
            System.out.println("Amount must be greater than 0");
            return;
        }
        double result=super.getBalance()+amount;
        super.setBalance(result);
        
       System.out.println("current Balance= "+(super.getBalance()-amount)+" Deposite= "+amount+" New Balance= "+result);
    }
    
    
    
}
