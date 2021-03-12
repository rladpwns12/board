package com.backend.yourssu.board.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateBoardDto {
    private Long boardId;
    private Long memberId;
    private String title;
    private String content;

}
