package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");

        records.forEach(record -> sj.add(record.quantity  + "*" + record.sumOfOne));
        return sj.toString();
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
