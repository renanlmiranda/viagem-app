package com.rennes.viagem_app.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class DatabaseConfig {
    private final EnvironmentConfig environmentConfig;

    public DatabaseConfig(EnvironmentConfig environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(environmentConfig.getDbUrl() + environmentConfig.getDbName())
                .username(environmentConfig.getDbUser())
                .password(environmentConfig.getDbPassword())
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
