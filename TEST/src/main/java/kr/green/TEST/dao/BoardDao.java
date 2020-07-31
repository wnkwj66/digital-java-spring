package kr.green.TEST.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.TEST.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList();

	BoardVo getBoard(@Param("num")Integer num);
	
	void registerBoard(@Param("board")BoardVo board);

}
