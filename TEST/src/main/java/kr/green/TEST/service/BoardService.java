package kr.green.TEST.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.TEST.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(Integer num);

	void registerBoard(BoardVo board, HttpServletRequest request);

}
