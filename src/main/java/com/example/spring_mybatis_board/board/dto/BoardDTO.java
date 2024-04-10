package com.example.spring_mybatis_board.board.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;

    private String searchKey;

    @Builder.Default
    private LocalDate dueDate = LocalDate.parse("2024-04-19");

    @Builder.Default
    private String userid = "qwer";
}