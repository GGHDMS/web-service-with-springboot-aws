package study.webservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.webservice.service.PostsService;
import study.webservice.web.dto.PostsResponseDto;
import study.webservice.web.dto.PostsSaveRequestDto;
import study.webservice.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

   @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto search(@PathVariable Long id) {
       return postsService.search(id);
    }


}
