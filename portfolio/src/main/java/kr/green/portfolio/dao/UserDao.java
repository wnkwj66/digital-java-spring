package kr.green.portfolio.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.portfolio.vo.UserVo;

public interface UserDao {
	//매퍼랑 연결?
	UserVo getUser(@Param("id")String id);

	void insertUser(@Param("user")UserVo user);
	
}
