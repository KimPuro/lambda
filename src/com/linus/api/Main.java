package com.linus.api;

/*import com.linus.api.account.AccountView;
import com.linus.api.article.ArticleView;
import com.linus.api.board.BoardView;
import com.linus.api.crawler.CrawlerView;
import com.linus.api.enums.NavigationOfFunction;
import com.linus.api.user.UserView;*/

import com.linus.api.enums.NavigationOfFunction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
//        NavigationOfConsumer.select(sc);
        NavigationOfFunction.select(sc);
        while (NavigationOfFunction.select(sc).equals(""));
//        NavigationOfPredicate.select(sc);
//        NavigationOfSupplier.select(sc);

/*        while (true){
            System.out.println("=== x-Exit " +
                    "u-User " +
                    "b-Board " +
                    "ac-Account " +
                    "c-Crawler " +
                    "ar-Article" +
                    "===");
            switch (sc.next()){
                case "0":  return;
                case "1": UserView.main(sc);break;
                case "2": BoardView.main(); break;
                case "3": AccountView.main(sc); break;
                case "4": CrawlerView.main(sc); break;
                case "5": ArticleView.main(sc); break;
            }
        }*/
    }
}