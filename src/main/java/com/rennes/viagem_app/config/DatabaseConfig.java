package com.rennes.viagem_app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ConfigurationProperties(prefix= "spring.datasource")
@Getter
@Setter
public class DatabaseConfig {
    private String url;
    private String username;
    private String password;
    private String driveClassName;

    @Bean
    public DataSource dataSource() {

        System.out.println(username);
        DataSource dataSource = DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driveClassName)
                .build();

        System.out.println("Database connected successfully: " );

        return dataSource;
    }
}
