package com.backend.yourssu.board.service;

import com.backend.yourssu.board.domain.dto.*;
import com.backend.yourssu.board.domain.entity.Board;
import com.backend.yourssu.board.exception.ErrorEnum;
import com.backend.yourssu.board.exception.YourssuException;
import com.backend.yourssu.board.repository.BoardRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    @NonNull
    private BoardRepository boardRepository;
    @NonNull
    private MemberService memberService;

    @Override
    public BoardDto savePost(BoardDto boardDto) {
        boardRepository.save(boardDto.toEntity(memberService.findMember(boardDto.getMemberId())));
        return boardDto;
    }

    @Override
    public Page<SimpleBoardResponseDto> findAllBoards(Pageable pageable) {
        Page<Board> boards = boardRepository.findAllByIsEnableIsTrue(pageable);
        return new PageImpl<SimpleBoardResponseDto>(
                boards.getContent().stream().map(board -> SimpleBoardResponseDto.of(board)).collect(Collectors.toList())
                , boards.getPageable()
                , boards.getTotalElements());
    }

    @Override
    public BoardResponseDto findBoard(Long boardId) {
        return boardRepository.findById(boardId).map(board -> BoardResponseDto.of(board))
                .orElseThrow(() -> new YourssuException(ErrorEnum.BOARD_NOT_FOUND));
    }

    @Override
    public UpdateBoardDto updateBoard(UpdateBoardDto updateBoardDto) {
        Board board = boardRepository.findById(updateBoardDto.getBoardId()).orElseThrow(() -> new YourssuException(ErrorEnum.BOARD_NOT_FOUND));
        if(!board.getMember().getId().equals(updateBoardDto.getMemberId()))
            throw new YourssuException(ErrorEnum.NO_AUTHORITY);
        boardRepository.save(board.update(updateBoardDto));
        return updateBoardDto;
    }

    @Override
    public BoardRequestDto deleteBoard(BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(boardRequestDto.getBoardId()).orElseThrow(() -> new YourssuException(ErrorEnum.BOARD_NOT_FOUND));
        if(!board.getMember().getId().equals(boardRequestDto.getMemberId()))
            throw new YourssuException(ErrorEnum.NO_AUTHORITY);
        board.setIsEnable(false);
        boardRepository.save(board);
        return boardRequestDto;
    }
}
