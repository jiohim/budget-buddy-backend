package com.robo.project.services;

import com.robo.project.model.Transaction;

import java.util.List;
import java.util.Set;

public interface BalanceService extends CrudService<Transaction ,Long>{

    Set<Transaction> findAllIncomes();
    Set<Transaction> findAllExpenses();

    List<Transaction> searchProducts(String query);

    Set<Transaction> findAll();

    Transaction findById(Long id);

    Transaction save(Transaction object);

    void delete(Transaction object);

    void deleteById(Long id);
}
