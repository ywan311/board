package com.board.Controller.Board;

import com.board.DTO.Board.BoardSaveReqDto;
import com.board.Service.Board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    //CRUD
    @PostMapping("board/save")
    public String save(BoardSaveReqDto boardSaveReqDto){
        System.out.println(boardSaveReqDto.toString());
        Long id = boardService.save(boardSaveReqDto);
        return "redirect:board";
    }
    @GetMapping("board")
    public ModelAndView list(ModelAndView mv){
        boardService.findAll().stream().map(boardListResDto -> mv.addObject(boardListResDto.getId().toString(),boardListResDto));
        mv.setViewName("board");
        return mv;
    }
    @GetMapping("board/save")
    public ModelAndView getSave(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board-save");
        return mv;
    }
}
