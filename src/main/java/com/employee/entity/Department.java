package com.employee.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Department")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int DepartmentId;
	@Column(name = "department_name")
	private String DepartmentName;
	@Column(name = "manager_id")
	private int managerId;
	    @Column(name = "location_id")
	    private int locationId;
	    @OneToMany(mappedBy="department",cascade=CascadeType.ALL,orphanRemoval=true)
	    @JsonIgnore
	    private List<Employee> employees;
	   
	    public Department() {
	   
	    }
	public int getDepartmentId() {
	return DepartmentId;
	}
	public void setDepartmentId(int DepartmentId) {
	this.DepartmentId = DepartmentId;
	}
	public String getDepartmentName() {
	return DepartmentName;
	}
	public void setDepartmentName(String DepartmentName) {
	this.DepartmentName = DepartmentName;
	}
	public int getManagerId() {
	return managerId;
	}
	public void setManagerId(int managerId) {
	this.managerId = managerId;
	}
	public int getLocationId() {
	return locationId;
	}
	public void setLocationId(int locationId) {
	this.locationId = locationId;
	}
	public List<Employee> getEmployees() {
	return employees;
	}
	public void setEmployees(List<Employee> employees) {
	this.employees = employees;
	}
	public Department setDeptName(Department department) {
	return department;
	}
}


