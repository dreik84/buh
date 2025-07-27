package com.example;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

    private List<MonthlyReport> monthlyReports;
    private List<YearlyReport> yearlyReports;

    public ReportService() {
        monthlyReports = new ArrayList<>();
        yearlyReports = new ArrayList<>();
    }

    public void readAllMonthlyReports(int year) {
        for (int i = 1; i < 12; i++) {
            monthlyReports.add(ReportReader.getMouthlyReport(year, i));
        }
    }

    public void readYearlyReport(int year) {
        yearlyReports.add(ReportReader.getYearlyReport(year));
    }

    public void compareReports() {

    }

    public void printMonthlyReportsInfo() {

    }

    public void printYearlyReportInfo() {

    }
}
