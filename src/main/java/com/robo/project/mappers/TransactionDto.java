package com.robo.project.mappers;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

@Data
public class TransactionDto {

    @NotNull
    private double moneyValue;
    @DateTimeFormat
    private ZonedDateTime dateOfTransaction;
    @NotNull
    private String transactionCategory;
}
