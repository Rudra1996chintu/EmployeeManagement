package com.employee.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Employee_Dtls")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int eId;
@Column(name = "start_date")
private Date eStartDate;

public Employee() {

}
public int geteId() {
return eId;
}

public void seteId(int eId) {
this.eId = eId;
}

public Date geteStartDate() {
return eStartDate;
}

public void seteStartDate(Date eStartDate) {
this.eStartDate = eStartDate;
}

public Date geteEndDate() {
return eEndDate;
}

public void seteEndDate(Date eEndDate) {
this.eEndDate = eEndDate;
}

public String geteJobId() {
return eJobId;
}

public void seteJobId(String eJobId) {
this.eJobId = eJobId;
}

@Column(name = "end_date")
private Date eEndDate;
@Column(name = "job_id")
private String eJobId;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(foreignKey=@ForeignKey(name = "department_id"),name = "department_id")
private Department department;

public Department getDepartment() {

return department;
}

public void setDepartment(Department dept) {

this.department=dept;
}

		
	}

