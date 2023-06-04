package com.example.SpringProject.Controller;

import com.example.SpringProject.Business.EmployeeBusiness;
import com.example.SpringProject.Service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {

    @Test
    public void testCalculateAnnualSalary() {
        // Arrange
        EmployeeBusiness employeeService = new EmployeeBusiness();
        double monthlySalary = 5000.0;

        // Act
        double annualSalary = employeeService.computeAnnualSalary(monthlySalary);

        // Assert
        Assertions.assertEquals(60000.0, annualSalary);
    }
}
