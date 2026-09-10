package com.prorenta.financeservice;

import com.prorenta.financeservice.config.CurrentUserTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Import(CurrentUserTestConfiguration.class)
class FinanceServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
