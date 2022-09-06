package com.FisiOnLine.main.service;

import com.FisiOnLine.main.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;


public class GestorEmployee {
    private ArrayList<Employee> employees;

    public GestorEmployee(){

        this.employees = new ArrayList<>();

        this.employees.add(new Employee());

    }

    public Employee getEmployee(String nameEmpl) throws Exception {
        for(Employee employee: this.employees){
            if(employee.getNameEmpl().equals(nameEmpl) ){
                return employee;
            }
        }
        throw new Exception("Empleado No Existe");
    }

    public String setEmployee(Employee employee) throws Exception {
        try {
            getEmployee(employee.getNameEmpl());
        } catch (Exception e) {
            this.employees.add(employee);
            return "Creación Empleado Exitosa";
        }
        throw new Exception("Empleado Existe");
    }

    public Employee updateEmployee(Employee employee_update) throws Exception {
        try {
            Employee employee_bd = getEmployee(employee_update.getNameEmpl());

            if(employee_update.getNameEmpl() != null && !employee_update.getNameEmpl().equals("")){
                employee_bd.setNameEmpl(employee_update.getNameEmpl());
            }
            if(employee_update.getEmailEmpl() != null && !employee_update.getEmailEmpl().equals("")) {
                employee_bd.setEmailEmpl(employee_update.getEmailEmpl());
            }

            if(employee_update.getProfileEmpl() != null && !employee_update.getProfileEmpl().equals("")) {
                employee_bd.setProfileEmpl(employee_update.getProfileEmpl());
            }
            if(employee_update.getRoleEmpl() != null && !employee_update.getRoleEmpl().equals("")) {
                employee_bd.setRoleEmpl(employee_update.getRoleEmpl());
            }
            if(employee_update.getEnterprise() != null && !employee_update.getEnterprise().equals("")) {
                employee_bd.setEnterprise(employee_update.getEnterprise());
            }

            return employee_bd;

        } catch (Exception e) {
            throw new Exception("Empleado NO existe, fallo actualización de datos");
        }
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

}

