package com.backend.yourssu.board.service;


import com.backend.yourssu.board.domain.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    BoardDto savePost(BoardDto boardDto);
    Page<SimpleBoardResponseDto> findAllBoards(Pageable pageable);
    BoardResponseDto findBoard(Long boardId);

    UpdateBoardDto updateBoard(UpdateBoardDto updateBoardDto);

    BoardRequestDto deleteBoard(BoardRequestDto boardRequestDto);
}
