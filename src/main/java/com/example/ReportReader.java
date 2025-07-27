package com.example;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportReader {

    public static MonthlyReport getMouthlyReport(int year, int month) {
        String file = readFileContentsOrNull("src/main/resources/" + "m." + year + month + ".csv");
        MonthlyReport report = new MonthlyReport();

        if (file != null) {
            String[] lines = file.split("\\n");

            for (String line : lines) {
                String[] lineContents = line.split(",");
                String itemName = lineContents[0];
                Boolean isExpense = Boolean.parseBoolean(lineContents[1]);
                Integer quantity = Integer.parseInt(lineContents[2]);
                BigDecimal sumOfOne = BigDecimal.valueOf(Double.parseDouble(lineContents[3]));
                report.addRecord(itemName, isExpense, quantity, sumOfOne);
            }
        }

        return report;
    }

    public static YearlyReport getYearlyReport(int year) {
        String file = readFileContentsOrNull("src/main/resources/" + "y." + year + ".csv");
        YearlyReport report = new YearlyReport();

        if (file != null) {
            String[] lines = file.split("\\n");

            for (String line : lines) {
                String[] lineContents = line.split(",");
                Integer month = Integer.parseInt(lineContents[0]);
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(lineContents[1]));
                Boolean isExpense = Boolean.parseBoolean(lineContents[2]);
                report.addRecord(month, amount, isExpense);
            }
        }

        return report;
    }

    private static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
            return null;
        }
    }
}
