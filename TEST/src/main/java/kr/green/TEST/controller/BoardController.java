package kr.green.TEST.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.TEST.service.BoardService;
import kr.green.TEST.vo.BoardVo;

@Controller

public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private BoardService boardService;

//게시판 
	@RequestMapping(value= "/board/list")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/board/list");
		ArrayList<BoardVo> list;
		list = boardService.getBoardList();
		mv.addObject("list",list);
		return mv;
	}
//조회 메서드
	@RequestMapping(value= "/board/detail")
	public ModelAndView boardDetailGet(ModelAndView mv,Integer num) {
		BoardVo board;
		board = boardService.getBoard(num);
		mv.setViewName("/board/detail");
		mv.addObject("detail","테스트보드" );
		mv.addObject("board",board);
		return mv;
	}
	@RequestMapping(value= "/board/register")
	public ModelAndView boardregisterGet(ModelAndView mv,BoardVo board,HttpServletRequest request) {
		mv.setViewName("/board/register");
		boardService.registerBoard(board,request);
		return mv;
	}
}
