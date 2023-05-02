package com.blogspot.dastinsandura.account.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InMemoryAccountStore {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public InMemoryAccountStore() {
        logger.debug("Initializing account store in memory");
    }
}
