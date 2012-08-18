package com.hibernate.chapter1;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="EmployeeInfo")
public class Employee {
	private int empId;
	private String empName;
	private String empPassword;
	private String empEmailAddress;
	private boolean isPermanent;
	private Calendar empJoinDate;
	private Date empLoginTime;
	@Id
	@GeneratedValue
	@Column(name="EmployeeID")
	public int getEmpId(){
		return empId;
	}
	@Column(nullable=false)
	public String getEmpEmailAddress() {
		return empEmailAddress;
	}

	public void setEmpEmailAddress(String empEmailAddress) {
		this.empEmailAddress = empEmailAddress;
	}
	
	@Basic
	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}
	
	@Temporal(TemporalType.DATE)
	public Calendar getEmpJoinDate() {
		return empJoinDate;
	}

	public void setEmpJoinDate(Calendar empJoinDate) {
		this.empJoinDate = empJoinDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEmpLoginTime() {
		return empLoginTime;
	}

	public void setEmpLoginTime(Date empLoginTime) {
		this.empLoginTime = empLoginTime;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

}
