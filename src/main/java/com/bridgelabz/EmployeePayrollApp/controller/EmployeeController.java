package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public Employee get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Employee create(@Valid @RequestBody EmployeeDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Employee Deleted Successfully";
    }
}