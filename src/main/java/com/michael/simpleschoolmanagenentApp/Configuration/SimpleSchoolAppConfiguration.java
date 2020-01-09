package com.michael.simpleschoolmanagenentApp.Configuration;

import com.michael.simpleschoolmanagenentApp.formatters.CourseFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleSchoolAppConfiguration {

    @Bean
    public CourseFormatter courseFormatter(){
        return new CourseFormatter();
    }

}
