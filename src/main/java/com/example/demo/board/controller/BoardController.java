package com.example.demo.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.domain.BoardVO;
import com.example.demo.board.service.BoardService;

// 현재 클래스를 컨트롤러 빈(bean)으로 등록
@Controller
public class BoardController {
	
	@Autowired
	BoardService mBoardService;
	
	@RequestMapping("/list") // 게시판 리스트 화면 호출
	private String boardList(Model model) throws Exception{		
		model.addAttribute("list", mBoardService.boardListService());		
		return "list"; // 생성할 JSP 파일 명
	}
	
	@RequestMapping("/detail/{bno}")
	private String boardDetail(@PathVariable int bno, Model model) throws Exception {
		model.addAttribute("detail", mBoardService.boardDetailService(bno));		
		return "detail";
	}
	
	@RequestMapping("/insert") // 게시글 작성폼 호출
	private String boardInsertForm() {
		return "insert";
	}
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request) throws Exception {
		
		BoardVO board = new BoardVO();
		
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		
		mBoardService.boardInsertService(board);
		return "redirect:/list";
		
	
	}	
	
	@RequestMapping("/update/{bno}") // 게시글 수정폼 호출
	private String boardUpdateForm(@PathVariable int bno, Model model) throws Exception {
		model.addAttribute("detail", mBoardService.boardDetailService(bno));
		return "update";
	}
	
	@RequestMapping("/updateProc")
	private int boardUpdateProc(HttpServletRequest request) throws Exception {
		BoardVO board = (BoardVO) request.getParameterMap();
		return mBoardService.boardUpdateService(board);
	}
	
	@RequestMapping("/delete/{bno}")
	private String boardDelete(@PathVariable int bno) throws Exception {
		mBoardService.boardDeleteService(bno);
		return "redirect:/list";
	}
	
}
