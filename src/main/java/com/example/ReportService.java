package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private List<MonthlyReport> monthlyReports;
    private List<YearlyReport> yearlyReports;

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
            BigDecimal yearlyTotal = yearlyReports.get(0).getTotalByMonth(i);
            BigDecimal monthlyTotal = monthlyReports.get(i).getTotal();
            if (!yearlyTotal.equals(monthlyTotal)) {
                System.out.println("Расхождение в отчётах за " + i + " месяц");
            }
        }
    }

    public void printMonthlyReportsInfo() {

    }

    public void printYearlyReportInfo() {

    }
}
