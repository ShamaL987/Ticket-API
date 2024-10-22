package com.example.oopcw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all paths
                .allowedOrigins("*")  // Allow any origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow all methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(false);  // Do not allow credentials (if '*' for origins)
    }
}
