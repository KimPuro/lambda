package article;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Article {
    private String title;
    private String content;
    private String writer;
    private Long id;
    @Builder
    public Article(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
