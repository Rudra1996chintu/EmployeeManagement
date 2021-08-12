package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.EmployeeRepository;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee addEmployee(Employee employee) {
/*
* Department dept =
* departmentRepository.findById(employee.getDepartment().getDepartmentId()).
* orElse(null); if (null == dept) { dept = new Department(); }
*/
Department dept=new Department();
 dept.setDepartmentName(employee.getDepartment().getDepartmentName());
 dept.setDepartmentId(employee.getDepartment().getDepartmentId());
 dept.setLocationId(employee.getDepartment().getLocationId());
 dept.setManagerId(employee.getDepartment().getManagerId());
departmentRepository.save(dept);
employee.setDepartment(dept);
       
        return employeeRepository.save(employee);
    }
    public Employee editEmployees(Employee entity) {
        return employeeRepository.save(entity);
    }
    public void deleteEmployees(Integer id) {
        employeeRepository.deleteById(id);
    }
}
