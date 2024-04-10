package com.example.spring_mybatis_board.board.mapper;

import com.example.spring_mybatis_board.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardMapper {
    int boardInsert(Board board);

    List<Board> boardFindAll();

    Board boardDetail(Long id);
    
    List<Board> boardSearch(String searchkey);

    void boardDelete(Long id);

}
