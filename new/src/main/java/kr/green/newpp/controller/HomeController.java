package kr.green.newpp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.newpp.service.UserService;
import kr.green.newpp.vo.UserVo;

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
// 회원가입  
	 @RequestMapping(value="/signup",method = RequestMethod.GET)
	 public ModelAndView signupGet(ModelAndView mv){
		 logger.info("URI:/signup:GET");
		 mv.setViewName("/main/signup");
	     return mv;
	 }
	 @RequestMapping(value="/signup",method = RequestMethod.POST)
	 public ModelAndView signupPost(ModelAndView mv,UserVo user){
		 logger.info("URI:/signup:POST");
		 if(userService.signup(user)) {
			 mv.setViewName("redirect:/");
		 }else {
			 mv.setViewName("redirect:/signup");
			 mv.addObject("user", user);
		 }
	     return mv;
	 }

}
