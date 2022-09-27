package com.FisiOnLine.main.service;

import com.FisiOnLine.main.model.Enterprise;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class EnterpriseManager implements EnterpriseManagerInterface {
    private ArrayList<Enterprise> ListaDeEmpresas = new ArrayList<>();


    //Metodo que me permite traer la lista de empresas
    public ArrayList<Enterprise> getEnterpriseX (){


        return getListaDeEmpresas();
    }


    //Metodo que devuelve un solo Enterprise pasandole el idEnterprise como parametro
    public Enterprise getOnlyEnterprise(Long idEnterprise) throws Exception {
        ListaDeEmpresas=getListaDeEmpresas();
        for (Enterprise EnterpriseX: this.ListaDeEmpresas){
            if(EnterpriseX.getIdEnterprise()==idEnterprise){
                return EnterpriseX;
            }
        }
        throw new Exception("Enterprise NO Existente");
    }


    //Metodo que me permite adicionar un nuevo Enterprise al ArrayList
    public String setCreateEnterprise(Enterprise EnterpriseX) throws Exception {
        try {
            //Consulatmos si el sEnterprise con ese idEnterprise ya existe
            getOnlyEnterprise(EnterpriseX.getIdEnterprise());
        } catch (Exception e) {
            //Aqui adicionamos el nuevo Enterprise al ArrayList
            this.ListaDeEmpresas.add(EnterpriseX);
            setListaDeEmpresas(ListaDeEmpresas);
            return "EmpresaCreadaConEXITO";
        }
        throw new Exception("El Enterprise YA EXISTE");
    }

    //Metodo para actualizar un Enterprise
    public Enterprise UpdateEnterpriseAll(Enterprise EnterpriseX) throws Exception {
        try {
            //Consulatmos si el sEnterprise con ese idEnterprise  existe y lo actualizamos
            Enterprise EnterpriseBD = getOnlyEnterprise(EnterpriseX.getIdEnterprise());
            String IdSacado = String.valueOf((EnterpriseX.getIdEnterprise()));
            if(IdSacado !=null){
                EnterpriseBD.setIdEnterprise(EnterpriseX.getIdEnterprise());
                EnterpriseBD.setAddress(EnterpriseX.getAddress());
                EnterpriseBD.setDocument(EnterpriseX.getDocument());
                EnterpriseBD.setName(EnterpriseX.getName());
                EnterpriseBD.setPhone(EnterpriseX.getPhone());

            }
            return EnterpriseBD;
        } catch (Exception e) {
            throw new Exception("Empresa NO EXISTE, por lo tanto no se ACTUALIZO");

        }


    }

    //Metodo para eliminar un Enterprise
    public String DeleteEnterprise (Long idEnterprise) throws Exception {
        try {
            Enterprise EnterpriseX = getOnlyEnterprise(idEnterprise);
            this.ListaDeEmpresas.remove(EnterpriseX);
            return "Empresa ELIMINADA con exito";
        } catch (Exception e) {
            throw new Exception("Enterprise NO EXISENTE. Imposible eliminar");
        }
    }


    //Getters and Setters de ListaDeEmpresas
    public ArrayList<Enterprise> getListaDeEmpresas() {
        return ListaDeEmpresas;
    }

    public void setListaDeEmpresas(ArrayList<Enterprise> ListaDeEmpresas) {
        ListaDeEmpresas = ListaDeEmpresas;
    }

}
