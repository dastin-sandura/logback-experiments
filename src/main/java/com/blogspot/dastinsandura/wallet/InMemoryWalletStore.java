package com.blogspot.dastinsandura.wallet;

import com.blogspot.dastinsandura.wallet.Wallet;

import java.util.AbstractMap;
import java.util.Map;

public class InMemoryWalletStore {

    private static final Map<Integer, Wallet> WALLET_MAP = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(142, new Wallet(142)),
            new AbstractMap.SimpleEntry<>(274, new Wallet(274)),
            new AbstractMap.SimpleEntry<>(393, new Wallet(393))
    );

    public static Wallet getWalletById(Integer walletId) {
        Wallet wallet = WALLET_MAP.get(walletId);
        if (wallet == null) throw new RuntimeException(String.format("Wallet with id %d does not exist", walletId));
        return wallet;
    }
}
