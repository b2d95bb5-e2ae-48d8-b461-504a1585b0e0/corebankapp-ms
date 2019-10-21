package com.example.credentialservices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.credentialservices.domain.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
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


}