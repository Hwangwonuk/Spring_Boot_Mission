package com.wonuk.mission02.challenge.post;

import com.wonuk.mission02.challenge.board.BoardDtoC;
import com.wonuk.mission02.challenge.board.BoardRepositoryC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryPostRepositoryC implements PostRepositoryC {
    private final BoardRepositoryC boardRepositoryC;

    private Long lastIndex = 0L;
    private final Map<Long, PostDtoC> memory = new HashMap<>();

    public InMemoryPostRepositoryC(
            @Autowired BoardRepositoryC boardRepositoryC) {
        this.boardRepositoryC = boardRepositoryC;
    }

    @Override
    public PostDtoC create(Long boardId, PostDtoC dto) {
        BoardDtoC boardDtoC = this.boardRepositoryC.read(boardId);
        if (boardDtoC == null) {
            return null;
        }
        dto.setBoardId(boardId);
        lastIndex++;
        dto.setId(lastIndex);
        memory.put(lastIndex, dto);
        return dto;
    }

    @Override
    public PostDtoC read(Long boardId, Long postId) {
        PostDtoC postDtoC = memory.getOrDefault(postId, null);
        if (postDtoC == null) {
            return null;
        } else if (!Objects.equals(postDtoC.getBoardId(), boardId)) {
            return null;
        }
        return null;
    }

    @Override
    public Collection<PostDtoC> readAll(Long boardId) {
        if (boardRepositoryC.read(boardId) == null) return null;
        Collection<PostDtoC> postList = new ArrayList<>();
        memory.forEach((postId, postDtoC) -> {
            if (Objects.equals(postDtoC.getBoardId(), boardId))
                postList.add(postDtoC);
        });
        return postList;
    }

    @Override
    public boolean update(Long boardId, Long postId, PostDtoC dto) {
        PostDtoC targetPost = memory.getOrDefault(postId, null);
        if (targetPost == null) {
            return false;
        } else if (!Objects.equals(targetPost.getBoardId(), boardId)) {
            return false;
        } else if (!Objects.equals(targetPost.getPassword(), dto.getPassword())) {
            return false;
        }
        targetPost.setTitle(
                dto.getTitle() == null ? targetPost.getTitle() : dto.getTitle());
        targetPost.setContent(
                dto.getContent() == null ? targetPost.getContent() : dto.getContent());
        return true;
    }

    @Override
    public boolean delete(Long boardId, Long postId, String password) {
        PostDtoC targetPost = memory.getOrDefault(postId, null);
        if (targetPost == null) {
            return false;
        } else if (!Objects.equals(targetPost.getBoardId(), boardId)) {
            return false;
        } else if (!Objects.equals(targetPost.getPassword(), password)) {
            return false;
        }
        memory.remove(postId);
        return true;
    }
}