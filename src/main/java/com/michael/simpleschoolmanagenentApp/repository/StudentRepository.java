package com.michael.simpleschoolmanagenentApp.repository;

import com.michael.simpleschoolmanagenentApp.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepository implements CommonRepository<Student> {

    private Map<String, Student> students = new HashMap<>();

    @Override
    public Student save(Student domain) {
        Student std = students.get(domain.getId());
        if(std != null){
            std.setExpectedCompletionDate(domain.getExpectedCompletionDate());
            domain = std;
        }

        students.put(domain.getId(),domain);
        return students.get(domain.getId());
    }

    @Override
    public Iterable<Student> save(Collection<Student> domains) {
        domains.forEach(this::save);
        return findAll();
    }

    @Override
    public void delete(Student domain) {
        students.remove(domain.getId());
    }

    @Override
    public Student findById(String id) {
        return students.get(id);
    }

    @Override
    public Iterable<Student> findAll() {
        return students.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
