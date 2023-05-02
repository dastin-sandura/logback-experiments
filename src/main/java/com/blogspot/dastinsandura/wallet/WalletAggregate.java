package com.blogspot.dastinsandura.wallet;

import com.blogspot.dastinsandura.wallet.store.InMemoryWalletStore;

public class WalletAggregate {

    private static final InMemoryWalletStore store = new InMemoryWalletStore();

    public void setBalanceCommand(Integer walletId, Integer balance) {
        Wallet walletById = store.getWalletById(walletId);
//        System.out.println(String.format("Seeting balance of Wallet with ID %d to %d", walletId, balance));
        walletById.setBalance(balance);
    }
}
