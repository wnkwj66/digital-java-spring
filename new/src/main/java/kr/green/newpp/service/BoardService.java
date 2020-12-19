package kr.green.newpp.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.newpp.pagination.Criteria;
import kr.green.newpp.pagination.PageMaker;
import kr.green.newpp.vo.BoardVo;
import kr.green.newpp.vo.UserVo;

public interface BoardService {

	ArrayList<BoardVo> getBoardList(Criteria cri);

	BoardVo getBoard(Integer num);

	void increasViews(Integer num);

	void registerBoard(BoardVo board,HttpServletRequest request);

	void updateBoard(BoardVo board);

	void deleteBoard(Integer num, UserVo userVo);

	PageMaker getPageMaker(Criteria cri);

	int updateLike(int num, String id);

}
