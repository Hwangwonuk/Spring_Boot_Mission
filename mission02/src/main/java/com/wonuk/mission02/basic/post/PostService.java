package com.wonuk.mission02.basic.post;

import java.util.List;

public interface PostService {
    void createPost(PostDto dto);
    List<PostDto> readPostAll();
    PostDto readPost(int postId);
    void updatePost(int postId, PostDto dto);
    void deletePost(PostDto postDto);
}
