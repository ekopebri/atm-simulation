package com.mitrais.bootcamp.atm.view;

import com.mitrais.bootcamp.atm.entity.Account;
import com.mitrais.bootcamp.atm.model.TransferRequest;
import com.mitrais.bootcamp.atm.util.InputUtil;

public class TransactionView {
    public void show(Account account) {
        System.out.println("1. Withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        String transactionInput = InputUtil.inputString("Please choose option[3]");
        switch (transactionInput.trim()) {
            case "":
            case "3":
                //
                break;
            case "1":
//                showWithDrawScreen(account);
                break;
            case "2":
//                showFundTransferScreen(new TransferRequest(account, new Account(), 0L, ""), 0L);
                break;
            default:
//                showTransactionScreen(account);
                break;
        }
    }
}
