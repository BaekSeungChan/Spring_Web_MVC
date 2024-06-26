package com.example.spring_mybatis_board.board.service;

import com.example.spring_mybatis_board.board.domain.Board;
import com.example.spring_mybatis_board.board.dto.BoardDTO;
import com.example.spring_mybatis_board.board.mapper.BoardMapper;
import com.example.spring_mybatis_board.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    ModelMapper modelMapper = MapperUtil.INSTANCE.get();

    public int boardInsert(BoardDTO boardDTO){
        Board board = modelMapper.map(boardDTO, Board.class);

        int updated = boardMapper.boardInsert(board);

        return updated;
    }

    public List<BoardDTO> boardFindAll(){
        List<Board> boardList = boardMapper.boardFindAll();

        return boardList.stream().map(vo -> modelMapper.map(vo, BoardDTO.class))
                .collect(Collectors.toList());
    }

    public BoardDTO boardDetail(Long id){
        Board board = boardMapper.boardDetail(id);

        return modelMapper.map(board, BoardDTO.class);
    }

}
