package com.scurtis.recruits.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Author: Steve Curtis
 * Date: Nov 26, 2020
 **/

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource(PostgresJdbcProperties postgresJdbcProperties) {
        return DataSourceBuilder.create()
                .url(postgresJdbcProperties.getUrl())
                .username(postgresJdbcProperties.getUsername())
                .password(postgresJdbcProperties.getPassword())
                .build();
    }

}
