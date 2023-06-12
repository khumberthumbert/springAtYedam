package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	//전체조회
	//List타입은 반환되는 조건에 맞춰서 주기 때문에 리스트 <> 이 안에 존재하는 것에 타입을 맞춰주면 됨.
	public List<BoardVO> selectBoardList();
	
	//단건조회
	public BoardVO selectBoardInfo(BoardVO boardVO);
	//등록
	public int insertBoard(BoardVO boardVO);
	//수정
	public int updateBoard(BoardVO boardVO);
	//삭제
	public int deleteBoard(int boardNo);
}
