package com.wonuk.mission02.challenge.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void createPost(@PathVariable("boardId") int boardId,
                           @ModelAttribute PostDto post) {
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