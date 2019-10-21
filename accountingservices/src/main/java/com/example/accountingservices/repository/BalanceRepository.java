package com.example.accountingservices.repository;

import java.util.List;
import java.util.Optional;

import com.example.accountingservices.entity.Balance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends CrudRepository<Balance, Long> {
  Optional<List<Balance>> findByClientId(Long clientId);
  
}