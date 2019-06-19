package com.hschoi.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <pre>
 * com.hschoi.portfolio.config_WebSecurityConfig.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
