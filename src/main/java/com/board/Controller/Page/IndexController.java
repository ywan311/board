package com.board.Controller.Page;

import com.board.Service.Board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final BoardService boardService;
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("boards",boardService.findAll());
        return "index";
    }
    @GetMapping("board/save")
    public String addBoard(){
        return "board-save";
    }

    @GetMapping("board/update/{id}")
    public String updateBoard(@PathVariable Long id,Model model){
        return "board-update";
    }
}
