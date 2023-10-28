package com.robo.project.model;


import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Expense extends BaseFinanceAmountEntity {

   private ExpenseCategory expenseCategory;
}
