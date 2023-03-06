package study.webservice.web.dto;

import lombok.Builder;
import study.webservice.domain.posts.Posts;

@Builder
public record PostsSaveRequestDto(
        String title,
        String content,
        String author
) {
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
