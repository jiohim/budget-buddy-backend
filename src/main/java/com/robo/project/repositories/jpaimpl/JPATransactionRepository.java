package com.robo.project.repositories.jpaimpl;

import com.robo.project.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPATransactionRepository  extends JpaRepository<TransactionEntity, Long> {
}
