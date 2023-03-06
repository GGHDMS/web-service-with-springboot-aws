package study.webservice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.webservice.domain.posts.Posts;
import study.webservice.domain.posts.PostsRepository;
import study.webservice.web.dto.PostsResponseDto;
import study.webservice.web.dto.PostsSaveRequestDto;
import study.webservice.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        System.out.println("id = " + id);
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 사용자가 없습니다. id = " + id));
        posts.update(requestDto.title(), requestDto.content());
        return id;
    }

    public PostsResponseDto search(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 사용자가 없습니다. id = " + id));

        return PostsResponseDto.from(posts);
    }
}
