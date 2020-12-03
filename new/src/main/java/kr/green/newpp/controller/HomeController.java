package kr.green.newpp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.newpp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
	    logger.info("URI:/");
		mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
	    return mv;
	
	}
	 @Autowired
	 UserService userService;
	    
	 @RequestMapping(value="/test",method = RequestMethod.GET)
	 public ModelAndView main(ModelAndView mv,String id, String pw) throws Exception{
		 logger.info("URI:/test");
		 mv.setViewName("/main/home");
	     mv.addObject("title", "테스트");
	     logger.info("전송된 아이디 : " + id);
	     logger.info("전송된 비밀번호 : " + pw);
	     String userPw = userService.getPw(id);
	     logger.info("조회된 비밀번호 : " + userPw);
	     int count = userService.getCount();
	     logger.info("조회된 회원수 : " + count);
	     return mv;
	 }
// 회원가입

}
