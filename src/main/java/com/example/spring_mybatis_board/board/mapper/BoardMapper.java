package com.example.spring_mybatis_board.board.mapper;

import com.example.spring_mybatis_board.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface BoardMapper {
    int boardInsert(Board board);
}
