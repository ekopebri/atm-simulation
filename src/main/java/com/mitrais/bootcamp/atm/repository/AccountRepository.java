package com.mitrais.bootcamp.atm.repository;

import com.mitrais.bootcamp.atm.entity.Account;

import java.util.List;

public interface AccountRepository {
    void batchData(List<Account> accounts);

    List<Account> getAll();

    Account findByAccountNumberAndPin(String accountNumber, String pin);

    Account findByAccountNumber(String accountNumber);

    Account reduceBalanceByAccountNumber(Long amount, Account account);

    Account increaseBalanceByAccountNumber(Long amount, Account account);
}
