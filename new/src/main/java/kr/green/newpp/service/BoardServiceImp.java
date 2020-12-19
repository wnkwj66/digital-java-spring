package kr.green.newpp.service;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.newpp.dao.BoardDao;
import kr.green.newpp.pagination.Criteria;
import kr.green.newpp.pagination.PageMaker;
import kr.green.newpp.vo.BoardVo;
import kr.green.newpp.vo.UserVo;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public ArrayList<BoardVo> getBoardList(Criteria cri) {
		
		return boardDao.getBoardList(cri);
	}

	@Override
	public BoardVo getBoard(Integer num) {

		return boardDao.getBoard(num);
	}

	@Override
	public void increasViews(Integer num) {
		boardDao.increaseViews(num);		
	}
	@Override
	public void registerBoard(BoardVo board,HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserVo user = (UserVo)session.getAttribute("user");
		if(user == null)	return ;
		board.setWriter(user.getId());
		boardDao.registerBoard(board);
	}

	@Override
	public void updateBoard(BoardVo board) {
		board.setIsDel('N');
		boardDao.updateBoard(board);
	}
	@Override
	public void deleteBoard(Integer num, UserVo userVo) {
		if(num != null && userVo != null) {
			BoardVo board = boardDao.getBoard(num);
			if(board != null && board.getWriter().equals(userVo.getId())) {
				board.setIsDel('Y');
				board.setDelDate(new Date());
				boardDao.updateBoard(board);
			}
		}
	}
	@Override
	public PageMaker getPageMaker(Criteria cri) {
		PageMaker pm = new PageMaker();
		int totalCount = boardDao.getTotalCount(cri);
		pm.setCriteria(cri);
		pm.setTotalCount(totalCount);
		return pm;
	}

	@Override
	public int updateLike(int num, String id) {
		//추천 테이블에서 게시글 번호와 아이디와 일치하는 값이 있는 검색해서
		//이미 추천했다면 -1을 리턴
		if(boardDao.isLike(num,id)!= 0) {
			return -1;
		}
		//추천 테이블에 추천을 등록
		boardDao.insertLike(num, id);
		//게시글의 추천수만 업데이트
		boardDao.updateBoardByUp(num);
		//게시글 정보를 가져옴
		BoardVo board = boardDao.getBoard(num);
		return board.getLike();
		
	}
}
