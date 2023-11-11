package com.robo.project.model;

import lombok.*;
import org.javamoney.moneta.Money;

import java.time.ZonedDateTime;

@Value
@Builder
public class Transaction {


    private Long id;
    private Money value;
    private ZonedDateTime dateOfTransaction;
    private TransactionCategory transactionCategory;
}
