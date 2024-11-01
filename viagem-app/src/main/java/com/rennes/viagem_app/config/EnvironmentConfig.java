package com.rennes.viagem_app.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentConfig {
    private final Dotenv dotenv;

    public EnvironmentConfig() {
        this.dotenv = Dotenv.load();
    }

    public String getDbUrl() { return dotenv.get("DB_URL"); }

    public String getDbName() {
        return dotenv.get("DB_NAME");
    }

    public String getDbUser() {
        return dotenv.get("DB_USER");
    }

    public String getDbPassword() {
        return dotenv.get("DB_PASSWORD");
    }
}
