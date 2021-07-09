package com.mitrais.bootcamp.atm.model;

public class TransferRequest {
    private String from;
    private String to;
    private Long amount;
    private String referenceNumber;

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public TransferRequest(String from, String to, Long amount, String referenceNumber) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
    }

    public TransferRequest() {
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
}
