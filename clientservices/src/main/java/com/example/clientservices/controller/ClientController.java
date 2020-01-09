package com.example.clientservices.controller;

import java.util.Optional;

import com.example.clientservices.entity.Client;
import com.example.clientservices.repository.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {

  @Autowired
  private ClientRepository clientRepository;
  private final static Logger logger = LoggerFactory.getLogger("ClientController.class");


  @RequestMapping(name = "/getClientByHashcode", method = RequestMethod.GET)
  public Client getClientByHashcode(@RequestParam(name = "code") String hashcode){
    Optional<Client> optional = clientRepository.findByHashcode(hashcode);
    if(!optional.isPresent()) return null;
    
    logger.info("client's first name: " + optional.get().getFirstName());
    return optional.get();
  }
  
  
}