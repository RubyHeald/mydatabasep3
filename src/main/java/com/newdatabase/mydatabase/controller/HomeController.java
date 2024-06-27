package com.newdatabase.mydatabase.controller;

import com.newdatabase.mydatabase.model.Employee;
import com.newdatabase.mydatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

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

    @GetMapping("/employees/edit/{id}")
    public String showEditEmployeeForm(@PathVariable("id") Long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "editEmployee"; // Returns editEmployee.html
    }

    @PostMapping("/employees/edit/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute Employee employee) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employee.setId(id);
        employeeRepository.save(employee);
        return "redirect:/employees"; // Back to the employee list view
    }

    @GetMapping("/employees/find")
    public String showFindEmployeeForm() {
        return "findEmployee"; // Returns findEmployee.html
    }

    @PostMapping("/employees/find")
    public String findEmployee(@RequestParam("id") Long id, Model model) {
        Employee employee = employeeRepository.findById(id)
                .orElse(null);
        model.addAttribute("employee", employee);
        return "employeeDetails"; // Returns employeeDetails.html
    }
}

