package kr.green.spring.controller;

import java.util.ArrayList;
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

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.BoardService;
import kr.green.spring.service.UserService;
import kr.green.spring.vo.BoardVo;
import kr.green.spring.vo.UserVo;

@Controller

public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv,Criteria cri) {
		logger.info("URI:/board/list");
		mv.setViewName("/board/list");
		PageMaker pm = boardService.getPageMaker(cri);
		ArrayList<BoardVo> list;
//		생성자  new 는 DB에서 만들어서 전달해줌
		list = boardService.getBoardList(cri);
		mv.addObject("list",list);
		mv.addObject("pm",pm);
		return mv;
	}
//조회 메서드
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv,Integer num,Criteria cri) { //int로 안하는 이유 : Null값을 포함하지 않기 때문에 잘못된 접근 시 고려함
		logger.info("URI:/board/detail");
		mv.setViewName("/board/detail");
		BoardVo board = null;
		if(num!=null) {
			board = boardService.getBoard(num);
			mv.addObject("board",board);
//			조회수 증가 메서드
			if(board != null) {
				boardService.increaseViews(num);
				board.setViews(board.getViews()+1);
			}
		}
		mv.addObject("cri",cri);
		return mv;
	}
//	글쓰기 메서드 
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) { //BoardVo 안에 있는 board가 포함한 하위 개체: String title,writer...
		logger.info("URI:/board/register:GET");
		mv.setViewName("/board/register");
		
		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv,BoardVo board,HttpServletRequest request) {
		logger.info("URI:/board/register:POST");
		mv.setViewName("redirect:/board/list");
		boardService.registerBoard(board,request);
		return mv;
	}
//	수정 메서드
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num,HttpServletRequest request) { //BoardVo 안에 있는 board가 포함한 하위 개체: String title,writer...
		logger.info("URI:/board/modify:GET");
		mv.setViewName("/board/modify");
		System.out.println(num);
		BoardVo board = null;
		UserVo user = userService.getUser(request);
		if(num != null) {
			board = boardService.getBoard(num);
			if(user == null || !board.getWriter().equals(user.getId()))
				mv.setViewName("redirect:/board/list");
		}
		mv.addObject("board",board);
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyPost(ModelAndView mv,BoardVo board,HttpServletRequest request) { //BoardVo 안에 있는 board가 포함한 하위 개체: String title,writer...
		logger.info("URI:/board/modify:POST");
		mv.setViewName("redirect:/board/list");
		UserVo user = userService.getUser(request);
		boardService.updateBoard(board,user);
		return mv;
	}
//	삭제 메서드
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView boardDelete(ModelAndView mv, Integer num,HttpServletRequest request) { //BoardVo 안에 있는 board가 포함한 하위 개체: String title,writer...
		logger.info("URI:/board/delete:GET");
		mv.setViewName("redirect:/board/list");
		boardService.deleteBoard(num, userService.getUser(request));
		
		return mv;
	}
	@RequestMapping(value ="/board/like")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String num,HttpServletRequest r){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    UserVo user = userService.getUser(r);
	    if(user == null) {
	    	map.put("isUser",false);
	    }else {
	    	map.put("isUser", true);
	        int like = boardService.updateLike(num,user.getId());
	        map.put("like",like);
	    }
	    return map;
	}
}
