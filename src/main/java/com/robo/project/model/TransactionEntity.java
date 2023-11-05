package com.robo.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;


@Entity(name = "Transaction")
@EqualsAndHashCode(of = "id")
@Setter
@Getter
public class TransactionEntity {


    @Id
    private Long id;
    @Column(name = "amount")
    private double value;
    private String currencyCode;
    private ZonedDateTime timestamp;
    private String transactionCategory;

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", value=" + value +
                ", currencyCode='" + currencyCode + '\'' +
                ", timestamp=" + timestamp +
                ", transactionCategory='" + transactionCategory + '\'' +
                '}';
    }
}
