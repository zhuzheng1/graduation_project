//package com.zt.houtai.config;
//
//import com.zt.houtai.interceptor.LoginInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//@Component
//@Configuration
//public class InterceptorConfig extends WebMvcConfigurationSupport {
//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        // 多个拦截器组成一个拦截器链
//        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
//        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/static/**","/login.html","/login_admin/login");
//    }
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//
//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login.html").setViewName("login");
//        registry.addViewController("/index.html").setViewName("index");
//        super.addViewControllers(registry);
//    }
//}
