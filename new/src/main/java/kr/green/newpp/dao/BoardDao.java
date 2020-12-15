package kr.green.newpp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.newpp.pagination.Criteria;
import kr.green.newpp.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoardList(@Param("cri")Criteria cri);
	
	BoardVo getBoard(@Param("num")Integer num);

	void increaseViews(@Param("num")Integer num);
	
	void registerBoard(@Param("board")BoardVo board);

	void updateBoard(@Param("board")BoardVo board);

	int getTotalCount();
}
