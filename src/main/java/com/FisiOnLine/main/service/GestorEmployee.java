package com.FisiOnLine.main.service;

import com.FisiOnLine.main.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class GestorEmployee {
    private ArrayList<Employee> employees;

    public GestorEmployee(){

        this.employees = new ArrayList<>();

        this.employees.add(new Employee(123,"wilson","wahs_30"));

    }

    public Employee getEmployee(Long id) throws Exception {
        for(Employee employee: this.employees){
            if(employee.getIdEmpl()==id) {
                return employee;
            }
        }
        throw new Exception("Empleado No Existe");
    }

    public String setEmployee(Employee employee_parametro) throws Exception {
        try {
            getEmployee(employee_parametro.getIdEmpl());
        } catch (Exception e) {
            this.employees.add(employee_parametro);
            return "Creación Empleado Exitosa";
        }
        throw new Exception("Empleado Existe");
    }

    public Employee updateEmployee(Employee employee_update, String id) throws Exception {
        try {
            Employee employee_bd = getEmployee(Long.valueOf(id));

            if(employee_update.getNameEmpl() != null && !employee_update.getNameEmpl().equals("")){
                employee_bd.setNameEmpl(employee_update.getNameEmpl());
            }
            if(employee_update.getEmailEmpl() != null && !employee_update.getEmailEmpl().equals("")) {
                employee_bd.setEmailEmpl(employee_update.getEmailEmpl());
            }

            /*if(employee_update.getProfileEmpl() != null && !employee_update.getProfileEmpl().equals("")) {
                employee_bd.setProfileEmpl(employee_update.getProfileEmpl());
            }*/
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

    public  Employee updateUsuarioAll(Employee employee_update, String id) throws Exception {
        try {
            Employee usuario_Bd = getEmployee(Long.valueOf(id)); //consulta empleadocon get

            usuario_Bd.setIdEmpl(employee_update.getIdEmpl());
            usuario_Bd.setNameEmpl(employee_update.getNameEmpl());
            usuario_Bd.setEmailEmpl(employee_update.getEmailEmpl());
            usuario_Bd.setRoleEmpl(employee_update.getRoleEmpl());
            usuario_Bd.setEnterprise(employee_update.getEnterprise());


            return usuario_Bd;
        } catch (Exception e) {
            throw new Exception("Usuario No existe , Fallo en la actualización de datosD");
        }
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

}

