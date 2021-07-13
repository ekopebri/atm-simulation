package com.mitrais.bootcamp.atm.model;

import com.mitrais.bootcamp.atm.entity.Account;

import java.time.LocalDateTime;

public class WithdrawResponse {
    private Account account;
    private String date;
    private String withdraw;
    private String balance;
    private Boolean success;

    public WithdrawResponse(Account account, String date, String withdraw, String balance, Boolean isSuccess) {
        this.account = account;
        this.date = date;
        this.withdraw = withdraw;
        this.balance = balance;
        this.success = isSuccess;
    }

    public WithdrawResponse() {
    }

    public Account getAccountNumber() {
        return account;
    }

    public void setAccountNumber(Account account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(String withdraw) {
        this.withdraw = withdraw;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
