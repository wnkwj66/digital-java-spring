package kr.green.TEST.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.TEST.dao.BoardDao;
import kr.green.TEST.vo.BoardVo;

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
	public void registerBoard(BoardVo board, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

}
