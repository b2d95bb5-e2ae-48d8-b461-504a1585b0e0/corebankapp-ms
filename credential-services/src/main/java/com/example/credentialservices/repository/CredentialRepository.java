package com.example.credentialservices.repository;

import java.util.List;
import java.util.Optional;

import com.example.credentialservices.entity.Credential;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, Long> {
  Optional<Credential> findByUsername(String username);
  Optional<Credential> findByPassword(String password);
  Optional<Credential> findByHashcode(int hashcode);
  List<Credential> findByHashcode(String code);
  
}