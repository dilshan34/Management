package com.example.employee.repository;

import com.example.employee.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <EmployeeEntity,Integer>{
}
