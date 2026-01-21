package com.cts.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {

	@Id
	private String id;

	@NotBlank(message = "Name is required")
	private String name;

	private String password;

	@NotBlank(message = "JobTitle is required")
	private String jobTitle;

	@NotBlank(message = "Department is required")
	private String department;

	public Employee(@NotBlank(message = "Name is required") String name, String password,
			@NotBlank(message = "Email is required") @Email(message = "Invalid format of email") String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}

	@NotBlank(message = "Role is required")
	private String role;

	public Employee(String id, @NotBlank(message = "Name is required") String name, String password,
			@NotBlank(message = "JobTitle is required") String jobTitle,
			@NotBlank(message = "Department is required") String department,
			@NotBlank(message = "Role is required") String role,
			@NotNull(message = "salary is required") @Positive(message = "salary should be greater then 0") Double salary,
			@NotBlank(message = "Gender is required") String gender,
			@NotBlank(message = "Email is required") @Email(message = "Invalid format of email") String email,
			@NotBlank(message = "Address is required") String address,
			@NotBlank(message = "Mobile Number is required") String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.jobTitle = jobTitle;
		this.department = department;
		this.role = role;
		this.salary = salary;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NotNull(message = "salary is required")
	@Positive(message = "salary should be greater then 0")
	private Double salary;

	@NotBlank(message = "Gender is required")
	private String gender;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid format of email")
	private String email;

	@NotBlank(message = "Address is required")
	private String address;

	@NotBlank(message = "Mobile Number is required")
	private String mobileNo;

	public Employee() {

	}

	public Employee(String name, String jobTitle, String department, String role, Double salary, String gender,
			String email, String address, String mobileNo) {
		super();
		this.name = name;
		this.jobTitle = jobTitle;
		this.department = department;
		this.role = role;
		this.salary = salary;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.mobileNo = mobileNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

}
