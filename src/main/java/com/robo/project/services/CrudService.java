package com.robo.project.services;

import com.robo.project.model.Transaction;

import java.util.List;

public interface CrudService <T,ID>{

        List<Transaction> findAll();

        T findById(ID id);

        T save(T object);

        void delete(T object);

        void deleteById(ID id);

}
