package com.mitrais.bootcamp.atm.model;

import com.mitrais.bootcamp.atm.entity.Account;

public class TransferRequest {
    private Account from;
    private Account to;
    private Long amount;
    private String referenceNumber;

    public TransferRequest(Account from, Account to, Long amount, String referenceNumber) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
    }

    public TransferRequest() {
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
}
