package com.virtualcaredoctor.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.virtualcaredoctor.repository","com.virtualcaredoctor.entity","com.virtualcaredoctor.repository"})
@EnableTransactionManagement
@EntityScan("com.virtualcaredoctor.*") 
public class JpaConfig {

}