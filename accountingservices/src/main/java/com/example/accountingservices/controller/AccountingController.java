package com.example.accountingservices.controller;

import java.util.List;
import java.util.Optional;

import com.example.accountingservices.domain.Client;
import com.example.accountingservices.domain.Credential;
import com.example.accountingservices.entity.Balance;
import com.example.accountingservices.repository.BalanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AccountingController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private BalanceRepository balanceRepository;

  @RequestMapping(path = "/login/user", method = RequestMethod.GET)
  public Credential userValidation(){
    // JSONObject json = new JSONObject();
    // json.put("username", "maxi");
    // json.put("password", "maio");
    Credential c = new Credential();
    c.setUsername("maxi");
    c.setPassword("maio");

    ResponseEntity<Credential> responseEntity = restTemplate.postForEntity(
      "http://CREDENTIALSERVICES/login/user", c, Credential.class);
    if(responseEntity.getBody() != null) {
      log.info("++ Username received: " + responseEntity.getBody().getUsername());
    }else{
      log.info("++ Username received is null");
    }
      
    return responseEntity.getBody();
  }

  @RequestMapping(value = "/balance", method = RequestMethod.GET)
  public List<Balance> getBalance(@RequestParam(name = "code", required = true) String hashcode){
    ResponseEntity<Client> responseEntity = restTemplate.exchange(
      "http://CLIENTSERVICES/getClientByHashcode", HttpMethod.GET, null, Client.class, hashcode);
    Client client = responseEntity.getBody();
    
    log.info("client: " + client.getFirstName());

    Optional<List<Balance>> optional = balanceRepository.findByClientId(client.getId());
    if(!optional.isPresent()) return null;

    return optional.get();
    
  }
  
}