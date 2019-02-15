package com.clive.support;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

public class Formatters {
    public static String getFormattedLocalDate(LocalDate date) {
        return date.format(ofPattern("MM/dd/yyyy"));
    }
}
