package com.example;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private final List<MonthlyReport> monthlyReports;
    private final YearlyReport yearlyReport;

    public ReportService() {
        monthlyReports = new ArrayList<>();
        yearlyReport = null;
    }

    public void readAllMonthlyReports(int year) {
        for (int i = 0; i < 12; i++) {
            monthlyReports.add(ReportReader.getMouthlyReport(year, i));
        }
    }

    public void readYearlyReport(int year) {
        ReportReader.getYearlyReport(year);
    }

    public void compareReports() {

        System.out.println(monthlyReports);
        System.out.println(yearlyReport);

        for (int i = 0; i < 12; i++) {
            Double yearlyTotal = yearlyReport.getTotalByMonth(i);
            Double monthlyTotal = monthlyReports.get(i).getTotal();
            if (!yearlyTotal.equals(monthlyTotal)) {
                System.out.println("Расхождение в отчётах за " + i + " месяц");
            }
        }
    }

    public void printMonthlyReportsInfo() {

        for (int i = 0; i < monthlyReports.size(); i++) {
            MonthlyReport report = monthlyReports.get(i);
            String resLine = "Месяц " + i;

            var mostProfitable = report.getMostProfitableProduct();
            var biggestWaste = report.getBiggestWasteProduct();

            resLine += ", самый прибыльный товар: ";
            resLine += (mostProfitable == null) ? null : mostProfitable.getItemName() + " на сумму: " +
                    mostProfitable.getSumOfOne() * mostProfitable.getQuantity();

            resLine += ", самая большая трата: ";
            resLine += (biggestWaste == null) ? null : biggestWaste.getItemName() + " на сумму: " +
                    biggestWaste.getSumOfOne() * biggestWaste.getQuantity() + " .";

            System.out.println(resLine);
        }
    }

    public void printYearlyReportInfo() {
        String resLine = "Год: ";

        resLine += (yearlyReport == null) ? null : yearlyReport.getYear();

        System.out.println(resLine);
    }
}
