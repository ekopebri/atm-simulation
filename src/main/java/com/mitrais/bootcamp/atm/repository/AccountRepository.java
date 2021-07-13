package com.mitrais.bootcamp.atm.repository;

import com.mitrais.bootcamp.atm.entity.Account;

import java.util.List;

public interface AccountRepository {
    void batchData(List<Account> accounts);

    Account findByAccountNumberAndPin(String accountNumber, String pin) throws Exception;

    Account findByAccountNumber(String accountNumber) throws Exception;

    Account reduceBalanceByAccountNumber(Long amount, Account account);

    Account increaseBalanceByAccountNumber(Long amount, Account account);
}
