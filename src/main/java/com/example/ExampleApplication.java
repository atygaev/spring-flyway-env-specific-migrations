package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    @Autowired
    private SettingService settingService;

    @Value("${STAND_NAME:dev}")
    private String standName;

    @EventListener
    public void on(ApplicationStartedEvent event) {
        System.out.printf("[Settings] Stand: %s%n", standName);

        List<String> settingValues = settingService.getSettingValues();

        for (String settingValue : settingValues) {
            System.out.println("settingValue = " + settingValue);
        }
    }
}
