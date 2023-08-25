package com.sh.service;

import com.sh.dto.BoardDTO;
import java.util.List;
import java.util.Optional;


public interface BoardService {
    List<BoardDTO> getAllBoards();
    Optional<BoardDTO> getBoardById(int bno);
    void insertPost(BoardDTO board);
    void updateBoard(BoardDTO board);
    void deleteBoardById(int bno);
}
