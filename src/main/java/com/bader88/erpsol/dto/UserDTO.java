package com.bader88.erpsol.dto;

import java.util.List;

public class UserDTO {
	private String firstName;
	private String lastName;
	private String mobile;
	private String gender;
	private List<AddressDTO> addresses;
	
	
	public UserDTO(String firstName, String lastName, String mobile, String gender, List<AddressDTO> addresses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.gender = gender;
		this.addresses = addresses;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	

}
