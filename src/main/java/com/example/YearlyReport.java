package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class YearlyReport {

    private final List<YearlyRecord> records;
    @Getter
    private final int year;

    public YearlyReport(int year) {
        this.year = year;
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

    public String getProfit() {
        StringBuilder profit = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            double res = 0.0;

            for (YearlyRecord record : findByMonth(i)) {
                res += (record.isExpense) ? -record.getAmount() : record.getAmount();
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

    public String getAverageExpense() {
        double expense = 0.0;

        for (YearlyRecord record : records) {
            if (record.isExpense) {
                expense += record.getAmount();
            }
        }

        return new DecimalFormat("#.##").format(expense / 12);
    }

    public double getAverageProfit() {
        double expense = 0.0;

        for (YearlyRecord record : records) {
            if (!record.isExpense) {
                expense += record.getAmount();
            }
        }

        return Math.round(expense / 12 * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");

        records.forEach(record -> sj.add("Месяц " + record.month + " " + getTotalByMonth(record.month)));
        return sj.toString();
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class YearlyRecord {
        private final Integer month;
        private final Double amount;
        private final Boolean isExpense;
    }
}
