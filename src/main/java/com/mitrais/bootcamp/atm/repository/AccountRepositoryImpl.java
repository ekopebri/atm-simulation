package com.mitrais.bootcamp.atm.repository;

import com.mitrais.bootcamp.atm.entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private List<Account> data = new ArrayList<>();

    @Override
    public void batchData(List<Account> accounts) {
        data.addAll(accounts);
    }

    @Override
    public Account findByAccountNumberAndPin(String accountNumber, String pin) throws Exception {
        return data.stream()
                .filter(e -> e.getAccountNumber().equals(accountNumber) && e.getPin().equals(pin))
                .findFirst()
                .orElseThrow(() -> new Exception("Invalid Account Number/PIN"));
    }

    @Override
    public Account findByAccountNumber(String accountNumber) throws Exception {
        return data.stream()
                .filter(e -> e.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() ->new Exception("Invalid Account Number"));
    }

    @Override
    public Account reduceBalanceByAccountNumber(Long amount, Account account) {
        account.setBalance(account.getBalance() - amount);

        data = data.stream()
                .map(e -> {
                    if (e.getAccountNumber().equals(account.getAccountNumber())) {
                        return account;
                    }

                    return e;
                })
                .collect(Collectors.toList());

        return account;
    }

    @Override
    public Account increaseBalanceByAccountNumber(Long amount, Account account) {
        account.setBalance(account.getBalance() + amount);

        data = data.stream()
                .map(e -> {
                    if (e.getAccountNumber().equals(account.getAccountNumber())) {
                        return account;
                    }

                    return e;
                })
                .collect(Collectors.toList());

        return account;
    }
}
