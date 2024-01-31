package com.chandler.webservice.dto.posts;

import com.chandler.webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsSaveRequestDto {

    private final String title;
    private final String content;

    @Builder
    public PostsSaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .build();
    }

}
