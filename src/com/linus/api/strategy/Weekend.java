package com.linus.api.strategy;

import java.util.Scanner;

public class Weekend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeekendStrategyConsumer.execute(sc);
    }

  /*  private static void execute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String day = sc.next();
        String res = "";
        switch (day) {
            case "1":
                res="Monday";
                break;
            case "2":
                res="Tuesday";
                break;
            case "3":
                res="Wednesday";
                break;
            case "4":
                res="Thursday";
                break;
            case "5":
                res="Friday";
                break;
            case "6":
                res="Saturday";
                break;
            case "7":
                res="Sunday";
                break;
            default:
                res="Wrong";
                return;
        }
        System.out.println(res);
    }*/
}