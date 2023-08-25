package com.sh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.dao.BoardDAO;
import com.sh.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Transactional
    @Override
    public List<BoardDTO> getAllBoards() {
        return boardDAO.getAllBoards();
    }

    @Transactional
    @Override
    public Optional<BoardDTO> getBoardById(int bno) {
        return boardDAO.getBoardById(bno);
    }

    @Transactional
    @Override
    public void insertPost(BoardDTO board) {
        boardDAO.insertPost(board);
    }

    @Transactional
    @Override
    public void updateBoard(BoardDTO board) {
        boardDAO.updateBoard(board);
    }

    @Transactional
    @Override
    public void deleteBoardById(int bno) {
        boardDAO.deleteBoardById(bno);
    }
}
