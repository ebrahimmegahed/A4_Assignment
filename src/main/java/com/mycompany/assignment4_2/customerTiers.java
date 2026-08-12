/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.assignment4_2;

/**
 *
 * @author GAAMA
 */
public enum customerTiers {
    STANDARD(5,1.5),
    SILVER(10,2),
    GOLD(15,2.5);
    private double monthFee,intersetRate;

    private customerTiers(double monthFee,double intersetRate) {
        this.monthFee=monthFee;
        this.intersetRate=intersetRate;
    }
    
    
}
