package com.wonuk.mission02.basic.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("boards")
public class BoardRestController {
    private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
    private final BoardService boardService;

    public BoardRestController(@Autowired BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody BoardDto boardDto) {
        logger.info(boardDto.toString());
        this.boardService.createPost(boardDto);
    }

    @GetMapping()
    public List<BoardDto> readBoardAll() {
        logger.info("in read post all");
        return this.boardService.readPostAll();
    }

    @GetMapping("{boardId}")
    public BoardDto readBoard(@PathVariable("boardId") int boardId) {
        logger.info("in read post");
        return this.boardService.readPost(boardId);
    }

    @PutMapping("{boardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(
            @PathVariable("boardId") int boardId,
            @RequestBody BoardDto boardDto
    ) {
        logger.info("target boardId: " + boardId);
        logger.info("update content" + boardDto);
        this.boardService.updatePost(boardId, boardDto);
    }

    @DeleteMapping("{boardId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("boardId") int boardId) {
        this.boardService.deletePost(boardId);
    }
}
