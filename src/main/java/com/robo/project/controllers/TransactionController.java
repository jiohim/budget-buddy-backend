package com.robo.project.controllers;


import com.robo.project.mappers.BalanceRestMapper;
import com.robo.project.mappers.TransactionDto;
import com.robo.project.services.BalanceService;
import com.robo.project.util.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RequestMapping("api/v1/transactions")
@RestController
@RequiredArgsConstructor
@Tag(name = "Transactions", description = "Endpoints for managing transactions")
public class TransactionController {

    private final BalanceService balanceService;
    private final BalanceRestMapper mapper;

    @GetMapping("{id}")
    @Operation(summary = "Get transaction by ID")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        var transaction = balanceService.findById(id);
        return new ResponseEntity<>(
                mapper.toDto(transaction)
                , HttpStatus.OK);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a transaction")
    public ResponseEntity<?> addNewTransaction(@RequestBody @Valid TransactionDto transactionDto) {
        var transaction = balanceService.save(mapper.toDomain(transactionDto));
        return new ResponseEntity<>(
                Constant.TRANSACTION_SAVED
                , HttpStatus.OK);
    }

    @GetMapping
    @Operation(summary = "Get all transactions")
    public ResponseEntity<?> getAllTransactions() {
        var transactions = balanceService.getSortedAndMappedTransactionDTOs(balanceService.findAll());
        return new ResponseEntity<>(
                transactions
                , HttpStatus.OK);
    }

    @GetMapping("/incomes")
    @Operation(summary = "Get incomes from: - to: ")
    public ResponseEntity<?> getIncomes(@RequestBody (required = false)  @Valid ZonedDateTime from,
                                        @RequestBody (required = false) @Valid ZonedDateTime to) {
        var transactions = balanceService.getSortedAndMappedTransactionDTOs(balanceService.findAll());
        return new ResponseEntity<>(
                transactions
                , HttpStatus.OK);
    }
}
