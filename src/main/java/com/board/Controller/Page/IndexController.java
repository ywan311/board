package com.board.Controller.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
    @GetMapping("")
    public String home(){
        return "index";
    }
    @GetMapping("board/save")
    public String addBoard(){
        return "board-save";
    }
//
//    @GetMapping("board/update/{id}")
//    public String updateBoard(@PathVariable Long id){
//        return "board-update";
//    }
}
