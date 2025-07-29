package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class YearlyReport {

    private final List<Record> records;

    public YearlyReport() {
        records = new ArrayList<>();
    }

    public void addRecord(Integer month, Double amount, Boolean isExpense) {
        Record record = new Record(month, amount, isExpense);
        records.add(record);
    }

    public Double getTotalByMonth(int month) {
        Double total = 0.0;

        for (Record record : records) {
            if (record.month == month) {
                if (record.isExpense) {
                    total -= record.amount;
                } else {
                    total += record.amount;
                }
            }
        }

        return total;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");

        records.forEach(record -> sj.add("Месяц " + record.month + " " + getTotalByMonth(record.month)));
        return sj.toString();
    }

    private static class Record {
        Integer month;
        Double amount;
        Boolean isExpense;

        Record(Integer month, Double amount, Boolean isExpense) {
            this.month = month;
            this.amount = amount;
            this.isExpense = isExpense;
        }
    }
}
