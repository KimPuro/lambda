package com.linus.api.enums;

import com.linus.api.user.User;
import com.linus.api.user.UserController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public enum UserRouter {
    SIGN_UP("1", scanner -> {
        System.out.println("회원가입 결과: " + UserController.getInstance().save(scanner));}),
    LOG_IN("2", scanner -> {
        System.out.println("로그인 결과: " + UserController.getInstance().login(scanner));
    }),
    IDENTIFY("3", scanner -> {
        System.out.println("ID 검색 결과: " + UserController.getInstance().findUsersByNameFromMap(scanner));
    }),
    CHANGE_PASSWORD("4", scanner -> {
        System.out.println("비밀번호 변경 결과: " + UserController.getInstance().updatePassword(scanner));
    }),
    DELETE_ACCOUNT("5", scanner -> {
        System.out.println("탈퇴 결과: " + UserController.getInstance().delete(scanner));
    }),
    USER_LIST("ls", scanner -> {
        List<User> users = UserController.getInstance().findAll();
        users.forEach(System.out::println);
    }),
    SEARCH_BY_NAME("7", scanner -> {
        System.out.println("이름 검색 결과: " + UserController.getInstance().findUsersByName(scanner).toString());
    }),
    SEARCH_BY_JOB("8", scanner -> {
        System.out.println("직업 검색 결과: " + UserController.getInstance().findUsersByJob(scanner).toString());
    }),
    USER_COUNT("9", scanner -> {
        UserController controller = UserController.getInstance();
        int count = Integer.parseInt(controller.count());
        System.out.println("회원 수: " + count);
    }),
    CREATE_TABLE("touch", scanner -> {
        System.out.println("테이블 생성 결과: " + UserController.getInstance().createTable());
    }),
    DELETE_TABLE("rm", scanner -> {
        UserController controller = UserController.getInstance();
        String msg = null;
        try {
            msg = controller.dropTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("테이블 삭제 결과: " + msg);
    }),
    EXIT("0", scanner -> {
        System.out.println("종료");
        System.exit(0);
    }),
    DEFAULT("", scanner -> System.out.println("Invalid option"));

    private final String command;
    private final Consumer<Scanner> action;

    UserRouter(String command, Consumer<Scanner> action) {
        this.command = command;
        this.action = action;
    }

    public void execute(Scanner scanner) {
        this.action.accept(scanner);
    }

    public static UserRouter getRouter(String command) {
        return Stream.of(values())
                .filter(c -> c.command.equals(command))
                .findFirst()
                .orElse(UserRouter.DEFAULT);
    }
}