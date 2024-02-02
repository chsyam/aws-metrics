package com.metrics.cpuMetrics.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/metrics/cpu/i-0d4d918b210c62bd6")
                .allowedOrigins("http://localhost:3001", "http://10.63.32.133:3001")
                .allowedMethods("GET")
                .allowCredentials(true);
    }
}