package com.example.clientservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true, name = "CLIENT_ID")
	private String clientId;
  @Column(length = 40, name = "FIRST_NAME")
  private String firstName;
  @Column(length = 40, name = "LAST_NAME")
  private String lastName;
  @Column(name = "HASHCODE")
  private String hashcode;
  
}