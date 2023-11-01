package com.robo.project.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionCategory {

        GROCERIES("Groceries", TransactionType.EXPENSE),
        TRANSPORTATION("Transportation", TransactionType.EXPENSE),
        HOUSING("Housing", TransactionType.EXPENSE),
        ENTERTAINMENT("Entertainment", TransactionType.EXPENSE),
        HEALTHCARE("Healthcare", TransactionType.EXPENSE),
        SALARY("Salary", TransactionType.INCOME),
        FREELANCE("Freelance", TransactionType.INCOME),
        INVESTMENTS("Investments", TransactionType.INCOME),
        RENTAL_INCOME("Rental Income", TransactionType.INCOME),
        BUSINESS("Business", TransactionType.INCOME),
        OTHER("Other", TransactionType.INCOME);

        private final String categoryName;
        private final TransactionType transactionType;
}
