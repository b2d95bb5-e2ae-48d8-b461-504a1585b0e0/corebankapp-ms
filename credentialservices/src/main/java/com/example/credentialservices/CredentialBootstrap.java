package com.example.credentialservices;

import com.example.credentialservices.entity.Credential;
import com.example.credentialservices.repository.CredentialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CredentialBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private CredentialRepository repo;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent arg0) {
  
    Credential credential = new Credential("maxi", "maio", "maxi_maio@hotmail.com", "admin", 90);
    repo.save(credential);

  }

  
}