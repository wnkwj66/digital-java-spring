package kr.green.newpp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.newpp.dao.UserDao;
import kr.green.newpp.vo.UserVo;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDao userdao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(UserVo user) {
		if(user == null)	return false;
		if(user.getId() == null || user.getId().length() == 0)	
			return false;
		if(user.getPw() == null || user.getPw().length() == 0)	
			return false;
		if(user.getEmail() == null || user.getEmail().length() == 0)	
			return false;
		if(user.getGender() == null) 
			user.setGender("male");
		if(!user.getGender().equals("male") 
			&& !user.getGender().equals("female") )	return false;
		//아이디 있는 경우
		if(userdao.getUser(user.getId())!=null)
			return false;
		//비밀번호 암호화
		String encodePw = passwordEncoder.encode(user.getPw());
		user.setPw(encodePw);

		//회원가입 진행
		userdao.insertUser(user);

		return true;
	}

}
