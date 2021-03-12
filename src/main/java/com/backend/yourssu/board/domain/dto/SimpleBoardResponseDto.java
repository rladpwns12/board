package com.backend.yourssu.board.domain.dto;

import com.backend.yourssu.board.domain.entity.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SimpleBoardResponseDto {
    private Long boardId;
    private String title;
    private String writer;
    private LocalDateTime createdAt;

    public static SimpleBoardResponseDto of(Board board) {
        return SimpleBoardResponseDto.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .writer(board.getMember().getNickname())
                .createdAt(board.getCreatedAt())
                .build();
    }
}
