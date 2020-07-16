package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList();
	
	BoardVo getBoard(Integer num);

	BoardVo view(Integer num);

	void insertBoard(BoardVo board);

	void updateBoard(BoardVo board);

	void deleteBoard(Integer num);

}
