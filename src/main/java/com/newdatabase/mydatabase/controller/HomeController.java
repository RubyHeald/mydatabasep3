package com.newdatabase.mydatabase.controller;

import com.newdatabase.mydatabase.model.Employee;
import com.newdatabase.mydatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Executor;

@Controller
public class HomeController {

//    private static final Runnable ALTER =  ;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public String getEmployeeList(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees"; // Returns employees.html
    }

    @GetMapping("/")
    public String home() {
        return "index"; // returns index.html
    }

    @GetMapping("/employees/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee"; // Returns addEmployee.html
    }

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees"; // Back to the employee list view
    }
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/employees"; // Back to the employee list view
    }
}


