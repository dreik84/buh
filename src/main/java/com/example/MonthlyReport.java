package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {

    List<Record> list;

    public MonthlyReport() {
        list = new ArrayList<>();
    }

    public void addRecord(String itemName, Boolean isExpense, Integer quantity, BigDecimal sumOfOne) {
        Record record = new Record(itemName, isExpense, quantity, sumOfOne);
        list.add(record);
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
