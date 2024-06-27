package com.newdatabase.mydatabase.controller;
import com.newdatabase.mydatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

    @Autowired
    private final EmployeeRepository repository;

    //constructor parameter

    public EmployeeController (EmployeeRepository repository){
        this.repository = repository;
    }
}
