package com.board.Controller.Board;

import com.board.DTO.Board.BoardSaveReqDto;
import com.board.DTO.Board.BoardUpdateReqDto;
import com.board.Entity.Board.Board;
import com.board.Entity.Board.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

    private List<Board> tests = new ArrayList<>();

    @After
    public void clean(){
        boardRepository.deleteAll(tests);
    }

    @Test
    public void board_등록(){
        String title="title";
        String content="content";
        BoardSaveReqDto dto = BoardSaveReqDto.builder().title(title).content(content).build();
        String url = "http://localhost:"+port+"api/v1/board";

        ResponseEntity<Long> res = restTemplate.postForEntity(url,dto,Long.class);

        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(res.getBody()).isGreaterThan(0L);

        List<Board> list = boardRepository.findAll();
        Board test = list.get(list.size()-1);

        Assertions.assertThat(test.getTitle()).isEqualTo(title);
        Assertions.assertThat(test.getContent()).isEqualTo(content);

        tests.add(test);
    }
    @Test
    public void board_수정(){
        Board input = boardRepository.save(Board.builder().title("title").content("content").build());
        Long updatedId = input.getId();
        String updateTitle="updateT";
        String updateContent="updateC";

        BoardUpdateReqDto dto = BoardUpdateReqDto.builder().title(updateTitle).content(updateContent).build();
        String url = "http://localhost:"+port+"api/v1/board/"+updatedId;

        HttpEntity<BoardUpdateReqDto> reqEntity = new HttpEntity<>(dto);
        System.out.println(reqEntity.toString());
        ResponseEntity<Long> resEntity = restTemplate.exchange(url,HttpMethod.PUT,reqEntity,Long.class);

        Assertions.assertThat(resEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(resEntity.getBody()).isGreaterThan(0L);

        List<Board> list = boardRepository.findAll();
        Board test = list.get(list.size()-1);

        Assertions.assertThat(test.getTitle()).isEqualTo(updateTitle);
        Assertions.assertThat(test.getContent()).isEqualTo(updateContent);

        tests.add(test);
    }
}
