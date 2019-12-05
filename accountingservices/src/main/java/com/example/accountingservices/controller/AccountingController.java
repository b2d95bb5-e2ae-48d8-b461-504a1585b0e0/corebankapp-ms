package com.example.accountingservices.controller;

import java.util.List;
import java.util.Optional;

import com.example.accountingservices.domain.Client;
import com.example.accountingservices.domain.Credential;
import com.example.accountingservices.entity.Balance;
import com.example.accountingservices.repository.BalanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class AccountingController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private BalanceRepository balanceRepository;

  @Deprecated // For testing purpose only
  @RequestMapping(path = "/login/user", method = RequestMethod.GET)
  public Credential userValidation(){
    Credential c = new Credential(); c.setUsername("maxi"); c.setPassword("maio");

    ResponseEntity<Credential> responseEntity = restTemplate.postForEntity(
      "http://CREDENTIALSERVICES/login/user", c, Credential.class);
      
    return responseEntity.getBody();
  }

  @RequestMapping(value = "/balance", method = RequestMethod.GET)
  public List<Balance> getBalance(@RequestParam(name = "code", required = true) String hashcode){
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://CLIENTSERVICES/getClientByHashcode")
      .queryParam("code", hashcode);
    ResponseEntity<Client> responseEntity = restTemplate.getForEntity(
      builder.buildAndExpand(builder).toUri(), Client.class);
    // ResponseEntity<Client> responseEntity = restTemplate.exchange(
    //   "http://CLIENTSERVICES/getClientByHashcode", HttpMethod.GET, null, Client.class, hashcode);
    Client client = responseEntity.getBody();
    Optional<List<Balance>> optional = balanceRepository.findByClientId(client.getId());
    if(!optional.isPresent()) return null;

    return optional.get();
  }
  
}