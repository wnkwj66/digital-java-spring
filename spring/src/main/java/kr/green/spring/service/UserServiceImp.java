package kr.green.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.UserDao;
import kr.green.spring.vo.UserVo;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(UserVo user) {
		if(user == null) return false;
		if(user.getId() == null || user.getId().length() == 0)	return false;	
		if(user.getPw() == null || user.getPw().length() == 0)	return false;
		if(user.getGender() == null)
			user.setGender("male");
		if(!user.getGender().equals("male")
				&& !user.getGender().equals("female")) return false;
		//아이디가 있는경우(중복)
		if(userDao.getUser(user.getId())!=null)
			return false;
		//비밀번호 암호화
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);
		//회원가입 진행
		userDao.insertUser(user);
		
		return true;
	}

	@Override
	public UserVo isSignin(UserVo user) {
		UserVo dbUser = userDao.getUser(user.getId()); //!!!!!!!!!해석(체크해서 유저정보 있으면) get가져옴??
		if(dbUser != null && passwordEncoder.matches(user.getPw(), dbUser.getPw())) //입력한 비밀번호와 암호화된 비밀번호가 같은지 비교 :matches
			return dbUser;
		return null;
	}

	@Override
	public UserVo getUser(HttpServletRequest request) {
		return (UserVo)request.getSession().getAttribute("user");
	}

	@Override
	public UserVo getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public void newPw(String id, String newPw) {
		//요청한 아이디에 회원 정보를 가져옴
	    UserVo user = getUser(id.trim());
	    String encodePw = passwordEncoder.encode(newPw);
	    if(user == null) return;
	    user.setPw(encodePw);
	    userDao.updatePw(user);
	}

}
