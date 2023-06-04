package com.example.SpringProject.Controller;


import com.example.SpringProject.Model.EmployeeResponse;
import com.example.SpringProject.Model.EmployeeSearchForm;
import com.example.SpringProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/index")
    public String showEmployeeInformation(Model model) {
        EmployeeResponse employeeList = employeeService.getAllEmployees();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("searchForm", new EmployeeSearchForm());
        return "index";
    }

    @PostMapping("/employeessearch")
    public String searchEmployee(@ModelAttribute("searchForm") EmployeeSearchForm searchForm, Model model) {
        if (searchForm.getEmployeeId() != null) {
            int employeeId = searchForm.getEmployeeId();
            EmployeeResponse employee = employeeService.getEmployeeById(employeeId);
            if (employee != null) {
                List<EmployeeResponse> employeeList = new ArrayList<>();
                employeeList.add(employee);
                model.addAttribute("employeeList", employeeList);
                System.out.println(employeeList.toString());
            } else {
                model.addAttribute("employeeList", null);
            }
        } else {
            model.addAttribute("employeeList", null);
        }

        model.addAttribute("searchForm", searchForm);
        return "index";
    }



    @GetMapping("/employees")
    public ResponseEntity<EmployeeResponse> getAllEmployees() {
        EmployeeResponse employees = employeeService.getAllEmployees();
        if (employees != null) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}