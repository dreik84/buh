package com.example;

import java.lang.reflect.RecordComponent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class YearlyReport {

    private List<Record> records;

    public YearlyReport() {
        records = new ArrayList<>();
    }

    public void addRecord(Integer month, BigDecimal amount, Boolean isExpense) {
        Record record = new Record(month, amount, isExpense);
        records.add(record);
    }

    public BigDecimal getTotalByMonth(int month) {
        BigDecimal total = BigDecimal.valueOf(0);

        for (Record record : records) {
            if (record.month == month) {
                if (record.isExpense) {
                    total.subtract(record.amount);
                } else {
                    total.add(record.amount);
                }
            }
        }

        return total;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");

        records.forEach(record -> sj.add("Месяц " + record.month + " "  + getTotalByMonth(record.month)));
        return sj.toString();
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
