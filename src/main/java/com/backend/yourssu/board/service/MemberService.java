package com.backend.yourssu.board.service;

import com.backend.yourssu.board.domain.entity.Member;

public interface MemberService {
    public Member findMember(Long memberId);
}
