package com.hms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.hms.controller"})
public class HMWebConfig {

    @Bean
    @Order(1)
    public HandlerMapping simpleUrlHandlerMapping() {
        final SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        final Properties mappings = new Properties();
        mappings.put("/locate-us.htm", "viewLocateUsController");
        handlerMapping.setMappings(mappings);
        return handlerMapping;
    }

    @Bean
    @Order(2)
    public HandlerMapping beanNameUrlHandlerMapping() {
        return new BeanNameUrlHandlerMapping();
    }

    @Bean
    public ViewResolver jspViewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
    }
}










