package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.ObjetoRespuesta;
import com.FisiOnLine.main.service.GestorEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControllerEmployee {
    @Autowired
    private GestorEmployee gestorEmployee;

    @GetMapping("/employees")
    public ResponseEntity<ArrayList<Employee>> getEmployees(){
        return new ResponseEntity<>(gestorEmployee.getEmployees(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/employee")
    public ResponseEntity<Object> getEmployee(@RequestParam Long id){
        try {
            Employee employee = gestorEmployee.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeePath(@PathVariable Long id){
        try {
            Employee employee = gestorEmployee.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<String> postEmployee(@RequestBody Employee employee_parametro){
        try {
            String mensaje = gestorEmployee.setEmployee(employee_parametro);
            return new ResponseEntity<>(mensaje,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmployee(@RequestBody Employee employee_update, @PathVariable Long id ){
        try {
            Employee employee_bd = gestorEmployee.updateEmployeeAll(employee_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa",employee_bd), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("/employee/{id}")
    public ResponseEntity<ObjetoRespuesta> patchUsuario(@RequestBody Employee employee_update, @PathVariable Long id) {
        try {
            Employee employee_bd = gestorEmployee.updateEmployee(employee_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", employee_bd), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity <ObjetoRespuesta> deleteEmployee(@PathVariable Long id) {

        try {
            String mensaje = gestorEmployee.deleteEmployee(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje, null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}