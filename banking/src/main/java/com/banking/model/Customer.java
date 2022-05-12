package com.banking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Customer {

	@Id
	private int acctID;
	@NotBlank(message="Name is required")
	private String custName;
	@NotBlank(message="CompanyName is required")
	private String company;
	 @Size(max=20,min=5,message="criteria not met")
	private String address;
	@NotBlank(message="Email is required")
	private String email;
	 @Size(max=10,message="Enter A Valid PhoneNo")
	private int phoneNo;
	 @NotBlank(message="mandatory field")
	private String password;

	public Customer() {

	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(int acctID, String custName, String company, String address, String email, int phoneNo,
			String password) {
		super();
		this.acctID = acctID;
		
		this.custName = custName;
		this.company = company;
		this.address = address;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
	}


	
}
