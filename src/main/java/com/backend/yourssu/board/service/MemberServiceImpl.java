package com.backend.yourssu.board.service;

import com.backend.yourssu.board.domain.entity.Member;
import com.backend.yourssu.board.exception.ErrorEnum;
import com.backend.yourssu.board.exception.YourssuException;
import com.backend.yourssu.board.repository.MemberRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    @NonNull
    private MemberRepository memberRepository;

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new YourssuException(ErrorEnum.MEMBER_NOT_FOUND));
    }
}
