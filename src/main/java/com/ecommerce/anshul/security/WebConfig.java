package com.ecommerce.anshul.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${frontend.url}")
    String frontEndUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String cleanUrl = frontEndUrl.endsWith("/") ? frontEndUrl.substring(0, frontEndUrl.length() - 1) : frontEndUrl;
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "http://localhost:5173", cleanUrl)
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
