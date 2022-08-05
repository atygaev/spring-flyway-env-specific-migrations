package com.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(properties = "STAND_NAME=prod")
class MigrationOnProdStandTest extends AbstractMigrationOnStandTest {

    @Test
    void onlyProdMigrationsExecuted() {
        List<String> settings = getSettings();

        Assertions.assertThat(settings).isNotEmpty();

        for (String setting : settings) {
            Assertions.assertThat(setting)
                    .contains("prod")
                    .doesNotContain("dev", "stage");
        }
    }
}
