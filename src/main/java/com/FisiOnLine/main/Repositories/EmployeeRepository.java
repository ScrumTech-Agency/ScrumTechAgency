package com.FisiOnLine.main.Repositories;

import com.FisiOnLine.main.model.Employee;
import com.FisiOnLine.main.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}



