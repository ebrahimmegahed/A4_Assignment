/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment4_2;

/**
 *
 * @author GAAMA
 */
public class Customer {
    private String fullName;
    private String phoneNumber;
    private int nationalId;
    private customerTiers tier;
    private   int customerId;
    private static int nextCustomer=101;

    public Customer(String fullName, String phoneNumber, int nationalId, customerTiers tier) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.nationalId = nationalId;
        this.tier = tier;
        customerId=nextCustomer++;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public customerTiers getTier() {
        return tier;
    }

    public void setTier(customerTiers tier) {
        this.tier = tier;
    }
    
    
}
