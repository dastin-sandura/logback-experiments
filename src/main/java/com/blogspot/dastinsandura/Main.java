package com.blogspot.dastinsandura;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.blogspot.dastinsandura.account.store.InMemoryAccountStore;
import com.blogspot.dastinsandura.wallet.Wallet;
import com.blogspot.dastinsandura.wallet.WalletAggregate;
import com.blogspot.dastinsandura.wallet.store.InMemoryWalletStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final int EXISTING_WALLET_ID = 142;

    private static final InMemoryWalletStore store = new InMemoryWalletStore();

    public static void main(String[] args) {
        manipulateLoggingLevelsExperiment();
        Logger logger = LoggerFactory.getLogger("com.blogspot.dastinsandura.Main");

        Wallet walletById = store.getWalletById(EXISTING_WALLET_ID);
//        System.out.printf("Hello Wallet with ID %d and balance %d!%n", walletById.getID(), walletById.getBalance());
        logger.debug(String.format("Hello Wallet with ID %d and balance %d!", walletById.getID(), walletById.getBalance()));
        WalletAggregate aggregate = new WalletAggregate();

        aggregate.setBalanceCommand(EXISTING_WALLET_ID, 998);
//        System.out.printf("Hello again Wallet with ID %d and balance %d!%n", walletById.getID(), walletById.getBalance());

//        printLogbackLoggerState();
        shouldRetrieveExistingWallet();

        InMemoryAccountStore accountStore = new InMemoryAccountStore();
    }

    private static void manipulateLoggingLevelsExperiment() {
        ch.qos.logback.classic.Logger comBlogspotLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.blogspot");
        ch.qos.logback.classic.Logger accountLogger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.blogspot.dastinsandura.account");
        comBlogspotLogger.setLevel(Level.ERROR);
        accountLogger.setLevel(Level.DEBUG);
    }

    private static void printLogbackLoggerState() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }

    private static void shouldRetrieveExistingWallet() {

        Wallet walletById = store.getWalletById(142);

//        System.out.println(String.format("Hello Wallet with ID %d!", walletById.getID()));
    }

    private static void shouldThrowDueToNonExistingWallet() {
        Wallet walletById = store.getWalletById(1142);

//        System.out.println(String.format("Hello Wallet with ID %d!", walletById.getID()));
    }
}