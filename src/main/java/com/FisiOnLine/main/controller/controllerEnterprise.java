package com.FisiOnLine.main.controller;

import com.FisiOnLine.main.model.Enterprise;
import com.FisiOnLine.main.model.ObjectAnswer;
import com.FisiOnLine.main.service.EnterpriseManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class controllerEnterprise {
    @Autowired
    private EnterpriseManagerInterface EnterpriseManagerX;

    //Creamos el controlador de la URL EnterpriseRegister para traer todos las empresas
    @GetMapping("/EnterpriseRegister")
    public ResponseEntity<List<Enterprise>> getEnterpriseX(){
        return new ResponseEntity<>(EnterpriseManagerX.getEnterpriseX(), HttpStatus.ACCEPTED);
    }

    //Creamos una consulta por medio de un PATH PARAMS para una sola empresa
    //En internet debe escribirse localhost:8080/[Aqui el IdEnterprise]
    @GetMapping("/OnlyEnterpriseBD/{idEnterprise}")
    public ResponseEntity<Object> getEnterpriseXPath(@PathVariable String idEnterprise){
        try {
            Enterprise EmpresaX = EnterpriseManagerX.getOnlyEnterprise(idEnterprise);
            return new ResponseEntity<>(EmpresaX, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Metodo para crear una empresa
    @PostMapping("/CreateEnterpriseBD")
    public ResponseEntity<String> PostCreateEnterprise(@RequestBody Enterprise EnterpriseX){
        try {
            String MensajeX = EnterpriseManagerX.setCreateEnterprise(EnterpriseX);
            return new ResponseEntity<>(MensajeX,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo para modificar una empresa
    @PutMapping("/ModificEnterpriseBD")
    public ResponseEntity<ObjectAnswer> putModificEnterprise(@RequestBody Enterprise EnterpriseX){

        try {
            Enterprise EnterpriseBD = EnterpriseManagerX.UpdateEnterpriseAll(EnterpriseX);
            return new ResponseEntity<>(new ObjectAnswer("Actualizacion Exitosa",EnterpriseBD),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectAnswer(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //Request para eliminar una empresa
    @DeleteMapping("/DeleteEnterpriseBD/{idEnterprise}")
    public ResponseEntity<ObjectAnswer> DeleteEnterprise(@PathVariable String idEnterprise){

        try {

            String Mensaje = EnterpriseManagerX.DeleteEnterprise(idEnterprise);
            return new ResponseEntity<>(new ObjectAnswer(Mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjectAnswer(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
