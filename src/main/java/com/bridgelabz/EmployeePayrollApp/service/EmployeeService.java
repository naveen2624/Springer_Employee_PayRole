package com.bridgelabz.EmployeePayrollApp.service;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Employee create(Employee emp) {
        return repo.save(emp);
    }

    public Employee update(Long id, Employee emp) {
        Employee e = repo.findById(id).orElseThrow();
        e.setName(emp.getName());
        e.setSalary(emp.getSalary());
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}