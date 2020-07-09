package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		logger.info("URI:/");
		
		
		mv.setViewName("/main/home");
		
		return mv;
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView testget(ModelAndView mv,String id,String pw) {
		logger.info("URI:/test");
		mv.setViewName("/main/test");
		mv.addObject("title","테스트");
		logger.info("전송된 아이디 : "+id);
		logger.info("전송된 비밀번호 : "+pw);
		String userPw = userService.getPw(id);
		logger.info("조회된 비밀번호: "+userPw);
//		DB에 몇명이 존재하는지 확인하는 작업
		int count = userService.getCount();
		logger.info("조회된 회원수: "+ count);
		return mv;
	}
	
}
