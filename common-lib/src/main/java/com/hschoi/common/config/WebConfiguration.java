package com.hschoi.common.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

/**
 * <pre>
 * com.hschoi.common.config_WebConfiguration.java
 * </pre>
 * @date : 2019. 6. 18.
 * @author : hychoi
 */

@Configuration
public class WebConfiguration {	
	
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
        resolver.setOneIndexedParameters(true);
        resolver.setMaxPageSize(5);
        argumentResolvers.add(resolver);
    }
}
