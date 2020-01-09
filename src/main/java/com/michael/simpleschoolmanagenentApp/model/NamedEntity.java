package com.michael.simpleschoolmanagenentApp.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NamedEntity{

    @NotNull
    private String name;
    @NotNull
    private String description;

    public NamedEntity(String name, String description){
        this.name = name;
        this.description = description;
    }
}
