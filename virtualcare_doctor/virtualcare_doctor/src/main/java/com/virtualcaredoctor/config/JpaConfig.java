package com.virtualcaredoctor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.virtualcaredoctor.bean","com.virtualcaredoctor.repository"})
@EnableTransactionManagement
public class JpaConfig {

}