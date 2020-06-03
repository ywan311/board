package com.board.Controller.Board;

import com.board.DTO.Board.BoardListResDto;
import com.board.DTO.Board.BoardResDto;
import com.board.DTO.Board.BoardSaveReqDto;
import com.board.DTO.Board.BoardUpdateReqDto;
import com.board.Service.Board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {//rest api controller
    private final BoardService boardService;
    //CRUD
    @GetMapping("api/v1/board")
    public List<BoardListResDto> getList(){
        return boardService.findAll();
    }
    @GetMapping("api/v1/board/{id}")
    public BoardResDto getUpdate(@PathVariable Long id){
        return boardService.findOne(id);
    }
    @PostMapping("api/v1/board")
    public Long add(@RequestBody BoardSaveReqDto dto){
        return boardService.save(dto);
    }
    @PutMapping("api/v1/board/{id}")
    public Long update(@RequestBody BoardUpdateReqDto dto,@PathVariable Long id){
        return boardService.update(id, dto);
    }
    @DeleteMapping("api/v1/board/{id}")
    public Long delete(@PathVariable Long id){
        boardService.delete(id);
        return id;
    }
}
