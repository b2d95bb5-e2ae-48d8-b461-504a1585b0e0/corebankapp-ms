package com.example.accountingservices.domain;

import lombok.Data;

/**
 * Not a JPA Entity
 */
@Data
public class Client {

	private Long id;
  private String clientId;
	private String firstName;
	private String lastName;
	private int validationCode;
  
}