package com.wonuk.mission02.challenge.board;

import java.util.List;

public interface BoardRepository {
    boolean save(BoardDto dto);
    List<BoardDto> findAll();
    BoardDto findById(int boardId);
    boolean update(int boardId, BoardDto dto);
    boolean delete(int boardId);
}
