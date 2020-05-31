package com.board.Entity.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Board {
    @Id
    Long id;

    @Column
    String title;

    @Column
    String content;

    @Builder
    public Board(String title, String content) {
        this.title =title;
        this.content = content;
    }
}
