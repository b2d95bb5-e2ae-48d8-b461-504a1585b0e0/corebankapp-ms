package com.example.accountingservices.domain;

import lombok.Data;

@Data
public class Credential {

  private String username;
  private String password;
  private String mail;
  private String role;
  private Integer validity;
  private int hashcode;
  private int status;
}