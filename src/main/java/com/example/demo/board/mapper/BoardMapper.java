package com.example.demo.board.mapper;

import java.util.List;

// 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시
import org.springframework.stereotype.Repository;

import com.example.demo.board.domain.BoardVO;
@Repository("com.example.demo.board.mapper.BoardMapper")
public interface BoardMapper {
	
	// 게시글 개수
	public int boardCount() throws Exception;
	
	// 게시글 목록
	public List<BoardVO> boardList() throws Exception;
	
	// 게시글 상세
	public BoardVO boardDetail(int bno) throws Exception;
	
	// 게시글 작성
	public int boardInsert(BoardVO board) throws Exception;
	
	// 게시글 수정
	public int boardUpdate(BoardVO board) throws Exception;
	
	// 게시글 삭제
	public int boardDelete(int bno) throws Exception;
}
