package com.backend.yourssu.board.domain.entity;

import com.backend.yourssu.board.domain.dto.UpdateBoardDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board extends CommonEntity{
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Board  update(UpdateBoardDto updateBoardDto){
     this.title = updateBoardDto.getTitle();
     this.content = updateBoardDto.getContent();
     return this;
    }

    @Builder
    public  Board(String title, String content, Member member){
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
