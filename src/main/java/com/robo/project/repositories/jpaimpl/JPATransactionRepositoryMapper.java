package com.robo.project.repositories.jpaimpl;


import com.robo.project.model.Transaction;
import com.robo.project.model.TransactionEntity;
import org.javamoney.moneta.Money;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {Money.class})
public interface JPATransactionRepositoryMapper {

    @Mapping(target = "value", expression = "java(transaction.getValue().getNumber().doubleValueExact())")
    @Mapping(target = "currencyCode", expression = "java(transaction.getValue().getCurrency().getCurrencyCode())")
    @Mapping(target = "transactionType", expression = "java(transaction.getTransactionCategory().getTransactionType().toString())")
    TransactionEntity toEntity(Transaction transaction);


    @Mapping(target = "value" ,expression = "java(Money.of(transactionEntity.getValue(), transactionEntity.getCurrencyCode()))")
    Transaction toDomain(TransactionEntity transactionEntity);

}
