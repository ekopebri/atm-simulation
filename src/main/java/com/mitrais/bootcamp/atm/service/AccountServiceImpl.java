package com.mitrais.bootcamp.atm.service;

import com.mitrais.bootcamp.atm.entity.Account;
import com.mitrais.bootcamp.atm.model.TransferRequest;
import com.mitrais.bootcamp.atm.model.TransferResponse;
import com.mitrais.bootcamp.atm.model.WithdrawResponse;
import com.mitrais.bootcamp.atm.repository.AccountRepository;
import com.mitrais.bootcamp.atm.util.DateUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void initialData() {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John Doe", "012108", 100L, "112233"));
        accounts.add(new Account("Jane Doe", "932012", 30L, "112244"));

        accountRepository.batchData(accounts);
    }

    @Override
    public boolean isAccountExist(String accountNumber) {
        try {
            accountRepository.findByAccountNumber(accountNumber);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Account getAccount(String accountNumber, String pin) {
        try {
            return accountRepository.findByAccountNumberAndPin(accountNumber, pin);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account getAccount(String accountNumber) {
        try {
            return accountRepository.findByAccountNumber(accountNumber);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public WithdrawResponse withdrawBalance(String type, Account account, Long amount) {
        WithdrawResponse response = new WithdrawResponse();
        LocalDateTime dateTime = LocalDateTime.now();
        response.setDate(DateUtil.parseLocalDateTimeToString(dateTime, "yyyy-MM-dd KK:mm a"));
        response.setAccountNumber(account);
        switch (type) {
            case "1":
                if (account.getBalance() >= 10) {
                    account = accountRepository.reduceBalanceByAccountNumber(10L, account);
                    response.setSuccess(true);
                    response.setWithdraw("$10");
                    response.setBalance("$" + account.getBalance() );

                    return response;
                }
                System.out.println("Insufficient balance $10");
                break;
            case "2":
                if (account.getBalance() >= 50) {
                    account = accountRepository.reduceBalanceByAccountNumber(50L, account);
                    response.setSuccess(true);
                    response.setWithdraw("$50");
                    response.setBalance("$" + account.getBalance());

                    return response;
                }
                System.out.println("Insufficient balance $50");
                break;
            case "3":
                if (account.getBalance() >= 100) {
                    account = accountRepository.reduceBalanceByAccountNumber(100L, account);
                    response.setSuccess(true);
                    response.setWithdraw("$100");
                    response.setBalance("$" + account.getBalance());

                    return response;
                }
                System.out.println("Insufficient balance $100");
                break;
            case "4":
                if (account.getBalance() >= amount) {
                    account = accountRepository.reduceBalanceByAccountNumber(amount, account);
                    response.setSuccess(true);
                    response.setWithdraw("$" + amount);
                    response.setBalance("$" + account.getBalance());

                    return response;
                }
                System.out.println("Insufficient balance $" + amount);
                break;
            default:
                break;
        }

        return response;
    }

    @Override
    public TransferResponse transferFunds(TransferRequest request) {
        TransferResponse response = new TransferResponse(
                request.getFrom(),
                request.getTo(),
                request.getAmount(),
                request.getReferenceNumber(),
                0L,
                false);

        Account fromAccount = request.getFrom();
        Account toAccount = request.getTo();
        if (fromAccount.getBalance() >= request.getAmount()) {
            fromAccount = accountRepository.reduceBalanceByAccountNumber(request.getAmount(), fromAccount);
            toAccount = accountRepository.increaseBalanceByAccountNumber(request.getAmount(), toAccount);
            response.setBalance(fromAccount.getBalance());
            response.setBalanceDestination(toAccount.getBalance());
            response.setSuccess(true);
        }

        return response;
    }
}
