package com.wonuk.mission02.basic.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("{boardId}/posts")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final PostService postService;

    public PostRestController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createPost(@PathVariable("boardId") int boardId,
                           @RequestBody PostDto post) {
        logger.info(post.toString());
        post.setBoardId(boardId);
        this.postService.createPost(post);
    }

    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read all");
        return this.postService.readPostAll();
    }

    @GetMapping("/{postId}")
    public PostDto readPostOne(@PathVariable("postId") int postId) {
        logger.info("in read one");
        return this.postService.readPost(postId);
    }

    @PostMapping("/{postId}")
    public void updatePost(
            @RequestBody PostDto post,
            @PathVariable("postId") int postId) {
        logger.info("target id: " + postId);
        logger.info("update content" + post);
        this.postService.updatePost(postId, post);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(PostDto postDto) {
        this.postService.deletePost(postDto);
    }
}