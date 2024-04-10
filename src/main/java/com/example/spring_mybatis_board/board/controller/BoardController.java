package com.example.spring_mybatis_board.board.controller;


import com.example.spring_mybatis_board.board.dto.BoardDTO;
import com.example.spring_mybatis_board.board.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/insertForm")
    public String insertForm(){
        return "board/insertForm";
    }


    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody BoardDTO boardDTO){
        log.info("goddd " + String.valueOf(boardDTO));
        try {
            int update = boardService.boardInsert(boardDTO);
            if(update > 0){
                return ResponseEntity.ok().body("Insert successful");
            } else {
                return ResponseEntity.badRequest().body("Insert failed");
            }
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }


    @GetMapping("/list")
    public String list(Model model){

        List<BoardDTO> boards = boardService.boardFindAll();

        model.addAttribute("list", boards);

        return "board/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.boardDetail(id);

        model.addAttribute("board", boardDTO);

        return "/board/view";
    }

}
