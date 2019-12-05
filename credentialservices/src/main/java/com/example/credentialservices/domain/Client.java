package com.example.credentialservices.domain;


public class Client {

 	private String clientId;
	private String firstName;
	private String lastName;
	private int validationCode;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
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

	public int getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(int validationCode) {
		this.validationCode = validationCode;
	}
  
	
}