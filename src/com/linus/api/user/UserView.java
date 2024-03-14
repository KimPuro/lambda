package com.linus.api.user;

import com.linus.api.enums.UserRouter;

import java.util.Scanner;

public class UserView {
    public static void main(Scanner args) {
        Scanner scanner = new Scanner(System.in);
        UserController controller = UserController.getInstance();
        String msg = controller.addUsers();
        System.out.println("addUsers 결과: " + msg);

        while (true) {
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-회원가입 " +
                    "2-로그인 " +
                    "3-ID검색 " +
                    "4-비번변경 " +
                    "5-탈퇴 " +
                    "ls-회원목록 " +
                    "7-이름검색 " +
                    "8-직업검색 " +
                    "9-회원수 " +
                    "touch-테이블생성 " +
                    "rm-테이블삭제" +
                    "");
            UserRouter.getRouter(scanner.next()).execute(scanner);
        }
    }
}