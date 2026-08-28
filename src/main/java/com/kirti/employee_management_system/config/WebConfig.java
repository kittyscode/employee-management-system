package com.kirti.employee_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import org.springframework.beans.factory.annotation.Value;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
            .addResourceHandler("/api/uploads/profile/**")   // add /api prefix
            .addResourceLocations("file:" + uploadDir + "/");
    }
   @Bean
public CorsFilter corsFilter() {

    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowCredentials(true);
    configuration.addAllowedOrigin("http://localhost:5173");
    configuration.addAllowedOrigin("https://employee-management-system-frontend-ruddy.vercel.app"); // your actual Vercel frontend URL
    configuration.addAllowedHeader("*");
    configuration.addAllowedMethod("*");

    UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return new CorsFilter(source);
}

  

}