package com.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(properties = "STAND_NAME=stage")
class MigrationOnStageStandTest extends AbstractMigrationOnStandTest {

    @Test
    void onlyStageMigrationsExecuted() {
        List<String> settings = getSettings();

        Assertions.assertThat(settings).isNotEmpty();

        for (String setting : settings) {
            Assertions.assertThat(setting)
                    .contains("stage")
                    .doesNotContain("dev", "prod");
        }
    }
}
