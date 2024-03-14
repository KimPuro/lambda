package com.linus.api.strategy;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public enum WeekendStrategyConsumer {
    MONDAY("1", s -> System.out.println("Monday")),
    TUESDAY("2", s -> System.out.println("Tuesday")),
    WEDNESDAY("3", s -> System.out.println("Wednesday")),
    THURSDAY("4", s -> System.out.println("Thursday")),
    FRIDAY("5", s -> System.out.println("Friday")),
    SATURDAY("6", s -> System.out.println("Saturday")),
    SUNDAY("7", s -> System.out.println("Sunday")),
    WRONG("x", s -> System.out.println("Wrong"));

    private final String dayNumber;
    private final Consumer<String> printer;

    WeekendStrategyConsumer(String dayNumber, Consumer<String> printer) {
        this.dayNumber = dayNumber;
        this.printer = printer;
    }

    public static void execute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String input = sc.next();
        Stream.of(values())
                .filter(day -> day.dayNumber.equals(input))
                .findAny()
                .orElse(WRONG)
                .printer.accept(input);
    }
}