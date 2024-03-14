package com.linus.api.enums;

import com.linus.api.account.AccountView;
import com.linus.api.article.ArticleView;
import com.linus.api.board.Board;
import com.linus.api.board.BoardView;
import com.linus.api.crawler.CrawlerView;
import com.linus.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.function.Function;
import java.util.Scanner;
import java.util.stream.Stream;

public enum NavigationOfFunction {
    Exit("x", i -> "x"),
    User("u", i -> {
        UserView.main(i);
        return "";
    }),
    Board("b", i -> {
        BoardView.main();
        return "";
    }),
    Account("ac", i -> {
        AccountView.main(i);
        return "";
    }),
    Crawler("c", i -> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }),
    Article("ar", i -> {
        try {
            ArticleView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    });


    private final String name;
    private final Function<Scanner, String> function;
    NavigationOfFunction(String name, Function<Scanner, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String select(Scanner sc) {
        System.out.println("=== x-Exit " +
                "u-User " +
                "b-Board " +
                "ac-Account " +
                "c-Crawler " +
                "ar-Article" +
                "===");
        String selectedMenu = sc.next();
        System.out.println("선택한 메뉴" + selectedMenu);

        return Stream.of(values())
                .filter(i -> i.name.equals(selectedMenu))
                .findAny()
                .orElseGet(()->Exit)
                .function.apply(sc)
                ;
    }
}
