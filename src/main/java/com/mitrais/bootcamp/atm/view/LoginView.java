package com.mitrais.bootcamp.atm.view;

import com.mitrais.bootcamp.atm.entity.Account;
import com.mitrais.bootcamp.atm.service.AccountService;
import com.mitrais.bootcamp.atm.util.InputUtil;
import com.mitrais.bootcamp.atm.util.ValidationUtil;

public class LoginView {
    public void show(AccountService accountService) {

        while (true) {
            String accountNumber = InputUtil.inputString("Enter Account Number");
            String pin = InputUtil.inputString("Enter PIN");

            if (ValidationUtil.checkAccount(accountNumber, pin)) {
                Account account = accountService.getAccount(accountNumber, pin);
                if (account != null) {
//                    showTransactionScreen(account);
                } else {
                    System.out.println("Invalid Account Number/PIN");
                }
            }
        }
    }
}
