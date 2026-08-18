/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assignment4_2;

import java.util.Locale;
import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author GAAMA
 */
public class Assignment4_2 {

    static Scanner in = new Scanner(System.in).useLocale(Locale.US);
    

    public static String validateName() {
        System.out.print("Enter Your full Name: ");
        in.nextLine();
        String fullName = in.nextLine();
        if (fullName.isEmpty()) {
            System.out.println("Name cannot be empty");
            return null;
        } else {
            return fullName;
        }
         
    }

    public static int validateNationalId(Customer[] customer) {
        while (true) {
            
            System.out.print("Enter Your National ID: ");
            int id = in.nextInt();
            boolean exist = false;
            for (int i = 0; i < customer.length; i++) {
                if (customer[i] != null && customer[i].getNationalId() == id) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                System.out.println("This national ID already exists.");
            } else {
                return id;
            }
        }
    }

    public static String validatePhoneNumber() {

        while (true) {
            
            System.out.print("Enter 7-15 digits-phone Number: ");
            String phone = in.next();

            // Check length
            if (phone.length() < 7 || phone.length() > 15) {
                System.out.println("Phone number must be between 7 and 15 digits.");
                continue;
            }

            // Check that every character is a digit
            boolean allDigits = true;

            for (int i = 0; i < phone.length(); i++) {

                if (!Character.isDigit(phone.charAt(i))) {
                    allDigits = false;
                    break;
                }
            }

            if (!allDigits) {
                System.out.println("Phone number must contain digits only.");
                continue;
            }

            return phone;
        }
    }

    public static void addcustomer(Customer[] customer) {
      //  System.out.print("Enter Your name: ");
        String fullName = validateName();
       
       // System.out.print("Enter National id: ");
        int nationalId = validateNationalId(customer);
        //System.out.print("Enter Your Phone Number: ");
        String PhoneNumber = validatePhoneNumber();
        System.out.println("Enter Customer Tier: Standard,Silver,Gold: ");
        String tier = in.next();

        int index = 0;
        for (int i = 0; i < customer.length; i++) {
            if (customer[i] == null) {
                index = i;
                break;
            }
        }

        Customer c = new Customer(fullName, PhoneNumber, nationalId, customerTiers.valueOf(tier.toUpperCase()));
        customer[index] = c;
        System.out.println("Your id: " + customer[index].getCustomerId());
    }

    public static Customer findCustomer(Customer[] customer) {

        while (true) {
            boolean exist = false;
            System.out.println("Enter Your Customer id: ");
            int id = in.nextInt();
            for (int i = 0; i < customer.length; i++) {
                if (customer[i] != null && customer[i].getCustomerId() == id) {
                    return customer[i];

                }

            }
            System.out.println("Customer id doesnot exist");

        }

    }

    public static void addNewAccount(Customer[] customer, SavingAccount[] saving, CurrentAccount[] current, FixedDepositeAccount[] fixed) {

        Customer selectedCustomer = findCustomer(customer);

        System.out.println("Select Type: 1.Savings | 2.Current | 3.Fixed Deposit");
        System.out.print("Choice: ");
        int type = in.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = in.nextDouble();
        switch (type) {
            case 1:
                if (balance < 500) {
                    System.out.println("The min balance must be greater than 500");
                    return;
                }
                System.out.print("Enter Interset Rate: ");
                double intersetRate = in.nextDouble();
                int index = -1;
                for (int i = 0; i < saving.length; i++) {
                    if (saving[i] == null) {
                        index = i;
                        break;
                    }
                }
                SavingAccount acc = new SavingAccount(intersetRate, balance, AccountStatus.ACTIVE, selectedCustomer);
                saving[index] = acc;
                System.out.println("Added successfully");
                System.out.println("Account id: " + saving[index].getAccountId());

                break;
            case 2:
                if (balance < 1000) {
                    System.out.println("This account must be greater than 1000");
                    return;

                }
                System.out.print("Enter Overdraft Limit: ");
                double overLimit = in.nextDouble();
                int currentIndex = -1;
                for (int i = 0; i < current.length; i++) {
                    if (current[i] == null) {
                        currentIndex = i;
                        break;
                    }
                }
                CurrentAccount caa = new CurrentAccount(overLimit, balance, AccountStatus.ACTIVE, selectedCustomer);
                current[currentIndex] = caa;
                System.out.println("Added successfully");
                System.out.println("Account id: " + current[currentIndex].getAccountId());

                break;

            case 3:
                if (balance < 1500) {
                    System.out.println("The balance must be greater than 1500");
                    return;
                }
                System.out.print("Enter intersetRate: ");
                double rate = in.nextDouble();
                System.out.print("Enter duration: ");
                int duration = in.nextInt();
                int fixedIndex = -1;
                for (int i = 0; i < fixed.length; i++) {
                    if (fixed[i] == null) {
                        fixedIndex = i;
                        break;
                    }
                }

                FixedDepositeAccount fixedAcc = new FixedDepositeAccount(rate, duration, balance, AccountStatus.ACTIVE, selectedCustomer);
                fixed[fixedIndex] = fixedAcc;
                System.out.println("Added successfully");
                System.out.println("Account id: " + fixed[fixedIndex].getAccountId());
                break;

            default:
                System.out.println("Invalid type");
                break;
        }

    }

