package com.backend.yourssu.board.domain.dto;

import lombok.Data;

@Data
public class BoardRequestDto {
    private Long boardId;
    private Long memberId;
}
