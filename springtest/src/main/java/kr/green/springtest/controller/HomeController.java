package kr.green.springtest.controller;

import java.util.HashMap;
import java.util.List;
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

import kr.green.springtest.service.UserService;
import kr.green.springtest.utils.ApiExplorer;
import kr.green.springtest.utils.MyUtils;
import kr.green.springtest.vo.BusVo;
import kr.green.springtest.vo.UserVo;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView home(ModelAndView mv,UserVo inputUser) {
		logger.info("URI:/");
		mv.setViewName("/main/home");
		UserVo user = userService.isUser(inputUser);
		if(user != null) {
			mv.setViewName("redirect:/board/list");
			mv.addObject("user",user);
			System.out.println("123");
		}
		return mv;
	}
	@RequestMapping(value = "/user/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
		logger.info("URI:/signup:GET");
		mv.setViewName("/main/signup");
		return mv;
	}
	@RequestMapping(value = "/user/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,UserVo user) {
		logger.info("URI:/signup:POST");
		if(userService.signup(user)) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/user/signup");
		}
		return mv;
	}
	@RequestMapping(value = "/user/signout", method = RequestMethod.GET)
	public ModelAndView signoutGet(ModelAndView mv,HttpServletRequest request) {
		logger.info("URI:/signout:GET");
		mv.setViewName("redirect:/");
		request.getSession().removeAttribute("user");
		return mv;
	}
	@RequestMapping(value ="/idCheck")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String id){

	    Map<Object, Object> map = new HashMap<Object, Object>();
	    map.put("res",userService.getUser(id)==null);
	    return map;
	}
	// AIP
	@RequestMapping("/busForm") // busForm.jsp 의 요청을 받아서 실행
	public ModelAndView busForm(ModelAndView mv) {
		mv.setViewName("/bus/busForm");
		return mv;
	}
	
	@RequestMapping(value="/bus",method = RequestMethod.POST)
	public ModelAndView bus(BusVo busVo, ModelAndView mv) throws Exception{
		
		Map<String , String> result = MyUtils.getTerminalId();

		String depPlaceNm = result.get(busVo.getDepPlaceNm());
		System.out.println("depPlaceNm:"+ depPlaceNm);
		String arrPlaceNm = result.get(busVo.getArrPlaceNm());
		System.out.println("arrPlaceNm:"+ arrPlaceNm);
		String depPlandTime =busVo.getDepPlandTime();
		System.out.println("출발일: "+ depPlandTime);
		String arrPlandTime =busVo.getArrPlandTime();
		
		List<BusVo> go = ApiExplorer.getBusJson(depPlaceNm, arrPlaceNm, depPlandTime);
		System.out.println("suc");
		System.out.println("go: "+go);
		List<BusVo> back = ApiExplorer.getBusJson(depPlaceNm, arrPlaceNm, arrPlandTime);
		mv.addObject("go",go);
		mv.addObject("back",back);
		mv.setViewName("/bus/bus");
		
		return mv;
	}
}
