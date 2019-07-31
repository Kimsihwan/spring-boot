package com.example.demo.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.domain.BoardVO;
import com.example.demo.board.mapper.BoardMapper;

public interface BoardService {	
	
	List<BoardVO> boardListService() throws Exception;
	
	int boardInsertService(BoardVO board) throws Exception;
	
	BoardVO boardDetailService(int bno) throws Exception;
	
	int boardUpdateService(BoardVO board) throws Exception;
	
	int boardDeleteService(int bno) throws Exception;

}
