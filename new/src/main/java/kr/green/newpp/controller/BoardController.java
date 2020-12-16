package kr.green.newpp.controller;

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

import kr.green.newpp.pagination.Criteria;
import kr.green.newpp.pagination.PageMaker;
import kr.green.newpp.service.BoardService;
import kr.green.newpp.service.UserService;
import kr.green.newpp.vo.BoardVo;
import kr.green.newpp.vo.UserVo;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;
	//게시판
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv,Criteria cri) {
	    logger.info("URI:/board/list");
		mv.setViewName("/board/list");
		PageMaker pm = boardService.getPageMaker(cri);
		ArrayList<BoardVo>list;
		list = boardService.getBoardList(cri);
	    mv.addObject("list", list);
	    mv.addObject("pm", pm);
		System.out.println(pm);
	    return mv;
	}
	//게시판 상세
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv,Integer num,Criteria cri) {
		logger.info("URI:/board/detail");
		mv.setViewName("/board/detail");
		BoardVo board = null;
		if(num!=null) {
			board = boardService.getBoard(num);
			System.out.println(board);
			mv.addObject("board", board);
			if(board != null) {
				boardService.increasViews(num);
				board.setViews(board.getViews()+1);
			}
		}
		mv.addObject("cri",cri);
		return mv;
	}
	//게시판 등록
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView boardregisterGet(ModelAndView mv) {
		logger.info("URI:/board/register:GET");
		mv.setViewName("/board/register");

		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView boardregisterPost(ModelAndView mv, BoardVo board, HttpServletRequest request) {
		logger.info("URI:/board/register:POST");
		mv.setViewName("redirect:/board/list");
		boardService.registerBoard(board,request);
		return mv;
	}
	//게시글 수정
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv,Integer num, HttpServletRequest request) {
		logger.info("URI:/board/modify:GET");
		mv.setViewName("/board/modify");
		System.out.println(num);
		BoardVo board=null;
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
	public ModelAndView boardModifyPost(ModelAndView mv,BoardVo board,HttpServletRequest request) {
		logger.info("URI:/board/modify:Post");
		mv.setViewName("redirect:/board/list");
		boardService.updateBoard(board,userService.getUser(request));
		return mv;
	}
	//게시글 삭제
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView boardModifyPost(ModelAndView mv,Integer num,HttpServletRequest request) {
		logger.info("URI:/board/delete:Get");
		mv.setViewName("redirect:/board/list");
		boardService.deleteBoard(num,userService.getUser(request));

		return mv;
	}
	//추천기능
	@RequestMapping(value = "/board/like")
	@ResponseBody
	public Map<Object, Object> boardLike(@RequestBody String num,HttpServletRequest r){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    UserVo user = userService.getUser(r);
	    if(user == null) {
	    	map.put("isUser", false);
	    }else {
	    	map.put("isUser", true);
	    	int like = boardService.updateLike(num,user.getId());
	    	map.put("like", like);
	    }
	    return map;
	}
	
}
