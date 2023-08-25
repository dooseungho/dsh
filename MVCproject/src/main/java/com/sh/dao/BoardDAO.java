package com.sh.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sh.dto.BoardDTO;

@Repository
public class BoardDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BoardDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public List<BoardDTO> getAllBoards() {
        String sql = "SELECT * FROM BOARD";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BoardDTO board = new BoardDTO();
            board.setBno(rs.getInt("bno"));
            board.setMember_id(rs.getString("member_id"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setPost_date(rs.getDate("post_date"));
            board.setViews(rs.getInt("views"));
            return board;
        });
    }

    public void insertPost(BoardDTO post) {
        String insertSql = "INSERT INTO BOARD (bno, member_id, title, content, post_date) VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?)";
        jdbcTemplate.update(
            insertSql,
            post.getMember_id(),
            post.getTitle(),
            post.getContent(),
            new Date(System.currentTimeMillis())
        );
    }

    public Optional<BoardDTO> getBoardById(int bno) {
        String sql = "SELECT * FROM BOARD WHERE bno = ?";
        List<BoardDTO> boardList = jdbcTemplate.query(sql, new Object[]{bno}, new BeanPropertyRowMapper<>(BoardDTO.class));
        if (!boardList.isEmpty()) {
            BoardDTO board = boardList.get(0);
            return Optional.of(board);
        } else {
            return Optional.empty();
        }
    }
    
    public void updateBoard(BoardDTO board) {
        String updateSql = "UPDATE BOARD SET title = ?, content = ?, views = ? WHERE bno = ?";
        jdbcTemplate.update(
            updateSql,
            board.getTitle(),
            board.getContent(),
            board.getViews(),
            board.getBno()
        );
    }
    public void updateViews(int bno) {
        String updateViewsSql = "UPDATE BOARD SET views = views + 1 WHERE bno = ?";
        jdbcTemplate.update(updateViewsSql, bno);
    }
    
    public void deleteBoard(int bno) {
        String deleteSql = "DELETE FROM BOARD WHERE bno = ?";
        jdbcTemplate.update(deleteSql, bno);
    }
    public void deleteBoardById(int bno) {
        String deleteSql = "DELETE FROM BOARD WHERE bno = ?";
        jdbcTemplate.update(deleteSql, bno);
    }
    
}
