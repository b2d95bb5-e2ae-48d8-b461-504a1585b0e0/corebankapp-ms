package com.example.clientservices.repository;

import java.util.Optional;

import com.example.clientservices.entity.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

  Optional<Client> findByHashcode(String hashcode);
  
}