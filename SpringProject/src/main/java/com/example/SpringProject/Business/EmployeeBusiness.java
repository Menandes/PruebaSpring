package com.example.SpringProject.Business;

import javax.ejb.Stateless;

@Stateless
public class EmployeeBusiness {

    public double computeAnnualSalary(double monthlySalary) {
        return monthlySalary * 12;
    }
}
