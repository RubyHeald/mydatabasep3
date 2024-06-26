package com.newdatabase.mydatabase.controller;

import com.newdatabase.mydatabase.model.Employee;
import com.newdatabase.mydatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/employees")
@Controller
public class EmployeeController {

    @Autowired
    private final EmployeeRepository repository;

    //constructor parameter

    public EmployeeController (EmployeeRepository repository){
        this.repository = repository;
    }
//    @GetMapping ()
//    public List<Employee> findAll(){
//        return repository.findAll();
//    }
}
