package com.backend.yourssu.board.domain.dto;

import com.backend.yourssu.board.domain.entity.Board;
import com.backend.yourssu.board.domain.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto {
    private Long memberId;
    private String title;
    private String content;

    public Board toEntity(Member member) {
        return Board.builder()
                .member(member)
                .title(title)
                .content(content)
                .build();
    }
}
