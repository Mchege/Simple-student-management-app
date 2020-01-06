package com.michael.simpleschoolmanagenentApp.controller;

import com.michael.simpleschoolmanagenentApp.entities.Course;
import com.michael.simpleschoolmanagenentApp.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    private CourseRepository repository;
    Logger log = LoggerFactory.getLogger(CourseController.class);

    public CourseController(CourseRepository repository){
        this.repository = repository;
    }

    @ModelAttribute("courses")
    public Iterable<Course> populateCourses(){
        return repository.findAll();
    }

    @GetMapping("/school/courses")
    public String getCourses(final Course course){
        return "school/courses";
    }

    @RequestMapping(value="/school/courses", params={"saveCourse"})
    public String saveCourse(final Course course, final BindingResult result){
        if(result.hasErrors()){
            log.info(result.toString());
            return "school/courses";
        }

        repository.save(course);
        for(Course c: repository.findAll()){
            log.info(c.toString());
        }
        return "redirect:/school/courses";

    }

    @RequestMapping(value="/school/courses", params={"addUnit"})
    public String addUnit(final Course course, final BindingResult result){
        course.getUnits().add("");
        return "school/courses";

    }

    @RequestMapping(value="/school/courses", params = {"removeUnit"})
    public String removeUnit(final Course course, final BindingResult result, @RequestParam(value="removeUnit",required = false) Integer unitId){
        course.getUnits().remove(unitId.intValue());
        return "school/courses";
    }
}
