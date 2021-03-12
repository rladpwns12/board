package com.backend.yourssu.board.repository;

import com.backend.yourssu.board.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
