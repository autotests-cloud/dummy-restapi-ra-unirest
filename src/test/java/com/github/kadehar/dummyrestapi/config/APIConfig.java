package com.github.kadehar.dummyrestapi.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface APIConfig extends Config {
    @Key("api.base.url")
    String baseUrl();
    @Key("api.base.path")
    String basePath();
}
