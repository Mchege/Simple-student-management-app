package com.michael.simpleschoolmanagenentApp.entities;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Student {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    private String firstName;
    private String lastName;

    private LocalDateTime admissionDate;
    private LocalDateTime expectedCompletionDate;
    private Course course;

    public Student(){
        this.id = UUID.randomUUID().toString();
        LocalDateTime now = LocalDateTime.now();
        this.admissionDate = now;
    }

    public Student(String firstName, String lastName){
        this();
        this.lastName = lastName;
        this.firstName = firstName;
    }


    @Override
    public String toString(){

        return "["+this.id +" ," +this.firstName +" , "+this.lastName+" ]";

    }


}
