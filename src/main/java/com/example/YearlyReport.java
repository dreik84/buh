package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class YearlyReport {

    private final List<YearlyRecord> records;

    public YearlyReport() {
        records = new ArrayList<>();
    }

    public void addRecord(Integer month, Double amount, Boolean isExpense) {
        YearlyRecord record = new YearlyRecord(month, amount, isExpense);
        records.add(record);
    }

    public Double getTotalByMonth(int month) {
        Double total = 0.0;

        for (YearlyRecord record : records) {
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

    public static class YearlyRecord {
        private final Integer month;
        private final Double amount;
        private final Boolean isExpense;

        YearlyRecord(Integer month, Double amount, Boolean isExpense) {
            this.month = month;
            this.amount = amount;
            this.isExpense = isExpense;
        }

        public Integer getMonth() {
            return month;
        }

        public Double getAmount() {
            return amount;
        }

        public Boolean getExpense() {
            return isExpense;
        }

        @Override
        public String toString() {
            return "YearlyRecord{" +
                    "month=" + month +
                    ", amount=" + amount +
                    ", isExpense=" + isExpense +
                    '}';
        }
    }
}
