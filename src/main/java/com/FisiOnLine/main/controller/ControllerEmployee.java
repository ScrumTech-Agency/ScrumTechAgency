package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.ObjetoRespuesta;
import com.FisiOnLine.main.service.GestorEmployee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControllerEmployee {

    private GestorEmployee gestorEmployee = new GestorEmployee();

    @GetMapping("/employees")
    public ResponseEntity<ArrayList<Employee>> getEmployees(){
        return new ResponseEntity<>(gestorEmployee.getEmployees(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/employee")
    public ResponseEntity<Object> getEmployee(@RequestParam String id){
        try {
            Employee employee = gestorEmployee.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<String> getEmployeePath(@PathVariable String id){
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
    @PostMapping("/employee")
    public ResponseEntity<String> postEmployee(@RequestBody Employee employee){

        try {
            String mensaje = gestorEmployee.setEmployee(employee);

            return new ResponseEntity<>(mensaje,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/employee")
    public ResponseEntity<ObjetoRespuesta> putEmployee(@RequestBody Employee employee_update){

        try {
            Employee employee_bd = gestorEmployee.updateEmployee(employee_update);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa",employee_bd), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}