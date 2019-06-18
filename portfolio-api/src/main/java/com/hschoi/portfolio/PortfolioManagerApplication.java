package com.hschoi.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <pre>
 * com.hschoi.portfolio_PortfolioManagerApplication.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */

@Configuration
@ComponentScan(basePackages="com.hschoi.common")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.hschoi.common")
@EntityScan(basePackages="com.hschoi.*")
//@SpringBootApplication
public class PortfolioManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfolioManagerApplication.class, args);
	}
}
