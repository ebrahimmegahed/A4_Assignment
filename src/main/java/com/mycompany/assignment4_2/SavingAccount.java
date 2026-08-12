/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4_2;

import static com.mycompany.assignment4_2.AccountStatus.FROZEN;
import java.io.ObjectInputFilter;

/**
 *
 * @author GAAMA
 */
public class SavingAccount extends Account{
   private double intersetRate;

    public SavingAccount(double intersetRate, double balance, AccountStatus status,Customer customer) {
        super(balance, status,customer);
        this.intersetRate = intersetRate;
    }

   
   
    @Override
    public void withdraw(double amount) {
        if(super.getStatus()==AccountStatus.FROZEN||super.getStatus()==AccountStatus.CLOSED)
        {
            System.out.println("This account cannot be able do any transaction");
            return;
        }
        
        if(amount<0)
        {
            System.out.println("The amount cannot be negative");
        }
        if(amount<super.getBalance())
        {
          double res=super.getBalance()-amount;
          super.setBalance(res);
            System.out.println("Transaction Done");
            
        }
        else
        {
            System.out.println("there is not exist enough money");
        }
        
    }

    @Override
    public void deposite(double amount) {
         if(super.getStatus()==AccountStatus.FROZEN||super.getStatus()==AccountStatus.CLOSED)
        {
            System.out.println("This account cannot be able do any transaction");
            return;
        }
        if(amount<0)
        {
            System.out.println("Amount cannot be negative");
        }
        if(amount<super.getBalance())
        {
          double res=super.getBalance()+amount;
          super.setBalance(res);
            System.out.println("Deposite done");
            System.out.println("current Balance= "+(super.getBalance()-amount)+" Deposite= "+amount+" New Balance= "+res);
        }
       
    }

   
   
}
