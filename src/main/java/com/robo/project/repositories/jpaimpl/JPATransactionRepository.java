package com.robo.project.repositories.jpaimpl;

import com.robo.project.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JPATransactionRepository extends JpaRepository<TransactionEntity, Long> {

    //TODO required fix
    @Query("SELECT t FROM Transaction t WHERE " +
            "t.transactionType LIKE CONCAT('%',:query, '%')" +
            "Or t.transactionCategory LIKE CONCAT('%', :query, '%')")
    List<TransactionEntity> searchTransactions(String query);
}
