package com.wonuk.mission02.challenge.board;

import java.util.Collection;

public interface BoardRepositoryC {
    BoardDtoC create(BoardDtoC dto);
    BoardDtoC read(Long id);
    Collection<BoardDtoC> readAll();
    boolean update(Long id, BoardDtoC dto);
    boolean delete(Long id);
}
