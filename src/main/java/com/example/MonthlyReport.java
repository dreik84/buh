package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {

    private List<Record> records;

    public MonthlyReport() {
        records = new ArrayList<>();
    }

    public void addRecord(String itemName, Boolean isExpense, Integer quantity, BigDecimal sumOfOne) {
        Record record = new Record(itemName, isExpense, quantity, sumOfOne);
        records.add(record);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.valueOf(0);

        for (Record record : records) {
            if (record.isExpense) {
                total.subtract(record.sumOfOne.multiply(BigDecimal.valueOf(record.quantity)));
            } else {
                total.add(record.sumOfOne.multiply(BigDecimal.valueOf(record.quantity)));
            }
        }

        return total;
    }

    private static class Record {
        String itemName;
        Boolean isExpense;
        Integer quantity;
        BigDecimal sumOfOne;

        Record(String itemName, Boolean isExpense, Integer quantity, BigDecimal sumOfOne) {
            this.itemName = itemName;
            this.isExpense = isExpense;
            this.quantity = quantity;
            this.sumOfOne = sumOfOne;
        }
    }
}
