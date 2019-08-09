package com.example.demo.board.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.board.domain.BoardVO;
import com.example.demo.board.domain.Pagination;
import com.example.demo.board.mapper.BoardMapper;

@Service
public class BoardServiceImple implements BoardService {

  @Autowired
  BoardMapper mBoardMapper;

  public List<BoardVO> boardListService(Pagination pagination) throws Exception {
    return mBoardMapper.boardList(pagination);
  }

  public int boardInsertService(BoardVO board) throws Exception {
    return mBoardMapper.boardInsert(board);
  }

  public BoardVO boardDetailService(int bno) throws Exception {
    return mBoardMapper.boardDetail(bno);
  }

  public int boardUpdateService(BoardVO board) throws Exception {
    return mBoardMapper.boardUpdate(board);
  }

  public int boardDeleteService(int bno) throws Exception {
    return mBoardMapper.boardDelete(bno);
  }

  public int boardCountService() throws Exception {   
    return mBoardMapper.boardCount();
  }

}
