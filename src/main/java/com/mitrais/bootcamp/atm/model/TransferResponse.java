package com.mitrais.bootcamp.atm.model;

public class TransferResponse {
    private String from;
    private String to;
    private Long amount;
    private String referenceNumber;
    private Long balance;
    private Boolean success;

    public TransferResponse(String from, String to, Long amount, String referenceNumber, Long balance, Boolean success) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.balance = balance;
        this.success = success;
    }

    public TransferResponse() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
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

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
