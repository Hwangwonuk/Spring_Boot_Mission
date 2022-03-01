package com.wonuk.mission02.challenge.post;

import java.util.Collection;

public interface PostRepositoryC {
    PostDtoC create(Long boardId, PostDtoC dto);
    PostDtoC read(Long boardId, Long postId);
    Collection<PostDtoC> readAll(Long boardId);
    boolean update(Long boardId, Long postId, PostDtoC dto);
    boolean delete(Long boardId, Long postId, String password);
}