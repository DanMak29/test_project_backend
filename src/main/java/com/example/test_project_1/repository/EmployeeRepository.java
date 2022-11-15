package com.example.test_project_1.repository;

import com.example.test_project_1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
}
