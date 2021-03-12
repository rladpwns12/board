package com.backend.yourssu.board.controller;

import com.backend.yourssu.board.domain.dto.*;
import com.backend.yourssu.board.service.BoardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    @NonNull
    private BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardDto> postBoard(@RequestBody BoardDto boardDto){
        return ResponseEntity.ok(boardService.savePost(boardDto));
    }

    @GetMapping
    public ResponseEntity<Page<SimpleBoardResponseDto>> listBoard(PageRequestDto pageRequestDTO){
        return ResponseEntity.ok(boardService.findAllBoards(pageRequestDTO.getPageable()));
    }

    @GetMapping(value = "/{board_id}")
    public ResponseEntity<BoardResponseDto> searchBoard(@PathVariable("board_id") Long boardId){
        return ResponseEntity.ok(boardService.findBoard(boardId));
    }

    @PutMapping
    public ResponseEntity<UpdateBoardDto> updateBoard(@RequestBody UpdateBoardDto updateBoardDto){
        return ResponseEntity.ok(boardService.updateBoard(updateBoardDto));
    }

    @DeleteMapping
    public ResponseEntity<BoardRequestDto> deleteBoard(@RequestBody BoardRequestDto boardRequestDto){
        return ResponseEntity.ok(boardService.deleteBoard(boardRequestDto));
    }

}
