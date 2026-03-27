package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() {
        log.info("Fetching all employees");
        return repo.findAll();
    }

    public Employee getById(Long id) {
        log.info("Fetching employee with id: {}", id);
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee create(EmployeeDTO dto) {
        log.info("Creating employee: {}", dto);

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());

        return repo.save(emp);
    }

    public Employee update(Long id, EmployeeDTO dto) {
        log.info("Updating employee with id: {}", id);

        Employee emp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());

        return repo.save(emp);
    }

    public void delete(Long id) {
        log.info("Deleting employee with id: {}", id);
        repo.deleteById(id);
    }
}