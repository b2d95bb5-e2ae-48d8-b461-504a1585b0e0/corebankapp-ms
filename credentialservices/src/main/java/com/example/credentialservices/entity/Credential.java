package com.example.credentialservices.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

  // @JsonBackReference(value = "client_credential")
  // @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  // @JoinColumn(name = "client_id")
  private String client;

  public Credential() { }

  public Credential(String client, String username, String password, String mail) {
    this.client = client;
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
  public String getClient() {
    return client;
  }


}