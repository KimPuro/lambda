package com.linus.api.board;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor

public class Board {
    private String title;
    private String content;
    private String writer;
    private int id;
    @Builder
    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
