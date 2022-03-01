package com.wonuk.mission02.basic.board;

import java.util.Collection;
import java.util.List;

public interface BoardRepository {
    BoardDto create(BoardDto dto);
    BoardDto read(Long id);
    Collection<BoardDto> readAll();
    boolean update(Long id, BoardDto dto);
    boolean delete(Long id);
}
