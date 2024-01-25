package com.virtualcare_registartionAndLogin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.virtualcare_registartionAndLogin.bean","com.virtualcare_registartionAndLogin.repository"})
@EnableTransactionManagement
public class JpaConfig {

}