package com.example.spring_mybatis_board.board.mapper;

import com.example.spring_mybatis_board.board.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class BoardMapperTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void boardInsertTest(){
        Board board = Board.builder()
                .title("hi")
                .content("good")
                .writer("chan")
                .dueDate(Date.valueOf(LocalDate.now()).toLocalDate())
                .userid("qwer")
                .build();

        int updated = boardMapper.boardInsert(board);

        log.info("updated : " + updated);

    }

    @Test
    public void boardFindAllTest(){
        List<Board> list = boardMapper.boardFindAll();

        for(Board board : list){
            log.info(String.valueOf(board));
        }
    }

    @Test
    public void boardDetailTest(){
        Long id = 115L;

        Board board = boardMapper.boardDetail(id);

        log.info(String.valueOf(board));
    }

    @Test
    public void boardSearchKeyTest(){
        String searchkey = "굿";

        List<Board> list = boardMapper.boardSearch(searchkey);

        for(Board board : list){
            log.info(String.valueOf(board));
        }
    }

    @Test
    public void boardDelete(){
        Long id = 115L;

        boardMapper.boardDelete(id);
    }
}