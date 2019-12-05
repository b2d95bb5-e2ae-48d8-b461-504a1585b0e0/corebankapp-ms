package com.example.clientservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public String getHashcode() {
    return hashcode;
  }

  public void setHashcode(String hashcode) {
    this.hashcode = hashcode;
  }
  
  
}