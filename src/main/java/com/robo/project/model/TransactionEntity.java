package com.robo.project.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;


@Entity(name = "Transaction")
@EqualsAndHashCode(of = "id")
@Setter
@Getter
public class TransactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "amount")
    private double value;
    private String currencyCode;
    private ZonedDateTime dateOfTransaction;
    private String transactionCategory;
    private String transactionType ;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", value=" + value +
                ", currencyCode='" + currencyCode + '\'' +
                ", timestamp=" + dateOfTransaction +
                ", transactionCategory='" + transactionCategory + '\'' +
                '}';
    }
}
