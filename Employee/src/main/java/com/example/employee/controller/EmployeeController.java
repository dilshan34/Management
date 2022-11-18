package com.example.employee.controller;

import com.example.employee.response.EmployeeResponse;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{id}")
     public ResponseEntity<EmployeeResponse>  getEmployees(@PathVariable("id") int id){

        EmployeeResponse employeeResponse = employeeService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);

    }

}
