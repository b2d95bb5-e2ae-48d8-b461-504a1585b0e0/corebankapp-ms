package com.example.credentialservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "CREDENTIAL")
public class Credential {

  @Id
  @Column(name = "CREDENTIAL_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(name = "USERNAME", unique = true)
  private String username;
  
  @Column(name = "PASSWORD")
  private String password;
  private String mail;
  private String role;
  private Integer validity;
  private int hashcode;
  private int status;

  @Column(name = "CLIENT_ID")
  private Long clientId;

  public Credential() { }

  public Credential(Long clientId, String username, String password, String mail) {
    this.clientId = clientId;
    this.username = username;
    this.password = password;
    this.mail = mail;
    this.role = "user";
    this.validity = 90;
    this.status = 1;
  }

  public Credential(String username, String password, String mail, String role, int status) {
    this.username = username;
    this.password = password;
    this.mail = mail;
    this.role = role;
    this.status = status;
  }

  @JsonIgnore
  public Long getClient() {
    return clientId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Integer getValidity() {
    return validity;
  }

  public void setValidity(Integer validity) {
    this.validity = validity;
  }

  public int getHashcode() {
    return hashcode;
  }

  public void setHashcode(int hashcode) {
    this.hashcode = hashcode;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  

}