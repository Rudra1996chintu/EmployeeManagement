package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	 @Autowired
	    private EmployeeService employeeService;
	    @GetMapping("/getemployees")
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        List<Employee> employees = employeeService.getAllEmployees();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }
	    @PostMapping("/addemployee")
	    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
	        Employee emp = employeeService.addEmployee(employee);
	        return new ResponseEntity<>(emp, HttpStatus.OK);
	    }
	    @PutMapping("/updateemployee")
	    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
	        Employee emp = employeeService.editEmployees(employee);
	        return new ResponseEntity<>(emp, HttpStatus.OK);
	    }
	    @DeleteMapping("/deleteemployee")
	    public ResponseEntity<String> deleteEmployee(@RequestParam(name = "employeeId") Integer employeeId) {
	        employeeService.deleteEmployees(employeeId);
	        return new ResponseEntity<>("Employee with ID :" + employeeId + " deleted successfully", HttpStatus.OK);
	    }
}
