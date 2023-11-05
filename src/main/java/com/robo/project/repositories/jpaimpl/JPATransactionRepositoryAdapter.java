package com.robo.project.repositories.jpaimpl;

import com.robo.project.model.Transaction;
import com.robo.project.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Component
@RequiredArgsConstructor
public class JPATransactionRepositoryAdapter implements TransactionRepository {


    private final JPATransactionRepository repository;
    private final JPATransactionRepositoryMapper mapper;

    @Override
    public Transaction save(Transaction transaction) {
        var transactionEntity = mapper.toEntity(transaction);
        return mapper.toDomain(repository.save(transactionEntity));
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Transaction transaction) {
        repository.delete(mapper.toEntity(transaction));

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
