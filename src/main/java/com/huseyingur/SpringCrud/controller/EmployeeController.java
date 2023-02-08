package com.huseyingur.SpringCrud.controller;


import com.huseyingur.SpringCrud.model.Employee;
import com.huseyingur.SpringCrud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

@PostMapping()
public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

}
@GetMapping
public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployess();

}

@GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        return  new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);

}

@PutMapping("{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.updateEmployeeB(employee,id),HttpStatus.OK);




}









}
