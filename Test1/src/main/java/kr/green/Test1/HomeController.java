package kr.green.Test1;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.Test1.Util.ApiExplorer;
import kr.green.Test1.Util.MyUtils;
import kr.green.Test1.vo.busVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/busForm") //busForm.jsp 의 요청을 받아서 실행
	public ModelAndView busForm(ModelAndView mv) {
		mv.setViewName("/bus/busForm");
		return mv;
	}
	@RequestMapping(value = "/bus", method = RequestMethod.POST) //bus.jsp의 요청받아 bus메서드 실행
	// 접근제한자 public 리턴타입 modleAndView 
	public ModelAndView bus(busVo busVo, ModelAndView mv) throws Exception{
		
		Map<String , String> result = MyUtils.getTerminalId();

		System.out.println("3333333333333333333333333333333333");
		
		String depPlaceNm = result.get(busVo.getDepPlaceNm());
		System.out.println("depPlaceNm:"+ depPlaceNm);
		
		String arrPlaceNm = result.get(busVo.getArrPlaceNm());
		System.out.println("arrPlaceNm:"+ arrPlaceNm);
		
		String depPlandTime = busVo.getDepPlandTime();
		String arrPlandTime = busVo.getArrPlandTime();
		
		System.out.println("여기까진 실행됨");
		List<busVo> go = ApiExplorer.getBusJson(depPlaceNm, arrPlaceNm, depPlandTime);
		System.out.println("Go:"+ go);
		List<busVo> back = ApiExplorer.getBusJson(depPlaceNm, arrPlaceNm, arrPlandTime);
		
//		mv.addObject("go",go);
		mv.addObject("back",back);
		mv.setViewName("/bus/bus");
		return mv;
	}
}
