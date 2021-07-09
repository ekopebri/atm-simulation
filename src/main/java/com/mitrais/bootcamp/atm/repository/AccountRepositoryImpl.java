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
    public List<Account> getAll() {
        return data;
    }

    @Override
    public Account findByAccountNumberAndPin(String accountNumber, String pin) {
        return data.stream()
                .filter(e -> e.getAccountNumber().equals(accountNumber) && e.getPin().equals(pin))
                .collect(Collectors.toList())
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return data.stream()
                .filter(e -> e.getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList())
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public void reduceBalanceByAccountNumber(Long amount, String accountNumber) {
        data = data.stream()
                .map(e -> {
                    if (e.getAccountNumber().equals(accountNumber)) {
                        e.setBalance(e.getBalance() - amount);
                    }

                    return e;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void increaseBalanceByAccountNumber(Long amount, String accountNumber) {
        data = data.stream()
                .map(e -> {
                    if (e.getAccountNumber().equals(accountNumber)) {
                        e.setBalance(e.getBalance() + amount);
                    }

                    return e;
                })
                .collect(Collectors.toList());
    }
}
