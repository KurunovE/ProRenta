package com.prorenta.financeservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

/** Заглушка для локальной разработки: все запросы относятся к одному пользователю. */
@Component
@Profile("local & !prod")
public class LocalCurrentUserProvider implements CurrentUserProvider {

    private final UUID userId;

    public LocalCurrentUserProvider(@Value("${app.current-user.id}") UUID userId) {
        this.userId = userId;
    }

    @Override
    public UUID getCurrentUserId() {
        return userId;
    }
}
