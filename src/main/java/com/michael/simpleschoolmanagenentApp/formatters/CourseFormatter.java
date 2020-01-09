package com.michael.simpleschoolmanagenentApp.formatters;

import com.michael.simpleschoolmanagenentApp.entities.Course;
import com.michael.simpleschoolmanagenentApp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CourseFormatter implements Formatter<Course> {
    @Autowired
    private CourseRepository repository;

    public CourseFormatter() {
        super();
    }

    @Override
    public Course parse(String text, Locale locale) throws ParseException {
        return repository.findById(text);
    }

    @Override
    public String print(Course object, Locale locale) {
        return (object != null? object.getId(): "");
    }
}
