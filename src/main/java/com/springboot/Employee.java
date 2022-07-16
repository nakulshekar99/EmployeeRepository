package com.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
 @Id
 @GeneratedValue
    @Column(name="emp_id")
	private Integer emp_id;
    @Column(name="firstname")
	private String firstname;
    @Column(name="surname")
	private String surname;
    @Column(name="location")
	private String location;
	public Employee() {
		
	}
	public Employee(Integer emp_id, String firstname, String surname, String location) {
		
		this.emp_id = emp_id;
		this.firstname = firstname;
		this.surname = surname;
		this.location = location;
	}
	public Integer getEmpid() {
		return emp_id;
	}
	public void setEmpid(Integer empid) {
		this.emp_id = empid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + emp_id + ", firstname=" + firstname + ", surname=" + surname + ", location="
				+ location + "]";
	}
	
	
	
	
	
}
