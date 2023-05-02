package com.blogspot.dastinsandura.account;

public class Account {

    private Integer ID;

    private Integer transactionCounter = 0;

    public Account(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getTransactionCounter() {
        return transactionCounter;
    }

    public void setTransactionCounter(Integer transactionCounter) {
        this.transactionCounter = transactionCounter;
    }
}
