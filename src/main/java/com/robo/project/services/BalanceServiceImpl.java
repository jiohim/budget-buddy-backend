package com.robo.project.services;

import com.robo.project.mappers.BalanceRestMapper;
import com.robo.project.mappers.TransactionDto;
import com.robo.project.model.Transaction;
import com.robo.project.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.robo.project.model.TransactionType.EXPENSE;
import static com.robo.project.model.TransactionType.INCOME;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final TransactionRepository transactionRepository;
    private final BalanceRestMapper mapper;


    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<>();
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
    public List<Transaction> searchProducts(String query) {
        return transactionRepository.findTransactions(query);
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


    @Override
    public void delete(Transaction object) {
        transactionRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<TransactionDto> getSortedAndMappedTransactionDTOs(List<Transaction> transactions) {
        return transactions
                .stream()
                .sorted(Comparator.comparingLong(Transaction::getId))
                .map(transaction -> mapper.toDto(transaction))
                .toList();
    }


}
