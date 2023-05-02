package com.blogspot.dastinsandura.wallet;

public class WalletAggregate {

    public void setBalanceCommand(Integer walletId, Integer balance) {
        Wallet walletById = InMemoryWalletStore.getWalletById(walletId);
        System.out.println(String.format("Seeting balance of Wallet with ID %d to %d", walletId, balance));
        walletById.setBalance(balance);
    }
}
