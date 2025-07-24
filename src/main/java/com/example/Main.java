package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMenu();
        int input = scanner.nextInt();

        while (input != 0) {

            // TODO

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
