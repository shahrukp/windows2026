package com.example.windows.interceptores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfing implements WebMvcConfigurer {

    @Autowired
    private Interceptorsss myinterceptorsss;


    public void addInterCeptor(InterceptorRegistry registry){

        registry.addInterceptor(myinterceptorsss)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/fetch");

    }


}
