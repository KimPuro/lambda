package crawler;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import org.jsoup.nodes.Element;
import java.util.Iterator;

public class CrawlerView {
    public static void main(Scanner sc) throws IOException {
        CrawlerController controller = new CrawlerController();
        while(true){
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-벅스  " +
                    "2-멜론  " +
                    "3-ID검색  " +
                    "4-비번변경  " +
                    "5-탈퇴  " +
                    "6-회원목록  " +
                    "7-이름검색  " +
                    "8-직업검색  " +
                    "9-회원수");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-벅스 뮤직");
                    Map<String, ?> bugsMap = controller.findBugsMusic(sc);
                    System.out.println(bugsMap);
                    break;
                case "2":
                    System.out.println("2-멜론");
                    Map<String, ?> melonMap = controller.findMelonMusic(sc);
                    System.out.println(melonMap);
                    break;
                case "3":
                    System.out.println("3-ID 검색");
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    break;
                case "5":
                    System.out.println("5-탈퇴 : 탈퇴할 ID를 입력하세요");
                    break;
                case "6":
                    System.out.println("6-회원목록");
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    break;
                case "9":
                    System.out.println("9-회원수");
            }

        }

    }
}