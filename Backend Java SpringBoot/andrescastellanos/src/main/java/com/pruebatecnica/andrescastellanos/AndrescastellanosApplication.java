package com.pruebatecnica.andrescastellanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AndrescastellanosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndrescastellanosApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                String origin = "*";
                registry.addMapping("/**").allowedHeaders("Authorization", "Accept", "Content-Type", "Referer", "User-Agent").allowedOrigins(origin).allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE");
            }
        };
    }
}
