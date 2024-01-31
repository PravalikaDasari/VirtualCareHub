package com.virtualcare.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableJpaRepositories(basePackages = {"com.virtualcare.bean","com.virtualcare.repository"})
@EnableTransactionManagement
@EnableWebMvc
public class JpaConfig {

}
