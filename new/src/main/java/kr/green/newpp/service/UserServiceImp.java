package kr.green.newpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.newpp.dao.UserDao;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserDao userdao;
	
	@Override
	public String getUser(String id) {
	
		return userdao.getUser(id);
	}

	@Override
	public String getPw(String id) {

		return userdao.getPw(id);
	}

	@Override
	public int getCount() {
		
		return userdao.getCount();
	}

}
