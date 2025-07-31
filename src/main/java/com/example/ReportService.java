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

        for (int i = 0; i < monthlyReports.size(); i++) {
            MonthlyReport report = monthlyReports.get(i);

            var mostProfitableRecord = report.getMostProfitableProduct();
            var biggestWasteRecord = report.getBiggestWasteProduct();

            System.out.println(mostProfitableRecord);
            System.out.println(biggestWasteRecord);

            System.out.printf("Месяц %d, самый прибыльный товар %s на сумму %d руб, трата %s на сумму %d руб",
                    i,
                    mostProfitableRecord.getItemName(),
                    mostProfitableRecord.getSumOfOne() * mostProfitableRecord.getQuantity(),
                    biggestWasteRecord.getItemName(),
                    biggestWasteRecord.getSumOfOne() * biggestWasteRecord.getQuantity());
        }
    }

    public void printYearlyReportInfo() {

    }
}
