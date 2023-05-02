package com.blogspot.dastinsandura;

import com.blogspot.dastinsandura.wallet.InMemoryWalletStore;
import com.blogspot.dastinsandura.wallet.Wallet;
import com.blogspot.dastinsandura.wallet.WalletAggregate;

public class Main {

    private static final int EXISTING_WALLET_ID = 142;

    public static void main(String[] args) {
        Wallet walletById = InMemoryWalletStore.getWalletById(EXISTING_WALLET_ID);
        System.out.printf("Hello Wallet with ID %d and balance %d!%n", walletById.getID(), walletById.getBalance());

        WalletAggregate aggregate = new WalletAggregate();

        aggregate.setBalanceCommand(EXISTING_WALLET_ID, 998);
        System.out.printf("Hello again Wallet with ID %d and balance %d!%n", walletById.getID(), walletById.getBalance());
    }

    private static void shouldRetrieveExistingWallet() {
        Wallet walletById = InMemoryWalletStore.getWalletById(142);

        System.out.println(String.format("Hello Wallet with ID %d!", walletById.getID()));
    }

    private static void shouldThrowDueToNonExistingWallet() {
        Wallet walletById = InMemoryWalletStore.getWalletById(1142);

        System.out.println(String.format("Hello Wallet with ID %d!", walletById.getID()));
    }
}