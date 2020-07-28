package kr.green.TEST.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.TEST.vo.UserVo;

public interface UserDao {
	UserVo getUser(@Param("id")String id);
}
