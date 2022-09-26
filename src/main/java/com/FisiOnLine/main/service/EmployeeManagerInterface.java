package com.FisiOnLine.main.service;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.Enterprise;

import java.util.List;

public interface EmployeeManagerInterface {
    public List<Employee> getEmployees();
    public Employee getEmployee(Long idEmployee) throws Exception;
    public String setEmployee (Employee Employees) throws Exception;
    public Employee UpdateEmployeeAll(Employee EmployeeUpdate, Long id) throws Exception;
    public Employee UpdateEmployee(Employee EmployeeUpdate, Long id) throws Exception;
    public String DeleteEmployee(Long idEmployee) throws Exception;
}
