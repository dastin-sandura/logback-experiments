package com.blogspot.dastinsandura.wallet.store;

import com.blogspot.dastinsandura.wallet.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.Map;

public class InMemoryWalletStore {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final Map<Integer, Wallet> WALLET_MAP = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(142, new Wallet(142)),
            new AbstractMap.SimpleEntry<>(274, new Wallet(274)),
            new AbstractMap.SimpleEntry<>(393, new Wallet(393))
    );

    public Wallet getWalletById(Integer walletId) {

        Wallet wallet = WALLET_MAP.get(walletId);
        if (wallet == null) {
            String errorMessage = String.format("Wallet with id %d does not exist", walletId);
            logger.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        logger.info(String.format("Retrieving Wallet with id %d", walletId));
        return wallet;
    }
}
