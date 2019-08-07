package com.example.demo.board.service;

import java.util.List;
import com.example.demo.board.domain.CommentVO;

public interface CommentService {  

  // 댓글 목록
  public List<CommentVO> commentListService(int bno) throws Exception;

  // 댓글 작성
  public int commentInsertService(CommentVO comment) throws Exception;
  
  // 댓글 수정
  public int commentUpdateService(CommentVO comment) throws Exception;

  // 댓글 삭제
  public int commentDeleteService(int cno) throws Exception;

}
