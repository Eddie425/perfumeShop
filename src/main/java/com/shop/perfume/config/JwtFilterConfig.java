package com.shop.perfume.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterConfig {

  @Bean
  public FilterRegistrationBean<JwtRequestFilter> jwtFilter() {
    FilterRegistrationBean<JwtRequestFilter> bean = new FilterRegistrationBean<>();
    bean.setFilter(new JwtRequestFilter());
    bean.addUrlPatterns("/perfume/**");
    bean.setName("JwtRequestFilter");
    return bean;
  }
}
