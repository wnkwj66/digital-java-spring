package kr.green.newpp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.newpp.dao.BoardDao;
import kr.green.newpp.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public ArrayList<BoardVo> getBoardList() {
		
		return boardDao.getBoardList();
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
	public void registerBoard(BoardVo board) {
		boardDao.registerBoard(board);
	}

}
