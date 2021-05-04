package com.zelger.sbs;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class Controller {

    List<Customer> customerList = new ArrayList<Customer>();

    @RequestMapping(value ="/customerName", method = RequestMethod.POST)
    public Customer postAccount(@RequestParam String customerName){
        Customer current = new Customer();
        current.setCustomer(customerName);
        customerList.add(current);
        return current;
    }

    @RequestMapping(value = "/accountNumber/deposit", method = RequestMethod.POST)
    public Customer postDeposit(@RequestParam int accountNumber, @RequestParam double deposit){
        Customer current = new Customer();
        Customer find = new Customer();
        for(int i = 0; i < customerList.size(); i++){
            find = customerList.get(i);
            if(find.getAccountNumber() == accountNumber){
                current = find;
            }
        }

        current.deposit(deposit);
        return current;
    }

    @RequestMapping(value = "/accountNumber/withdrawal", method = RequestMethod.POST)
    public Customer postWithdrawal(@RequestParam int accountNumber, @RequestParam double withdrawal){
        Customer current2 = new Customer();
        Customer find2 = new Customer();
        for(int i = 0; i < customerList.size(); i++){
            find2 = customerList.get(i);
            if(find2.getAccountNumber() == accountNumber){
                current2 = find2;
            }
        }

        current2.withdraw(withdrawal);
        return current2;
    }


    @RequestMapping(value ="/accountNumber", method = RequestMethod.GET)
    public Customer getAccount(@RequestParam int accountNumber){
        Customer current3 = new Customer();
        Customer find3 = new Customer();
        for(int i = 0; i < customerList.size(); i++){
            find3 = customerList.get(i);
            if(find3.getAccountNumber() == accountNumber){
                current3 = find3;
            }
        }

        return current3;
    }



}
