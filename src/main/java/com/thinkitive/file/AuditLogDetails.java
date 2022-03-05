package com.thinkitive.file;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AuditLogDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer aid;
	private String name;
	private String salary;

	public AuditLogDetails() {
 
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "AuditLogDetails [aid=" + aid + ", name=" + name + ", salary=" + salary + "]";
	}

}
