package com.huseyingur.SpringCrud.repository;

import com.huseyingur.SpringCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
