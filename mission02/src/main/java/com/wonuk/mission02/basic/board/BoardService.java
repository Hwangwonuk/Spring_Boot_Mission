package com.wonuk.mission02.basic.board;

import java.util.List;

public interface BoardService {
    void createPost(BoardDto dto);
    List<BoardDto> readPostAll();
    BoardDto readPost(int boardId);
    void updatePost(int boardId, BoardDto dto);
    void deletePost(int boardId);
}
