package com.michael.simpleschoolmanagenentApp.repository;

import com.michael.simpleschoolmanagenentApp.entities.Course;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CourseRepository implements CommonRepository<Course> {
    
    private Map<String, Course> courses = new HashMap<>();

    @Override
    public Course save(Course domain) {
        Course result = courses.get(domain.getId());
        if(result != null){
            result.setUnits(domain.getUnits());
            result.setName(domain.getName());
            result.setDescription(domain.getDescription());
            domain = result;
        }
        courses.put(domain.getId(),domain);
        return courses.get(domain.getId());
    }

    @Override
    public Iterable<Course> save(Collection<Course> domains) {

        for(Course course: domains){
            courses.put(course.getId(),course);
        }
        return findAll();
    }

    @Override
    public void delete(Course domain) {
        courses.remove(domain);
    }

    @Override
    public Course findById(String id) {
        return courses.get(id);
    }

    @Override
    public Iterable<Course> findAll() {

        return courses.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
