package com.chandler.webservice.controller;

import com.chandler.webservice.domain.posts.Posts;
import com.chandler.webservice.domain.posts.PostsRepository;
import com.chandler.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WebRestControllerTest {

    @Autowired
    private PostsRepository postsRepository;

    @Test
    @DisplayName("게시글 저장")
    void test1() throws Exception {
        //given
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title("게시글 제목")
                .content("게시글 내용")
                .build();

        //when
        postsRepository.save(requestDto.toEntity());

        //then
        List<Posts> result = postsRepository.findAll();

        assertEquals(1L, postsRepository.count());

        assertEquals("게시글 제목", result.get(0).getTitle());
        assertEquals("게시글 내용", result.get(0).getContent());
    }


}