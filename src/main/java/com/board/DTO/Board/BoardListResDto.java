package com.board.DTO.Board;

import com.board.Entity.Board.Board;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class BoardListResDto {
    private Long id;
    private String title;
    private String content;
    private String createdAt;

    public BoardListResDto(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt().format(DateTimeFormatter.ofPattern("MM/dd HH:mm"));
    }
}