    public static void deposite(SavingAccount[] saving, CurrentAccount[] current, FixedDepositeAccount[] fixed) {
        boolean found = false;
        System.out.print("Enter Account Id: ");
        int accountId = in.nextInt();
        System.out.print("Enter Deposite Amount:  ");
        double amount = in.nextDouble();
        if (!found) {
            for (int i = 0; i < saving.length; i++) {
                if (saving[i] != null && saving[i].getAccountId() == accountId) {
                    System.out.println("Account found");
                    saving[i].deposite(amount);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            for (int i = 0; i < current.length; i++) {
                if (current[i] != null && current[i].getAccountId() == accountId) {
                    System.out.println("Account found");
                    current[i].deposite(amount);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            for (int i = 0; i < fixed.length; i++) {
                if (fixed[i] != null && fixed[i].getAccountId() == accountId) {
                    System.out.println("Account found");
                    fixed[i].deposite(amount);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("aacount id not amtching pleas enter corect one");
        }
    }
    
    public static void withdraw(SavingAccount[] saving,CurrentAccount[] current,FixedDepositeAccount[] fixed)
    {
        boolean found = false;
        System.out.print("Enter Account Id: ");
        int accountId = in.nextInt();
        System.out.print("Enter withdraw Amount:  ");
        double amount = in.nextDouble();
        
        for (int i = 0; i < saving.length; i++) {
            if(saving[i]!=null&&saving[i].getAccountId()==accountId)
            {
            if(saving[i].getStatus()!=AccountStatus.ACTIVE)
            {
                System.out.println("The account is not active");
                return;
            }
            if(amount>=500)
            {
              saving[i].withdraw(amount);
                System.out.println("The new balance= "+saving[i].getBalance());
            }
                
           }
            return;
        }
        
        
        for (int i = 0; i < current.length; i++) {
            if(current[i]!=null&&current[i].getAccountId()==accountId)
            {
              if(current[i].getStatus()!=AccountStatus.ACTIVE)
              {
                  System.out.println("The account is not active");
                  return;
              }
              if(amount>=100)
              {
                  current[i].withdraw(amount);
                  System.out.println("New balance= "+current[i].getBalance());
              }
            }
            return;
        }
        for (int i = 0; i < fixed.length; i++) {
            if(fixed[i]!=null&&fixed[i].getAccountId()==accountId)
            {
              if(fixed[i].getStatus()!=AccountStatus.ACTIVE)
              {
                  System.out.println("The account is not active");
                  return;
              }
              if(amount>=100)
              {
                  fixed[i].withdraw(amount);
                  System.out.println("New balance= "+fixed[i].getBalance());
              }
            }
            return;
        }
        
        System.out.println("Account ID does not exist ");
    }
    
    public static Account validateaccount(SavingAccount[] saving,CurrentAccount[] current,FixedDepositeAccount[] fixed)
    {
        System.out.print("enter account number");
        int id=in.nextInt();
        boolean exist=false;
        for (int i = 0; i < saving.length; i++) {
            if(saving[i]!=null&&saving[i].getAccountId()==id)
            {
                return saving[i];
                
            }
        }
        for (int i = 0; i < current.length; i++) {
            if(current[i]!=null&&current[i].getAccountId()==id)
            {
                return current[i];
            }
        }
        for (int i = 0; i < fixed.length; i++) {
            if(fixed[i]!=null&&fixed[i].getAccountId()==id)
            {
                return fixed[i];
            }
        }
        
        
        System.out.println("This account does not exist");
        return null;
        
    }

    public static void TransverBetweenAccount(SavingAccount[] saving,CurrentAccount[] current,FixedDepositeAccount[] fixed)
    {
       
//        int srcNumber=validateaccount(saving, current, fixed);
//        
//        int desNumber=validateaccount(saving, current, fixed);
//        System.out.print("enter amount: ");
//        double amount=in.nextDouble();
//        if(srcNumber==desNumber)
//        {
//            System.out.println("Both number equals ");
//            return;
//        }
        
        withdraw(saving, current, fixed);
        deposite(saving, current, fixed);
        
    }
    
    public static void displayCustomerAccount(Customer[] customer,SavingAccount[] saving,CurrentAccount[] current,FixedDepositeAccount[] fixed)
    {
        Customer cust=findCustomer(customer);
        System.out.println(cust.getCustomerId());
        System.out.println(cust.getFullName());
        System.out.println(cust.getNationalId());
        System.out.println(cust.getPhoneNumber());
        
        for (int i = 0; i < saving.length; i++) {
            if(saving[i]!=null&&saving[i].getCustomer().getCustomerId()==cust.getCustomerId())
            {
                System.out.println("Account number: "+saving[i].getAccountId());
                System.out.println("Account Type: Saving");
                System.out.println("Account balance= "+saving[i].getBalance());
                System.out.println("Transaction count: "+saving[i].getSuccessfultransaction());
            }
        }
        for (int i = 0; i < current.length; i++) {
            if(current[i]!=null&&current[i].getCustomer().getCustomerId()==cust.getCustomerId())
            {
                System.out.println("Account number: "+current[i].getAccountId());
                System.out.println("Account Type: "+current);
                System.out.println("Account balance= "+current[i].getBalance());
                System.out.println("Transaction count: "+current[i].getSuccessfultransaction());
            }
        }
        for (int i = 0; i < fixed.length; i++) {
            if(fixed[i]!=null&&fixed[i].getCustomer().getCustomerId()==cust.getCustomerId())
            {
                System.out.println("Account number: "+fixed[i].getAccountId());
                System.out.println("Account Type: fixed");
                System.out.println("Account balance= "+fixed[i].getBalance());
                System.out.println("Transaction count: "+fixed[i].getSuccessfultransaction());
            }
        }
    }        
    
    public static void displayBranchAccounts(SavingAccount[] saving,CurrentAccount[] current,FixedDepositeAccount[] fixed)
    {
       for(SavingAccount acc:saving)
       {
           if(acc!=null){
           System.out.println(acc.getAccountId());
           System.out.println(acc.getBalance());
           System.out.println(acc.getStatus());
           
       }
       }
       for(CurrentAccount acc:current)
       {
           if(acc!=null){
           System.out.println(acc.getAccountId());
           System.out.println(acc.getBalance());
           System.out.println(acc.getStatus());
           
       }
       }
       for(FixedDepositeAccount acc:fixed)
       {
           if(acc!=null){
           System.out.println(acc.getAccountId());
           System.out.println(acc.getBalance());
           System.out.println(acc.getStatus());
           
       }
       }
    }

    public static void searchAccountByid(SavingAccount[] saving,CurrentAccount[] current,FixedDepositeAccount[] fixed)
    {
      boolean isfound=false;
        System.out.print("Enter Account Number: ");
        int accountid=in.nextInt();
        
        if(!isfound)
        {
          for(SavingAccount acc:saving)
          {
            if(acc!=null&&acc.getAccountId()==accountid)
            {
              System.out.println("Account found in Savings!");
                System.out.println(acc.getBalance());
                System.out.println(acc.getStatus());
                isfound=true;
                break;
            }
          }
        }
        if(!isfound)
        {
          for(CurrentAccount acc:current)
          {
            if(acc!=null&&acc.getAccountId()==accountid)
            {
              System.out.println("Account found in current!");
                System.out.println(acc.getBalance());
                System.out.println(acc.getStatus());
                isfound=true;
                break;
            }
          }
        }
        if(!isfound)
        {
          for(FixedDepositeAccount acc:fixed)
          {
            if(acc!=null&&acc.getAccountId()==accountid)
            {
              System.out.println("Account found in Fixed!");
                System.out.println(acc.getBalance());
                System.out.println(acc.getStatus());
                isfound=true;
                break;
            }
          }
        }
        
         if(!isfound) {
    	        System.out.println("This Acount Is not exist");
    		}
    }
    
    public static void searchAccountByType(SavingAccount[] saving,CurrentAccount[] current,FixedDepositeAccount[] fixed)
    {
        System.out.println("1.Saving Account");
        System.out.println("2.Current Account");
        System.out.println("3.Fixed Account");
        System.out.print("choose an account type : ");
        int choice=in.nextInt();
        
        switch(choice)
        {
            case 1:
                for(SavingAccount acc:saving)
                {
                    System.out.println(acc.getAccountId());
                    System.out.println(acc.getBalance());
                    System.out.println(acc.getStatus());
                    System.out.println(acc.getSuccessfultransaction());
                    System.out.println("Saving Account");
                }
                break;
            case 2:
                 for(CurrentAccount acc:current)
                {
                    System.out.println(acc.getAccountId());
                    System.out.println(acc.getBalance());
                    System.out.println(acc.getStatus());
                    System.out.println(acc.getSuccessfultransaction());
                    System.out.println("Current Account");
                }
                break;
            case 3:
                for(FixedDepositeAccount acc:fixed)
                {
                    System.out.println(acc.getAccountId());
                    System.out.println(acc.getBalance());
                    System.out.println(acc.getStatus());
                    System.out.println(acc.getSuccessfultransaction());
                    System.out.println("Fixed Account");
                }
            break;
        }
    }
    
    public static void closeAccount(SavingAccount[] saving,CurrentAccount[] current,FixedDepositeAccount[] fixed)
    {
      Account acc=validateaccount(saving, current, fixed);
      if(acc.getStatus()==AccountStatus.CLOSED)
      {
          System.out.println("The account is already closed");
          return;
      }
      if(acc.getBalance()!=0)
      {
          System.out.println("Account cannot be closed.");
        System.out.println("Balance must be exactly $0.");
        return;
      }
      
      if(acc instanceof FixedDepositeAccount)
      {
        FixedDepositeAccount fd = (FixedDepositeAccount) acc;
        if(fd.getPassedMonths()<fd.getMonths())
        {
            System.out.println("Fixed Account can not be closed because its not reach for its mutraity");
            return;
        }
        
      }
      
      acc.setStatus(AccountStatus.CLOSED);
      Customer cust=acc.getCustomer();
      if(cust!=null)
      {
        cust.setCustomerId(cust.getCustomerId()-1);
      }
      
       System.out.println("Account closed successfully.");
    }
    
    public static void showMenu() {
        System.out.println("1.Register new Customer");
        System.out.println("2.Open New account");
        System.out.println("3.Deposite Money");
        System.out.println("4.Withdraw Money");
        System.out.println("5.Transfer Between Accounts");
        System.out.println("6.Display Customer Accounts");
        System.out.println("7.Display All Branch Accounts");
        System.out.println("8.Search Account by Number");
        System.out.println("9.Search Accounts by Type");
        System.out.println("10.Close an Account");
        System.out.println("0.Exit");
        System.out.print("Enter Your choice: ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Customer[] customer = new Customer[10];
        Account[] account = new Account[10];
        SavingAccount[] savingAccount = new SavingAccount[10];
        CurrentAccount[] currentaccount = new CurrentAccount[10];
        FixedDepositeAccount[] fixed = new FixedDepositeAccount[10];

        int choice = 0;
        All:{
        while (true) {
            showMenu();
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    addcustomer(customer);
                    break;
                case 2:
                    addNewAccount(customer, savingAccount, currentaccount, fixed);
                    break;
                case 3:
                    deposite(savingAccount,currentaccount, fixed);
                    break;
                case 4:
                    withdraw(savingAccount, currentaccount, fixed);
                    break;
                    
                case 5:
                    TransverBetweenAccount(savingAccount, currentaccount, fixed);
                    break;
                case 6:
                    displayCustomerAccount(customer,savingAccount, currentaccount, fixed);
                    break;
                case 7:
                    displayBranchAccounts(savingAccount, currentaccount, fixed);
                    break;
                case 8:
                    searchAccountByid(savingAccount, currentaccount, fixed);
                    break;
                case 9:
                    searchAccountByType(savingAccount, currentaccount, fixed);
                    break;
                case 10:
                    closeAccount(savingAccount, currentaccount, fixed);
                    break;
                case 0:
                    break All;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    }
}
