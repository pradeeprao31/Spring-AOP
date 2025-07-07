package com.vr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.vr.controller"})
public class VRWebConfig {

    /*@Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
        return viewResolver;
    }*/

    /*@Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }


    @Bean("our-mission")
    public View ourMissionView() {
        JstlView jstlView = new JstlView("/WEB-INF/jsp/our-mission.jsp");
        return jstlView;
    }*/

    @Bean
    public ViewResolver resourceBundleViewResolver() {
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
        viewResolver.setBasename("views");
        return viewResolver;
    }
}
