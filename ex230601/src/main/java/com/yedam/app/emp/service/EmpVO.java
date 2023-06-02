package com.yedam.app.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
    String lastName;
    String email;
	String hireDate;
	String jobId;
	
	String departmentId;
	String departmentName;
	String orderColumn;
	
	//필드를 안써도 get 됨. Data때문엥
	//collection 으로 들어감.
	String[] getDeptArr() {
		return departmentId.split(",");
	}
}
