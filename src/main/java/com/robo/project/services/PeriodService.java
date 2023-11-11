package com.robo.project.services;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService  <T , F , S> {

    public List<T> getTransactions(F from, S to) {
        if (from != null && to != null) {
            return getIncomesBetween(from, to);
        } else if (from != null) {
            return getIncomesFrom(from);
        } else if (to != null) {
            return getIncomesTill(to);
        } else {
            return getAllIncomes();
        }
    }

    private List<T> getIncomesBetween(F from, S to) {
        // Logic
        return null;
    }

    private List<T> getIncomesFrom(F from) {
        // Logic
        return null;
    }

    private List<T> getIncomesTill(S to) {
        // Logic
        return null;
    }

    private List<T> getAllIncomes() {
        // Logic
        return null;
    }

}
