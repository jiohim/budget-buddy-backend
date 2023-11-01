package com.robo.project.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction extends BaseFinanceAmountEntity {


    @Enumerated(EnumType.STRING)
    private TransactionCategory transactionCategory;
}
