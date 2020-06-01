package com.board.Entity.Board;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void board등록불러오기(){
        String title = "test";
        String content = "testContent";

        Long id =boardRepository.save(Board.builder().title(title).content(content).build()).getId();

        List<Board> list = boardRepository.findAll();

        Board test = list.get(0);
        Assertions.assertThat(test.getTitle()).isEqualTo(title);
        Assertions.assertThat(test.getContent()).isEqualTo(content);
        Assertions.assertThat(test.getId()).isEqualTo(id);
    }
}
