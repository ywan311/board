package com.board.DTO.Board;

import com.board.Entity.Board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateReqDto {
    private String title;
    private String content;

    @Builder
    public BoardUpdateReqDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
