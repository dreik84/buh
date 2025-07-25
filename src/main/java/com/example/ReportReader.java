package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportReader {

    public YearlyReport getYearlyReport(int year) {
        String file = readFileContentsOrNull("src/main/resources/" + "y." + year + ".csv");

        if (file != null) {
            String[] lines = file.split("\\n");

            for (String line : lines) {
                String[] lineContents = line.split(",");
            }
        }

        return new YearlyReport();
    }

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
            return null;
        }
    }
}
