package com.prorenta.financeservice.security;

import java.util.UUID;

public interface CurrentUserProvider {
    UUID getCurrentUserId();
}
