package com.backend.yourssu.board.domain.dto;

import com.backend.yourssu.board.domain.entity.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BoardResponseDto {
    private Long boardId;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static BoardResponseDto of(Board board) {
        return BoardResponseDto.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getMember().getNickname())
                .createdAt(board.getCreatedAt())
                .updatedAt(board.getUpdatedAt())
                .build();
    }
}
