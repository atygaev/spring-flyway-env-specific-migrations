package com.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService {

    private final JdbcTemplate jdbcTemplate;

    public SettingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getSettingValues() {
        return jdbcTemplate.queryForList("SELECT v FROM app_settings ORDER BY k", String.class);
    }
}
