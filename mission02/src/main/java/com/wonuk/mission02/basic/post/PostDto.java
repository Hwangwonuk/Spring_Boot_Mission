package com.wonuk.mission02.basic.post;

public class PostDto {
    private int postId;
    private int boardId;
    private String password;
    private String title;
    private String content;
    private String writer;

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + postId +
                ", boardId='" + boardId + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    public PostDto() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public PostDto(int postId, int boardId, String password, String title, String content, String writer) {
        this.postId = postId;
        this.boardId = boardId;
        this.password = password;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}