package com.robo.project.mappers;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TransactionDto {

    private Long id;
    private double moneyValue;
    private ZonedDateTime timestamp;
    private String transactionCategory;
}
