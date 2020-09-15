package kr.green.portfolio.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.portfolio.vo.UserVo;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView)  throws Exception {
	    
		ModelMap modelMap = modelAndView.getModelMap();
	    UserVo user = (UserVo)modelMap.get("user");
	    
//	    가져온 정보가 null이 아니면 해당 유저 정보를 세션에 저장
	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	    }
	}
}