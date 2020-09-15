package kr.green.portfolio.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.portfolio.service.UserService;
import kr.green.portfolio.util.ApiExplorer;
import kr.green.portfolio.util.MyUtils;
import kr.green.portfolio.vo.BusVo;
import kr.green.portfolio.vo.UserVo;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	UserService userService;
	//메서드가 정의되지 않으면 어떤 방식이던 접근 가능
	@RequestMapping(value="/", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView home(ModelAndView mv){
	    mv.setViewName("/main/home");//main/home페이지를 보여준다
	    return mv;
	}
//	회원가입 
	// 회원가입 버튼 누르면 signup 페이지 보여줌 (Get으로 받음)
	@RequestMapping(value="/user/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv){
		logger.info("URI:/signup:Get");
		mv.setViewName("/main/signup");
	    return mv;
	}
	@RequestMapping(value="/user/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,UserVo user){
		logger.info("URI:/signup:Post");
		if(userService.signup(user)) {
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/user/signup");
		}
	    return mv;
	}
//	로그인 폼을 띄우는 부분
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv,String msg) { //02 . String msg 매개변수 받아서
		logger.info("URI:/Login:GET");
		mv.addObject("msg", msg); // 03. login?msg=failure 에서 msg value 전송?
		mv.setViewName("/main/login");
		return mv;
	}
//	로그인 처리하는 부분
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv,UserVo inputUser) {
		logger.info("URI:/Login:POST");
		UserVo user = userService.isUser(inputUser);
		System.out.println("success");
		if(user != null) {
			System.out.println("Success!!");
			mv.setViewName("redirect:/");
			//request.setAttribute("key","value");
			mv.addObject("user", user);
			
		}else{
			mv.addObject("msg", "failure"); // 01. addObject로 msg값을 jsp에 보내면 주소창에 /login?msg=failure 추가
			System.out.println("fail :(");
			mv.setViewName("redirect:/user/login");
		}
		return mv;
	}
//	로그아웃
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv,HttpServletRequest request) {
		logger.info("URI:/LogOut:GET");
		mv.setViewName("redirect:/");
		request.getSession().removeAttribute("user");
		return mv;
	}
	//ajax사용 위한 idcheck
	@RequestMapping(value ="/idCheck")
	@ResponseBody //비동기통신 처리 
	public Map<Object, Object> idcheck(@RequestBody String id){
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		//userService가 호출한 getUser(id)//유저정보(아이디만)가 null값이면 "res" 반환?
		// -> sign up [ajax]로 이동
		map.put("res",userService.getUser(id)==null);
		return map;
	}
// AIP
	@RequestMapping("/busForm") //busForm.jsp 의 요청을 받아서 실행
	public ModelAndView busForm(ModelAndView mv) {
		mv.setViewName("/bus/busForm");
		return mv;
	}
	
	@RequestMapping(value = "/bus", method = RequestMethod.POST) //bus.jsp의 요청받아 bus메서드 실행
	// 접근제한자 public 리턴타입 modleAndView 
	public ModelAndView bus(BusVo busVo, ModelAndView mv) throws Exception{
		
		Map<String , String> result = MyUtils.getTerminalId();
//		Iterator<String> it = result.keySet().iterator();
//		while(it.hasNext()) {
//			String tmp = it.next();
//			System.out.println(tmp+":"+result.get(tmp));
//		}
		String depTerminalNm = result.get(busVo.getDepTerminalNm());
		System.out.println("depTerminalNm:"+ depTerminalNm);
		String arrTerminalNm = result.get(busVo.getArrTerminalNm());
		System.out.println("arrTerminalNm:"+ arrTerminalNm);
		String depPlandTime = busVo.getDepPlandTime();
		String arrPlandTime = busVo.getArrPlandTime();
		
		List<BusVo> go = ApiExplorer.getBusJson(depTerminalNm, arrTerminalNm, depPlandTime);
		System.out.println("go: "+ go);
		List<BusVo> back = ApiExplorer.getBusJson(depTerminalNm, arrTerminalNm, depPlandTime);
		
		mv.addObject("go",go);
		mv.addObject("back",back);
		mv.setViewName("/bus/bus");
		return mv;
	}
}
