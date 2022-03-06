package com.ceiba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DominiosValidos {
    @Bean
    public WebMvcConfigurer configuradorCors() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
//                Colocar los dominios permitidos para consumo
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }
}
