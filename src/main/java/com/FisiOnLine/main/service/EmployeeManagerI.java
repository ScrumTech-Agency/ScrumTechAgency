package com.FisiOnLine.main.service;

import com.FisiOnLine.main.Repositories.EmployeeRepository;
import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.Enum_RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManagerI implements EmployeeManagerInterface{
//Inyeccion de bean
    @Autowired
    private EmployeeRepository repository;


    //Metodo para consultar lista de todos los empleados
    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    //Metodo que consulta un empleado por ID de empleado
    @Override
    public Employee getEmployee(Long idEmployee) throws Exception {
        Optional<Employee> employeeBd = repository.findById(idEmployee);
        if (employeeBd.isPresent()) {
            return employeeBd.get();
        }
        throw  new Exception("Usuario no existe");
    }
    //Método que guarda un empleado en base de datos
    @Override
    public String setEmployee(Employee employees) throws Exception {
        Date today = new Date();
        employees.setCratedAt(today);
        System.out.println(today);
        repository.save(employees);

        return "Usuario Creado Exitosamente";
    }

    @Override
    public Employee UpdateEmployeeAll(Employee EmployeeUpdate, Long id) throws Exception {
        return null;
    }

    @Override
    public Employee UpdateEmployee(Employee employeeUpdate, Long id) throws Exception {
        Employee employee_Bd = getEmployee(id);

        if (employeeUpdate.getNameEmpl() != null && !employeeUpdate.getNameEmpl().equals("")) {
            employee_Bd.setNameEmpl(employeeUpdate.getNameEmpl());
        }

        if (employeeUpdate.getEmailEmpl() != null && !employeeUpdate.getEmailEmpl().equals("")) {
            employee_Bd.setEmailEmpl(employeeUpdate.getEmailEmpl());
        }

        List <String> roles = new ArrayList<>();
        if(employeeUpdate.getRoleEmpl()!=null){
            for (Enum_RoleName rol : employeeUpdate.getRoleEmpl()){
                roles.add(new String(rol.name()));
            }
        }
        for (String rolValid: roles){
            if (!rolValid.equals("")){
                employee_Bd.setRoleEmpl(employeeUpdate.getRoleEmpl());
            }
        }
        return repository.save(employee_Bd);
    }

   @Override
    public String DeleteEmployee(Long idEmployee) throws Exception {
        repository.deleteById(idEmployee);
        return "Usuario Eliminado Exitosamente";
    }
}