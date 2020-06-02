package com.board.DTO.Board;

import com.board.Entity.Board.Board;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Getter
public class BoardListResDto {
    private Long id;
    private String title;
    private String content;
    private String createdAt;
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm");

    public BoardListResDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdAt = format.format(entity.getCreatedAt());
    }
}
