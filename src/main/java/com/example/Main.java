package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportService service = new ReportService();

        printMenu();
        int input = scanner.nextInt();

        while (input != 0) {

            switch (input) {
                case 1:
                    System.out.print("Укажите год: ");
                    service.readAllMonthlyReports(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Укажите год: ");
                    service.readYearlyReport(scanner.nextInt());
                    break;
                case 3:
                    service.compareReports();
                    break;
                case 4:
                    service.printMonthlyReportsInfo();
                    break;
                case 5:
                    service.printYearlyReportInfo();
                    break;
                default:
                    System.out.println("Неверно указан пункт меню");
            }

            printMenu();
            input = scanner.nextInt();
        }

        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        String[] menuItems = {
                "Выйти из программы",
                "Считать все месячные отчёты",
                "Считать годовой отчёт",
                "Сверить отчёты",
                "Вывести информацию о всех месячных отчётах",
                "Вывести информацию о годовом отчёте"
        };

        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%d. %s \n", i, menuItems[i]);
        }

        System.out.print("Введите пункт меню: ");
    }
}
