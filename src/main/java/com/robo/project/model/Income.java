package com.robo.project.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@Entity
public class Income extends BaseFinanceAmountEntity {

    IncomeCategory incomeCategory;
}
