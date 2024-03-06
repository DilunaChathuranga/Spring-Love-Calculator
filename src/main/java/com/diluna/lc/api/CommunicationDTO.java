package com.diluna.lc.api;

//We use different DTO bcz we can use this DTO properties multiple places
public class CommunicationDTO {

	private String email;
	private Phone phone;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	 
	
}
