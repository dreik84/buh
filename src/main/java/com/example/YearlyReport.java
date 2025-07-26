package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class YearlyReport {

    List<Record> list;

    public YearlyReport() {
        list = new ArrayList<>();
    }

    public void addRecord(Integer month, BigDecimal amount, Boolean isExpense) {
        Record record = new Record(month, amount, isExpense);
        list.add(record);
    }

    private static class Record {
        Integer month;
        BigDecimal amount;
        Boolean isExpense;

        Record(Integer month, BigDecimal amount, Boolean isExpense) {
            this.month = month;
            this.amount = amount;
            this.isExpense = isExpense;
        }
    }
}
