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
	public void updateBoard(BoardVo board,UserVo user) {
		board.setWriter(user.getId());
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
	public int updateLike(String num, String id) {
		if(boardDao.isLike(Integer.parseInt(num), id) == 0) {
			boardDao.insertLike(Integer.parseInt(num), id);
		}else {
			return -1;
		}

		BoardVo board = boardDao.getBoard(Integer.parseInt(num));
		boardDao.updateBoard(board);
		board = boardDao.getBoard(Integer.parseInt(num));
		return board.getLike();
	}
}
