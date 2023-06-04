package com.example.SpringProject.Service;

import com.example.SpringProject.Model.Employee;
import com.example.SpringProject.Model.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse getAllEmployees();
    EmployeeResponse getEmployeeById(int id);
}

