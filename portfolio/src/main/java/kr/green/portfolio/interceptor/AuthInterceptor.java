package kr.green.portfolio.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//로그인 처리를 담당하는 인터셉터(컨트롤러에 들어오는 요청 HttpRequest와 컨트롤러가 응답하는 HttpResponse를 가로채는 역할)
//인터셉터는 관리자만 접근할 수 있는 관리자 페이지에 접근하기 전에 관리자 인증을 하는 용도로 활용될 수 있습니다.
//HandlerInterceptorAdapter클래스를 상속받아 구현 하는 방법
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	// preHandle (): 컨트롤러보다 먼저 수행되는 메서드	
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler)
							throws Exception {
		// session 객체를 가져옴
		HttpSession session = request.getSession();
		// Login처리를 담당하는 사용자 정보를 담고있는 객체(user)를 가져옴
		Object user = session.getAttribute("user");
		if(user == null) {
			// 로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
			response.sendRedirect(request.getContextPath()+"/");
			return false;// 더 이상 컨트롤러 요청으로 가지 않도록 false로 반환
		}
		
		// preHandle의 return은 컨트롤러 요청 uri로 가도 되냐/ 안되냐를 허가하는 의미
		// 따라서 true로 하면 컨트롤러 uri로 가게 됨.
		return true;
	}
}
