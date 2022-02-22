package com.wonuk.mission02.basic.post;

import java.util.List;

public interface PostRepository {
    boolean save(PostDto dto);
    List<PostDto> findAll();
    PostDto findById(int id);
    boolean update(int id, PostDto dto);
    boolean delete(PostDto postDto);
}