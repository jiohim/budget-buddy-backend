package com.robo.project.services.jpaimpl;

import com.robo.project.model.BaseFinanceAmountEntity;
import com.robo.project.model.Transaction;
import com.robo.project.model.TransactionType;
import com.robo.project.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.robo.project.model.TransactionType.EXPENSE;
import static com.robo.project.model.TransactionType.INCOME;

@Service
@Transactional
@RequiredArgsConstructor
public class BalanceJPAService implements BalanceService{

    private final TransactionRepository transactionRepository;


    @Override
    public Set<Transaction> findAll() {
        Set <Transaction> transactions = new HashSet<>();
        transactionRepository.findAll().forEach(transactions::add);
        return transactions;
    }

    @Override
    public Set<Transaction> findAllExpenses() {
        return transactionRepository.findAll()
                .stream()
                .filter(transaction -> transaction.getTransactionCategory().getTransactionType().equals(EXPENSE))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Transaction> findAllIncomes() {
        return transactionRepository.findAll()
                .stream()
                .filter(transaction -> transaction.getTransactionCategory().getTransactionType().equals(INCOME))
                .collect(Collectors.toSet());
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public Transaction save(Transaction object) {
        return transactionRepository.save(object);
    }

    //TODO check if below methods are needed :

    @Override
    public void delete(Transaction object) {
        transactionRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
