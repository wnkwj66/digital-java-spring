package kr.green.newpp.service;

import java.util.ArrayList;

import kr.green.newpp.pagination.Criteria;
import kr.green.newpp.pagination.PageMaker;
import kr.green.newpp.vo.BoardVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	BoardVo getBoard(Integer num);

	void increasViews(Integer num);

	void registerBoard(BoardVo board);

	void updateBoard(BoardVo board);

	void deleteBoard(Integer num);

	PageMaker getPageMaker(Criteria cri);

}
