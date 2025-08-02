package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class YearlyReport {

    private final List<YearlyRecord> records;
    private final int year;

    public YearlyReport(int year) {
        this.year = year;
        records = new ArrayList<>();
    }

    public void addRecord(Integer month, Double amount, Boolean isExpense) {
        YearlyRecord record = new YearlyRecord(month, amount, isExpense);
        records.add(record);
    }

    public int getYear() {
        return year;
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

    public String getProfit() {
        StringBuilder profit = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            double res = 0.0;

            for (YearlyRecord record : findByMonth(i)) {
                res += (record.getExpense()) ? -record.getAmount() : record.getAmount();
            }
            profit.append("Месяц ").append(i).append(", прибыль: ").append(res).append(". ");
        }

        return profit.toString();
    }

    private List<YearlyRecord> findByMonth(int month) {
        List<YearlyRecord> list = new ArrayList<>();

        for (YearlyRecord record : records) {
            if (record.getMonth() == month) list.add(record);
        }

        return list;
    }

    public double getAverageExpense() {
        double expense = 0.0;

        for (YearlyRecord record : records) {
            if (record.isExpense) {
                expense += record.getAmount();
            }
        }

        return  Math.round(expense / 12);
    }

    public double getAverageProfit() {
        double expense = 0.0;

        for (YearlyRecord record : records) {
            if (!record.isExpense) {
                expense += record.getAmount();
            }
        }

        return Math.round(expense / 12);
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
