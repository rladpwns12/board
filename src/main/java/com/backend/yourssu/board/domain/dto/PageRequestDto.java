package com.backend.yourssu.board.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@Getter
@Setter
@NoArgsConstructor
public class PageRequestDto {

    private int size = 10;
    private int page = 0;

    public Pageable getPageable() {
        return PageRequest.of(page, size);
    }

}
