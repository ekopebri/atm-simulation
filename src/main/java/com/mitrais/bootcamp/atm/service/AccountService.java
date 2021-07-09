package com.mitrais.bootcamp.atm.service;

import com.mitrais.bootcamp.atm.entity.Account;
import com.mitrais.bootcamp.atm.model.TransferRequest;
import com.mitrais.bootcamp.atm.model.TransferResponse;
import com.mitrais.bootcamp.atm.model.WithdrawResponse;

public interface AccountService {
    void initialData();

    void showAccountList();

    boolean isAccountExist(String accountNumber);

    Account getAccount(String accountNumber, String pin);

    WithdrawResponse withdrawBalance(String type, String accountNumber, Long amount);

    TransferResponse transferFunds(TransferRequest request);
}
