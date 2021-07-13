package com.mitrais.bootcamp.atm.model;

import com.mitrais.bootcamp.atm.entity.Account;

public class TransferResponse {
    private Account from;
    private Account to;
    private Long amount;
    private String referenceNumber;
    private Long balance;
    private Long balanceDestination;
    private Boolean success;

    public TransferResponse(Account from, Account to, Long amount, String referenceNumber, Long balance,  Boolean success) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.balance = balance;
        this.success = success;
    }

    public TransferResponse() {
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getBalanceDestination() {
        return balanceDestination;
    }

    public void setBalanceDestination(Long balanceDestination) {
        this.balanceDestination = balanceDestination;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
