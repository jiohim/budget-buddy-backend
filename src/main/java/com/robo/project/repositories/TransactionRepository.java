package com.robo.project.repositories;

import com.robo.project.model.Transaction;

import java.util.List;
import java.util.Optional;


public interface TransactionRepository  {

    Transaction save(Transaction transaction);

    Optional<Transaction> findById(Long id);

    List<Transaction> findAll();

    void delete(Transaction transaction);

    void deleteById(Long id);

    List<Transaction> findTransactions(String query);

}
