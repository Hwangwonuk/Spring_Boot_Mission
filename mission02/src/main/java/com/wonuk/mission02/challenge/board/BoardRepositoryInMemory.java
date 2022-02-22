package com.wonuk.mission02.challenge.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepositoryInMemory implements BoardRepository {
    private static final Logger logger = LoggerFactory.getLogger(BoardRepositoryInMemory.class);
    private final List<BoardDto> boardList;

    public BoardRepositoryInMemory() {
        this.boardList = new ArrayList<>();
    }

    @Override
    public boolean save(BoardDto dto) {
        return this.boardList.add(dto);
    }

    @Override
    public List<BoardDto> findAll() {
        return this.boardList;
    }

    @Override
    public BoardDto findById(int boardId) {
        return this.boardList.get(boardId);
    }

    @Override
    public boolean update(int boardId, BoardDto dto) {
        BoardDto targetBoard = this.boardList.get(boardId);
        if (dto.getBoardName() != null) {
            targetBoard.setBoardName(dto.getBoardName());
        }
        this.boardList.set(boardId, targetBoard);
        return true;
    }

    @Override
    public boolean delete(int boardId) {
        this.boardList.remove(boardId);
        return true;
    }
}
