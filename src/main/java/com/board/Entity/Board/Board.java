package com.board.Entity.Board;

import com.board.Entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String content;

    @Builder
    public Board(String title, String content) {
        this.title =title;
        this.content = content;
    }

    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }
}
