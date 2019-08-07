package com.example.demo.board.service;

import java.util.List;
import com.example.demo.board.domain.BoardVO;

public interface BoardService {

  public List<BoardVO> boardListService() throws Exception;

  public int boardInsertService(BoardVO board) throws Exception;

  public BoardVO boardDetailService(int bno) throws Exception;

  public int boardUpdateService(BoardVO board) throws Exception;

  public int boardDeleteService(int bno) throws Exception;

}
