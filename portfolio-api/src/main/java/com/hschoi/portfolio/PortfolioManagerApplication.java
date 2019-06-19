package com.hschoi.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <pre>
 * com.hschoi.portfolio_PortfolioManagerApplication.java
 * </pre>
 * @date : 2019. 6. 14.
 * @author : hychoi
 */
@ComponentScan("com.hschoi")
@SpringBootApplication
public class PortfolioManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfolioManagerApplication.class, args);
	}
}
