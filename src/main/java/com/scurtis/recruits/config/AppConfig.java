package com.scurtis.recruits.config;

import com.scurtis.recruits.dto.CollegeRepository;
import com.scurtis.recruits.dto.UserAccountRepository;
import com.scurtis.recruits.storage.CollegeDataAccess;
import com.scurtis.recruits.storage.UserAccountDataAccess;
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

    @Bean
    public CollegeDataAccess collegeDataAccess(CollegeRepository repository) {
        return new CollegeDataAccess(repository);
    }

    @Bean
    public UserAccountDataAccess userAccountDataAccess(UserAccountRepository repository) {
        return new UserAccountDataAccess(repository);
    }

}
