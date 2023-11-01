package com.robo.project.mappers.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TransactionDto {

    private Long id;
    private String moneyValue;
    private ZonedDateTime timestamp;
    private String transactionCategory;
}
