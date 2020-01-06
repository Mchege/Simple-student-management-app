package com.michael.simpleschoolmanagenentApp.controller;

import com.michael.simpleschoolmanagenentApp.entities.Course;
import com.michael.simpleschoolmanagenentApp.entities.Student;
import com.michael.simpleschoolmanagenentApp.repository.CourseRepository;
import com.michael.simpleschoolmanagenentApp.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    private Logger log = LoggerFactory.getLogger(StudentController.class);
    private StudentRepository repository;

    @Autowired
    private CourseRepository courseRepository;

    public StudentController(StudentRepository repository){
        this.repository = repository;
    }

    @ModelAttribute("courses")
    public Iterable<Course> populateCourses(){
        return courseRepository.findAll();
    }

    @ModelAttribute("students")
    public Iterable<Student> populateStudents(){
        return repository.findAll();
    }

    @GetMapping("/school/students")
    public String getStudents(final Student student){
        return "/school/students";

    }

    @RequestMapping(value="/school/students", params="saveStudent")
    public String addStudent(final Student student, final BindingResult result){
        if(result.hasErrors()){
            return "school/students";
        }
        repository.save(student);
        for(Student std: repository.findAll()){
            log.info(std.toString());
        }

        return "redirect:/school/students";

    }

}
