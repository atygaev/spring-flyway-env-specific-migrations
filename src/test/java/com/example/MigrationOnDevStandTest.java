package com.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(properties = "STAND_NAME=dev")
class MigrationOnDevStandTest extends AbstractMigrationOnStandTest {

    @Test
    void onlyDevMigrationsExecuted() {
        List<String> settings = getSettings();

        Assertions.assertThat(settings).isNotEmpty();

        for (String setting : settings) {
            Assertions.assertThat(setting)
                    .contains("dev")
                    .doesNotContain("prod", "stage");
        }
    }
}
