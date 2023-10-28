package com.robo.project.model;


import lombok.*;
import org.javamoney.moneta.Money;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Currency;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseItem extends BaseFinanceAmountEntity {

   private ExpenseCategory expenseCategory;
}
