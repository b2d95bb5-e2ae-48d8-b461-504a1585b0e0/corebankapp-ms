package com.example.credentialservices.domain;

import lombok.Data;

/**
 * Not a JPA entity
 */
@Data
public class Client {

  private String clientId;
	private String firstName;
	private String lastName;
	private int validationCode;
  
}