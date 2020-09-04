package kr.green.portfolio.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.portfolio.dao.UserDao;
import kr.green.portfolio.vo.UserVo;

@Service
public class UsersServiceImp implements UserService{
	@Autowired
	UserDao userDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserVo getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public boolean signup(UserVo user) {
		//db에 유저정보가 없다면
		if(user == null)
			return false;
		//중복된 아이디일 경우
		if(userDao.getUser(user.getId()) != null || user.getId().length() == 0)
			return false;
		//비밀번호 체크
		if(user.getPw() == null || user.getPw().length() == 0)
			return false;
		//이메일 체크
		if(user.getEmail() == null || user.getEmail().length() == 0 || !user.getEmail().contains("@"))
			return false;
		//성별 체크
		if(user.getGender() == null || user.getGender().length() == 0)
			user.setGender("male");
		//비밀번호 암호화
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);
		
		userDao.insertUser(user);
		return true;
	}

	@Override
	public UserVo isUser(UserVo inputUser) {
		UserVo user = userDao.getUser(inputUser.getId());
	if(user == null)
		return null;
	if(passwordEncoder.matches(inputUser.getPw(), user.getPw())){
		return user;
	}
	return null;
	}

	@Override
	public UserVo getUser(HttpServletRequest r) {
		return (UserVo)r.getSession().getAttribute("user");
	}
}
