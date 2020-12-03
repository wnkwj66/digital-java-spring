package kr.green.newpp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.newpp.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();
	
	BoardVo getBoard(@Param("num")Integer num);

	void increaseViews(Integer num);
}
