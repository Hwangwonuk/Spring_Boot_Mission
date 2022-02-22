package com.wonuk.mission02.challenge.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryInMemory implements PostRepository {
    private static final Logger logger = LoggerFactory.getLogger(PostRepositoryInMemory.class);
    private final List<PostDto> postList;

    public PostRepositoryInMemory() {
        this.postList = new ArrayList<>();
    }

    @Override
    public boolean save(PostDto dto) {
        return this.postList.add(dto);
    }

    @Override
    public List<PostDto> findAll() {
        return this.postList;
    }

    @Override
    public PostDto findById(int id) {
        return this.postList.get(id);
    }

    @Override
    public boolean update(int id, PostDto dto) {
        PostDto targetPost = this.postList.get(id);
        if (targetPost.getTitle() != null) {
            targetPost.setTitle(dto.getTitle());
        }
        if (targetPost.getContent() != null) {
            targetPost.setContent(dto.getContent());
        }
        if (targetPost.getPassword() != null) {
            targetPost.setPassword(dto.getPassword());
        }
        if (targetPost.getWriter() != null) {
            targetPost.setWriter(dto.getWriter());
        }
        this.postList.set(id, targetPost);
        return true;
    }

    @Override
    public boolean delete(PostDto postDto) {
        if (postDto.getPassword().equals(findById(postDto.getPostId()).getPostId())) {
            this.postList.remove(postDto.getPostId());
        }
        return true;
    }

}