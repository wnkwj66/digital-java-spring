package kr.green.newpp.service;

import java.util.ArrayList;

import kr.green.newpp.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(Integer num);

	void increasViews(Integer num);

}
