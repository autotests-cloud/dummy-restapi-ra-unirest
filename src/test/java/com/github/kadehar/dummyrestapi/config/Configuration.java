package com.github.kadehar.dummyrestapi.config;

import org.aeonbits.owner.ConfigFactory;

public class Configuration {
    public static APIConfig configureAPI() {
        return ConfigFactory.create(APIConfig.class);
    }
}
