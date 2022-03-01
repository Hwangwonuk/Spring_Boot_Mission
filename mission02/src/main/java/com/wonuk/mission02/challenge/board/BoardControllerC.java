package com.wonuk.mission02.challenge.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("board")
public class BoardControllerC {
    private static final Logger logger = LoggerFactory.getLogger(BoardControllerC.class);
    private final BoardRepositoryC boardRepositoryC;

    public BoardControllerC(
            @Autowired BoardRepositoryC boardRepositoryC
    ) {
        this.boardRepositoryC = boardRepositoryC;
    }

    @PostMapping
    public ResponseEntity<BoardDtoC> createBoard(@RequestBody BoardDtoC dto) {
        return ResponseEntity.ok(boardRepositoryC.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<BoardDtoC> readBoard(
            @PathVariable("id") Long id
    ) {
        BoardDtoC dto = boardRepositoryC.read(id);
        if (dto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Collection<BoardDtoC>> readBoardAll() {
        return ResponseEntity.ok(this.boardRepositoryC.readAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBaord(
            @PathVariable("id") Long id,
            @RequestBody BoardDtoC dto
    ) {
        if (!boardRepositoryC.update(id, dto)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBoard(
            @PathVariable("id") Long id) {
        if (!boardRepositoryC.delete(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
