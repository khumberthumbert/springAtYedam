package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
//import com.yedam.app.board.service.BoardVO;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardControllor {
	
	@Autowired
	BoardService boardService;	
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
//	@GetMapping("boardList")
//	public String boardList(Model model) {
//		model.addAttribute("boardList", boardService.getBoardList());
//		return "board/boardList";
//	}
	//전체조회 교수님 방식
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
//	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
//	@GetMapping("boardInfo")
//	public String boardInfo(Model model, BoardVO boardVO) {
//		model.addAttribute("board", boardService.getBoardInfo(boardVO));
//		return "board/boardInfo";
//	}

	// 교수님 방식 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(Model model, BoardVO boardVO) {
		BoardVO findBoard = boardService.getBoardInfo(boardVO);
		model.addAttribute("board", findBoard);
		return "board/boardInfo";
	}
	
	
//	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert  헤더에 등록하면 된다.
//	@GetMapping("boardInsert")
//	public String boardInsertPage() {
//		return "board/boardInsert";
//	}
	
	// 교수님 방식 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert  헤더에 등록하면 된다.
		@GetMapping("boardInsert")
		public String boardInsertForm() {
			return "board/boardInsert";
		}
	
//	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
//	@PostMapping("boardInsert")
//	public String boardInsert(BoardVO vo) {
//		boardService.insertBoardInfo(vo);
//		return "redirect:boardList";
//	}
	
	//교수님 방식 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO vo, Model model) {
		boardService.insertBoardInfo(vo);
		return "redirect:boardList";
	}
	
//	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
//	@GetMapping("boardUpdate")
//	public String boardUpdatePage(Model model, BoardVO boardvo) {
//		model.addAttribute("board", boardService.getBoardInfo(boardvo));
//		return "board/boardUpdate";
//	}
	
	// 교수님 방식 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(Model model, BoardVO boardvo) {
		BoardVO findeVO = boardService.getBoardInfo(boardvo);
		model.addAttribute("board", findeVO);
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
//	 @PostMapping("boardUpdate") 
//	 public String boardUpdate(BoardVO vo) {
//		
//	 }
	
	// 교수님 방식 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdate(BoardVO boardVO) {
		boolean result = false;
		int boardNo = boardService.updateBoardInfo(boardVO);
		if(boardNo > -1) { //음수값이 아예 들어가지 아닐 변수라면 이런식의 조건문이 낫다.
			result = true;
		} 
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("board_no", boardNo);
		
		return map;
	}
//	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
//	@GetMapping("boardDelete")
//	public String boardDelete(@RequestParam int bno) {
//		boardService.deleteBoardInfo(bno);
//		return "redirect:boardList";
//	}
	
	// 교수님 방식 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam(required = false, 
											defaultValue = "0",
											name="bno") int boardNo) {
		boardService.deleteBoardInfo(boardNo);
		return "redirect:boardList";
	}
}
