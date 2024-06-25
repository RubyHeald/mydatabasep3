package com.newdatabase.mydatabase.repository;

import com.newdatabase.mydatabase.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

