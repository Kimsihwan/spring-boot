package com.example.demo.board.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.board.domain.BoardVO;
import com.example.demo.board.domain.Pagination;
import com.example.demo.board.service.BoardService;

// 현재 클래스를 컨트롤러 빈(bean)으로 등록
@Controller
public class BoardController {

	@Autowired
	BoardService mBoardService;

	@RequestMapping("/")
	private String index() {
		return "list";
	}

	@RequestMapping("/board")
	private String board() {
		return "list";
	}

	@RequestMapping("/home")
	private String home() {
		return "home";
	}

//	@RequestMapping("/data") // 게시판 리스트 화면 호출
//	@ResponseBody
//	private List<BoardVO> list(Model model) throws Exception {
//		return mBoardService.boardListService();
//	}

	@RequestMapping("/list") // 게시판 리스트 화면 호출
	private String boardList(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) throws Exception {
		
		// 전체 게시글 개수
		int listCnt = mBoardService.boardCountService();
		
		// Pagination 객체 생성
		Pagination pagination = new Pagination();
		pagination.pageInfo(page, range, listCnt);
		model.addAttribute("pagination", pagination);
		model.addAttribute("list", mBoardService.boardListService(pagination));
		return "list";
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
	private String boardUpdateProc(HttpServletRequest request) throws Exception {

		BoardVO board = new BoardVO();
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setBno(Integer.parseInt(request.getParameter("bno")));

		mBoardService.boardUpdateService(board);

		return "redirect:/detail/" + request.getParameter("bno");
	}

	@RequestMapping("/delete/{bno}")
	private String boardDelete(@PathVariable int bno) throws Exception {
		mBoardService.boardDeleteService(bno);
		return "redirect:/list";
	}

}
