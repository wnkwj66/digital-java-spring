package kr.green.TEST.service;

import kr.green.TEST.vo.UserVo;

public interface UserService {
	
	UserVo getUser(String id);

	UserVo isSignin(UserVo user);

	boolean signup(UserVo user);
}
