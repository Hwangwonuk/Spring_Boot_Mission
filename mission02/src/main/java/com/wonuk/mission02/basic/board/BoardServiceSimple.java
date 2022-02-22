package com.wonuk.mission02.basic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceSimple implements BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceSimple.class);
    private final BoardRepository boardRepository;

    public BoardServiceSimple(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void createPost(BoardDto dto) {
        if (!this.boardRepository.save(dto)) {
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<BoardDto> readPostAll() {
        return this.boardRepository.findAll();
    }

    @Override
    public BoardDto readPost(int boardId) {
        return this.boardRepository.findById(boardId);
    }

    @Override
    public void updatePost(int boardId, BoardDto dto) {
        this.boardRepository.update(boardId, dto);
    }

    @Override
    public void deletePost(int boardId) {
        this.boardRepository.delete(boardId);
    }
}
