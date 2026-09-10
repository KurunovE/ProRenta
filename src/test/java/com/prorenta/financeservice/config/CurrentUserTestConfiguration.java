package com.prorenta.financeservice.config;

import com.prorenta.financeservice.security.CurrentUserProvider;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@TestConfiguration(proxyBeanMethods = false)
public class CurrentUserTestConfiguration {

    @Bean
    CurrentUserProvider currentUserProvider() {
        return () -> UUID.fromString("11111111-1111-1111-1111-111111111111");
    }
}
