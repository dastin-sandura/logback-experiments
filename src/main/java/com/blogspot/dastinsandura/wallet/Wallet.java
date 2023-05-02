package com.blogspot.dastinsandura.wallet;

public class Wallet {

    private Integer ID;
    private Integer balance = 0;

    Wallet(Integer ID) {
        this.ID = ID;
    }

    public Integer getID() {
        return ID;
    }

    void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getBalance() {
        return balance;
    }

    void setBalance(Integer balance) {
        this.balance = balance;
    }
}
