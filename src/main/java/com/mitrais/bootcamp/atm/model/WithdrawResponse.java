package com.mitrais.bootcamp.atm.model;

import java.time.LocalDateTime;

public class WithdrawResponse {
    private String accountNumber;
    private String date;
    private String withdraw;
    private String balance;
    private Boolean success;

    public WithdrawResponse(String accountNumber, String date, String withdraw, String balance, Boolean isSuccess) {
        this.accountNumber = accountNumber;
        this.date = date;
        this.withdraw = withdraw;
        this.balance = balance;
        this.success = isSuccess;
    }

    public WithdrawResponse() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
