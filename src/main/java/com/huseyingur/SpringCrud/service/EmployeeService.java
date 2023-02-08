package com.huseyingur.SpringCrud.service;

import com.huseyingur.SpringCrud.model.Employee;

import java.util.List;

public interface EmployeeService {

     Employee saveEmployee(Employee employee) ;

     List<Employee> getAllEmployess();

     Employee getEmployeeById(long id);

     Employee updateEmployeeB(Employee employee, long id);

}
