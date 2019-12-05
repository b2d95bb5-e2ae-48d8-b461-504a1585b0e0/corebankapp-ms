package com.example.accountingservices.domain;



public class Credential {

  private String username;
  private String password;
  private String mail;
  private String role;
  private Integer validity;
  private int hashcode;
  private int status;

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

  
}