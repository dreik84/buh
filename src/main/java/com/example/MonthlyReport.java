package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class MonthlyReport {

    private final List<Record> records;

    public MonthlyReport() {
        records = new ArrayList<>();
    }

    public void addRecord(String itemName, Boolean isExpense, Integer quantity, Double sumOfOne) {
        Record record = new Record(itemName, isExpense, quantity, sumOfOne);
        records.add(record);
    }

    public Double getTotal() {
        double total = 0.0;

        for (Record record : records) {
            if (record.isExpense) {
                total -= record.quantity * record.sumOfOne;
            } else {
                total += record.quantity * record.sumOfOne;
            }
        }

        return total;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");

        records.forEach(record -> sj.add(record.quantity + "*" + record.sumOfOne + "=" + getTotal()));
        return sj.toString();
    }

    private static class Record {
        String itemName;
        Boolean isExpense;
        Integer quantity;
        Double sumOfOne;

        Record(String itemName, Boolean isExpense, Integer quantity, Double sumOfOne) {
            this.itemName = itemName;
            this.isExpense = isExpense;
            this.quantity = quantity;
            this.sumOfOne = sumOfOne;
        }
    }
}
