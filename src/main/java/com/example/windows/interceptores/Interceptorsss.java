package com.example.windows.interceptores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptorsss implements HandlerInterceptor {

    public boolean preHandler(HttpServletRequest httpServletRequest, HttpServletResponse
    httpServletResponse ,Object object){
   System.out.print("Interceptor before hanlder exuctions" +httpServletRequest.getRequestURI());
        return  true;

    }
    public void postHandler(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse ,Object object){
        System.out.print("Interceptor after hanlder excutions" +httpServletRequest.getRequestURI());
    }
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse ,Object object,Exception exception){
        System.out.print("Interceptor after complete request" +httpServletRequest.getRequestURI());

    }



}
