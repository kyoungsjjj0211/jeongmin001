package com.thejoa703.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${file.upload-dir}")    
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { 
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadDir + "/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) { 
        registry.addMapping("/**")
                // ✅ 인증(JWT/Cookie)이 포함된 경우 allowedOrigins("*")는 작동하지 않습니다.
                // ✅ 반드시 프론트엔드 포트(3000)를 명시해야 합니다.
                .allowedOrigins("http://localhost:3000") 
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                // ✅ 프론트엔드에서 Authorization 헤더(JWT)를 읽거나 보내려면 필수입니다.
                .allowCredentials(true)
                .maxAge(3600);
    }
}