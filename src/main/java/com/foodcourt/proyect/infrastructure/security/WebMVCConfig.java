package com.foodcourt.proyect.infrastructure.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("admin");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/restaurant").setViewName("owner");
        registry.addViewController("/plate").setViewName("owner");
    }

}
