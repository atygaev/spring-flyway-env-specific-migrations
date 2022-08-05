package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

abstract class AbstractMigrationOnStandTest {

    @Autowired
    private SettingService settingService;

    protected List<String> getSettings() {
        return settingService.getSettingValues();
    }
}
