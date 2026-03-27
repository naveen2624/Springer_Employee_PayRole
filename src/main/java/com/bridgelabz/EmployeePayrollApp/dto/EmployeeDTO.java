package com.bridgelabz.EmployeePayrollApp.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 1000, message = "Salary must be >= 1000")
    private double salary;
}