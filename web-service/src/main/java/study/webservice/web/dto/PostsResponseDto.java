package study.webservice.web.dto;

import lombok.Builder;
import study.webservice.domain.posts.Posts;

@Builder
public record PostsResponseDto(
        Long id,
        String title,
        String content,
        String author
) {
    public static PostsResponseDto from(Posts entity) {
        return PostsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .author(entity.getAuthor())
                .build();
    }
}
