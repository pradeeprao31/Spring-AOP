package com.aw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.aw.controller"})
public class WebConfig {

    @Bean
    public HandlerMapping handlerMapping() {
        final SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        final Properties mappings = new Properties();
        mappings.put("/about-us.htm", "viewAboutusController");
        handlerMapping.setMappings(mappings);

        return handlerMapping;
    }

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
        return viewResolver;
    }
}
