package com.huseyingur.SpringCrud.service.impl;

import com.huseyingur.SpringCrud.exception.ResourceNotFoundException;
import com.huseyingur.SpringCrud.model.Employee;
import com.huseyingur.SpringCrud.repository.EmployeeRepository;
import com.huseyingur.SpringCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository){

        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return   employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployess() {
        return  employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return  employee.get();
        }
        else {throw new ResourceNotFoundException("Employee","id",employee);
        }


    }

    @Override
    public Employee updateEmployeeB(Employee employee, long id) {

        Employee existingEmployee  = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","id", id));

        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }





}
