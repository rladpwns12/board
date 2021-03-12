package com.backend.yourssu.board.repository;

import com.backend.yourssu.board.domain.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query(value = "SELECT b FROM Board AS b JOIN FETCH b.member WHERE b.isEnable = true ",
            countQuery = "SELECT COUNT(b) FROM Board AS b")
    Page<Board> findAllByIsEnableIsTrue(Pageable pageable);

    @Query(value = "SELECT b FROM Board AS b JOIN FETCH b.member WHERE b.isEnable = true")
    Optional<Board> findById(Long boardId);
}
