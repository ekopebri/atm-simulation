package com.mitrais.bootcamp.atm.repository;

import com.mitrais.bootcamp.atm.entity.Account;

import java.util.List;

public interface AccountRepository {
    void batchData(List<Account> accounts);

    List<Account> getAll();

    Account findByAccountNumberAndPin(String accountNumber, String pin);

    Account findByAccountNumber(String accountNumber);

    void reduceBalanceByAccountNumber(Long amount, String accountNumber);

    void increaseBalanceByAccountNumber(Long amount, String to);
}
