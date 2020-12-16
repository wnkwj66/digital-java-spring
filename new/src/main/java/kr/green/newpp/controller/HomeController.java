package kr.green.newpp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.newpp.service.UserService;
import kr.green.newpp.vo.UserVo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	 @Autowired
	 UserService userService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
	    logger.info("URI:/");
		mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
	    return mv;
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView homePost(ModelAndView mv,UserVo user) {
		logger.info("URI:/");
		UserVo dbUser = userService.isSignin(user); 
		if(dbUser != null) {
			mv.setViewName("redirect:/board/list");
			mv.addObject("user",dbUser);
		}
		else
			mv.setViewName("redirect:/");
		return mv;
	}
// 회원가입  
	 @RequestMapping(value="/signup",method = RequestMethod.GET)
	 public ModelAndView signupGet(ModelAndView mv,UserVo user){
		 logger.info("URI:/signup:GET");
		 mv.setViewName("/main/signup");
		 System.out.println(user);
	     return mv;
	 }
	 @RequestMapping(value="/signup",method = RequestMethod.POST)
	 public ModelAndView signupPost(ModelAndView mv,UserVo user){
		 logger.info("URI:/signup:POST");
		 if(userService.signup(user)) {
			 mv.setViewName("redirect:/");
		 }else {
			 mv.setViewName("redirect:/signup");
			 mv.addObject("id",user.getId());
			 mv.addObject("pw",user.getPw());
			 HashMap<String,Object> map = new HashMap<String, Object>();
			 map.put("user", user);
			 mv.addAllObjects(map);
		 }
	     return mv;
	 }
	 @RequestMapping(value = "/signout", method = RequestMethod.GET)
		public ModelAndView signoutGet(ModelAndView mv,HttpServletRequest request) {
			logger.info("URI:/signout:GET");
			mv.setViewName("redirect:/");
			request.getSession().removeAttribute("user");
			return mv;
		}
		@RequestMapping(value ="/idCheck")
		//idCheck
		@ResponseBody
		public Map<Object, Object> idcheck(@RequestBody String id){
		    Map<Object, Object> map = new HashMap<Object, Object>();
		    UserVo user = userService.getUser(id);
		    boolean check = user == null ? true : false;
		    map.put("check", check);
		    return map;
		}
}
