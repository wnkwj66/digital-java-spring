package kr.green.TEST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.TEST.dao.UserDao;
import kr.green.TEST.vo.UserVo;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public UserVo getUser(String id) {
		return userDao.getUser(id);
	}
	@Override
	public UserVo isSignin(UserVo user) {
		UserVo dbUser = userDao.getUser(user.getId());
		return dbUser;
	}
	@Override
	public boolean signup(UserVo user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
		return true;
	}

}
