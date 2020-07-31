package kr.green.TEST.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.TEST.service.UserService;
import kr.green.TEST.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	UserService userService;
	
	@RequestMapping(value= "/",method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈테스트");
	    mv.addObject("setBtn","클릭");
	    System.out.println(userService.getClass());
	    		
	    return mv;
	}
	@RequestMapping(value="/signin",method = RequestMethod.GET)
	public ModelAndView signinGet(ModelAndView mv,UserVo user) {
		mv.setViewName("/main/signin");
		UserVo dbUser = userService.isSignin(user);
		return mv;
	}
	@RequestMapping(value="/signin",method = RequestMethod.POST)
	public ModelAndView signinPost(ModelAndView mv,UserVo user) {
		mv.setViewName("redirect:/");
		UserVo dbUser = userService.isSignin(user);
		mv.addObject("user",dbUser);
		System.out.println(dbUser);
		return mv;
	}
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		mv.setViewName("/main/signup");
		return mv;
	}
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,UserVo user) {
		if(userService.signup(user)) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
			mv.addObject("user",user);
			mv.addObject("id",user.getId());
			mv.addObject("pw",user.getPw());
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("user",user);
			mv.addAllObjects(map);
		}
		return mv;
	}
}
