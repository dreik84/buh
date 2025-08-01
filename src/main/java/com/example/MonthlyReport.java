package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class MonthlyReport {

    private final List<MonthlyRecord> records;

    public MonthlyReport() {
        records = new ArrayList<>();
    }

    public void addRecord(String itemName, Boolean isExpense, Integer quantity, Double sumOfOne) {
        MonthlyRecord record = new MonthlyRecord(itemName, isExpense, quantity, sumOfOne);
        records.add(record);
    }

    public Double getTotal() {
        double total = 0.0;

        for (MonthlyRecord record : records) {
            if (record.isExpense) {
                total -= record.quantity * record.sumOfOne;
            } else {
                total += record.quantity * record.sumOfOne;
            }
        }

        return total;
    }

    public MonthlyRecord getMostProfitableProduct() {
        double prof = 0.0;
        MonthlyRecord res = null;

        for (MonthlyRecord record : records) {
            if (!record.getExpense()) {
                double curProf = record.getQuantity() * record.getSumOfOne();
                if (prof < curProf) {
                    prof = curProf;
                    res = record;
                }
            }
        }

        return res;
    }

    public MonthlyRecord getBiggestWasteProduct() {
        double waste = 0.0;
        MonthlyRecord res = null;

        for (MonthlyRecord record : records) {
            if (record.getExpense()) {
                double curWaste = record.getQuantity() * record.getSumOfOne();
                if (waste < curWaste) {
                    waste = curWaste;
                    res = record;
                }
            }
        }

        return res;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");

        records.forEach(record -> sj.add(record.itemName + " " +
                record.quantity + "*" + record.sumOfOne + "=" + getTotal()));

        return sj.toString();
    }

    public static class MonthlyRecord {
        private final String itemName;
        private final Boolean isExpense;
        private final Integer quantity;
        private final Double sumOfOne;

        public MonthlyRecord(String itemName, Boolean isExpense, Integer quantity, Double sumOfOne) {
            this.itemName = itemName;
            this.isExpense = isExpense;
            this.quantity = quantity;
            this.sumOfOne = sumOfOne;
        }

        public String getItemName() {
            return itemName;
        }

        public Boolean getExpense() {
            return isExpense;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Double getSumOfOne() {
            return sumOfOne;
        }

        @Override
        public String toString() {
            return "MonthlyRecord{" +
                    "itemName='" + itemName + '\'' +
                    ", isExpense=" + isExpense +
                    ", quantity=" + quantity +
                    ", sumOfOne=" + sumOfOne +
                    '}';
        }
    }
}
