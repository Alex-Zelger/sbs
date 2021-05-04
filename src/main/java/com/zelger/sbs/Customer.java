package com.zelger.sbs;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class Customer {
    private String customerName;
    private String createdDate;
    private int accountNumber;
    private double balance;


    public void setCustomer(String cn){
        customerName = cn;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        createdDate = formatter.format(date);
        Random rnd = new Random();
        int n = 1000000 + rnd.nextInt(9000000);
        accountNumber = n;
        balance = 0;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

}
