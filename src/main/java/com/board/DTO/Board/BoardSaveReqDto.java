package com.board.DTO.Board;

import com.board.Entity.Board.Board;
import lombok.*;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class BoardSaveReqDto {
    private String title;
    private String content;

    @Builder
    public BoardSaveReqDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board toEntity(){
        return Board.builder().title(this.title).content(this.content).build();
    }
}
