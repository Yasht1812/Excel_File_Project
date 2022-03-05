package com.thinkitive.file;

public class AuditLogDetailDTO {
	private Integer aid;
	private String name;
	private String salary;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
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
		return "AuditLogDetailDTO [aid=" + aid + ", name=" + name + ", salary=" + salary + "]";
	}

}
