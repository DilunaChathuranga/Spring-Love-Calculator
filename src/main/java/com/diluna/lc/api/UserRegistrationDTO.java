package com.diluna.lc.api;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;

import com.diluna.lc.Validator.CustomAgeValidator;

public class UserRegistrationDTO {
	
	//Javax validations
	@NotBlank(message = "Name can't be Empty...")
	private String name;
	private String username;
	private char[] password;	
	//dropdown list but only 1 value we can select
	private String country;
	//bcz we can select multiple values 
	private String[] hobby;
	private String gender;
	
	@CustomAgeValidator()
	private Integer age;
	
	//this contain email and phone no
	private CommunicationDTO communicationDTO;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}
	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}

	
	@Override
	public String toString() {
		return "UserRegistrationDTO [name=" + name + ", username=" + username + ", password="
				+ Arrays.toString(password) + ", country=" + country + ", hobby=" + Arrays.toString(hobby) + ", gender="
				+ gender + ", age=" + age +"]";
	}

}
