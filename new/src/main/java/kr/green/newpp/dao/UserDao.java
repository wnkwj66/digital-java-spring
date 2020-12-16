package kr.green.newpp.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.newpp.vo.UserVo;

public interface UserDao {
	public UserVo getUser(@Param("id")String id);

	public void insertUser(@Param("user")UserVo user);
}
