package kr.green.newpp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) {
	    logger.info("URI:/board/list");
		mv.setViewName("/board/list");
		ArrayList<BoardVo>list;
		list = boardService.getBoardList();
	    mv.addObject("list", list);
	    return mv;
	
	}
}
