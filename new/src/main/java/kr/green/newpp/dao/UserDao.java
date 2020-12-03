package kr.green.newpp.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
	public String getUser(@Param("id")String id);
	
	public String getPw(@Param("id")String id);

	public int getCount();
}
