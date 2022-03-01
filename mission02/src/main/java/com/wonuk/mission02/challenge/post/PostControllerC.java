package com.wonuk.mission02.challenge.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("board/{boardId}/post")
public class PostControllerC {
    private static final Logger logger = LoggerFactory.getLogger(PostControllerC.class);
    private final PostRepositoryC postRepositoryC;

    public PostControllerC(@Autowired PostRepositoryC postRepositoryC) {
        this.postRepositoryC = postRepositoryC;
    }

    @PostMapping
    public ResponseEntity<PostDtoC> createPost(
            @PathVariable("boardId") Long boardId,
            @RequestBody PostDtoC dto
    ) {
        PostDtoC result = this.postRepositoryC.create(boardId, dto);
        return ResponseEntity.ok(result.passwordMasked());
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDtoC> readPost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId
    ) {
        PostDtoC postDtoC = this.postRepositoryC.read(boardId, postId);
        if (postDtoC == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(postDtoC.passwordMasked());
    }

    @GetMapping
    public ResponseEntity<Collection<PostDtoC>> readPostAll(
            @PathVariable("boardId") Long boardId) {
        Collection<PostDtoC> postList = this.postRepositoryC.readAll(boardId);
        if (postList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(postList);
    }

    @PutMapping("{postId}")
    public ResponseEntity<?> updatePost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId,
            @RequestBody PostDtoC dto
    ) {
        if (!postRepositoryC.update(boardId, postId, dto))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(
        @PathVariable("boardId") Long boardId,
        @PathVariable("postId") Long postId,
        @RequestParam("password") String password
    ) {
        if (!postRepositoryC.delete(boardId, postId, password))
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}