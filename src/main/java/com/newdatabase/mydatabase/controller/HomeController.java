package com.newdatabase.mydatabase.controller;

import com.newdatabase.mydatabase.model.Employee;
import com.newdatabase.mydatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String getEmployeeList(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        System.out.println("Hello");
        return "employees"; // This returns the employee.html template
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}

