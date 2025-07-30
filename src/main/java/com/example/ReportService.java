package com.example;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private final List<MonthlyReport> monthlyReports;
    private final List<YearlyReport> yearlyReports;

    public ReportService() {
        monthlyReports = new ArrayList<>();
        yearlyReports = new ArrayList<>(12);
    }

    public void readAllMonthlyReports(int year) {
        for (int i = 0; i < 12; i++) {
            monthlyReports.add(ReportReader.getMouthlyReport(year, i));
        }
    }

    public void readYearlyReport(int year) {
        yearlyReports.add(ReportReader.getYearlyReport(year));
    }

    public void compareReports() {

        System.out.println(monthlyReports);
        System.out.println(yearlyReports);

        for (int i = 0; i < 12; i++) {
            Double yearlyTotal = yearlyReports.get(0).getTotalByMonth(i);
            Double monthlyTotal = monthlyReports.get(i).getTotal();
            if (!yearlyTotal.equals(monthlyTotal)) {
                System.out.println("Расхождение в отчётах за " + i + " месяц");
            }
        }
    }

    public void printMonthlyReportsInfo() {
        double maxProfitable = 0.0;
        int maxIndex = 0;

        for (MonthlyReport report : monthlyReports) {
            var records = report.getRecords();

            var mostProfitableRecord = report.getMostProfitableProduct();
            var biggestWasteRecord = report.getBiggestWasteProduct();

            for (int i = 0; i < records.size(); i++) {
                var record = records.get(i);
                double curProfitable = record.getQuantity() * record.getSumOfOne();

                if (maxProfitable < curProfitable) {
                    maxProfitable = curProfitable;
                    maxIndex = i;
                }
            }
        }
    }

    public void printYearlyReportInfo() {

    }
}
