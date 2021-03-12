package com.backend.yourssu.board.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends CommonEntity{
    private String email;
    private String nickname;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Board> boards;
}
