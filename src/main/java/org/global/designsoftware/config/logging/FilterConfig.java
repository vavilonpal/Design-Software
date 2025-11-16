package org.global.designsoftware.config.logging;


import org.global.designsoftware.patterns.properties_lab.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {


   /* @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter(){
        FilterRegistrationBean<LoggingFilter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new LoggingFilter());
        filterRegistrationBean.addUrlPatterns("/api/v1/movie");

        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;

    }*/


}
