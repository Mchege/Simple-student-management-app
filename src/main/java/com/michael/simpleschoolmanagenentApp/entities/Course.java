package com.michael.simpleschoolmanagenentApp.entities;

import com.michael.simpleschoolmanagenentApp.model.NamedEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Course extends NamedEntity {

    @NotNull
    private String id;

    private List<String> units = new ArrayList<>();

    public Course(String name, String description){
        super(name,description);
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString(){
        return  "Id = "+ this.getId()+", Name = "+ this.getName()+ ", Description = "+this.getDescription()+", "+ this.getUnits();
    }


}
