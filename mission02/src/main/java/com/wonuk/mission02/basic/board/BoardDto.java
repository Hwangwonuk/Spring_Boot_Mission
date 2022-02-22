package com.wonuk.mission02.basic.board;

public class BoardDto {
    private int boardId;
    private String boardName;

    @Override
    public String toString() {
        return "BoardDto{" +
                "boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                '}';
    }

    public BoardDto() {
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public BoardDto(int boardId, String boardName) {
        this.boardId = boardId;
        this.boardName = boardName;
    }
}
