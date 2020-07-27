package kr.green.springtest.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.pagination.PageMaker;
import kr.green.springtest.service.BoardService;
import kr.green.springtest.service.UserService;
import kr.green.springtest.utils.UploadFileUtils;
import kr.green.springtest.vo.BoardVo;
import kr.green.springtest.vo.UserVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	@Autowired
	UserService userService;
	
	private String uploadPath = "D:\\git\\uploadfiles"; //"서버경로 입력"
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv,Criteria cri) {
		mv.setViewName("/board/list");
		ArrayList<BoardVo> list = boardService.getBoardList(cri);
		PageMaker pm = boardService.getPageMakerByBoard(cri); 
		mv.addObject("list",list);
		mv.addObject("pm",pm);
		return mv;
	}
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView boardDetailGet(ModelAndView mv,Integer num,Criteria cri) {
		mv.setViewName("/board/detail");
		BoardVo board = boardService.view(num);
		mv.addObject("board", board);
		mv.addObject("cri", cri);
		return mv;
	}
//	등록 메서드에 파일 업로드 추가 
	@RequestMapping(value = "/board/register", method = RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		
		return mv;
	}
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv,BoardVo board,HttpServletRequest r,MultipartFile file2) throws IOException, Exception {//jsp의 name과 맞춰야함.
		mv.setViewName("redirect:/board/list");
		board.setWriter(userService.getUser(r).getId());
		String file = UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(), file2.getBytes());
		board.setFile(file);
		boardService.insertBoard(board);
		return mv;
	}
	
	@RequestMapping(value = "/board/modify", method = RequestMethod.GET)
	public ModelAndView boardModifyGet(ModelAndView mv, Integer num, HttpServletRequest r) {
		mv.setViewName("/board/modify");
		BoardVo board = boardService.getBoard(num);
		UserVo user = userService.getUser(r);
		if(board == null || !user.getId().equals(board.getWriter()))
			mv.setViewName("redirect:/board/list");
		mv.addObject("board",board);
		return mv;
	}
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public ModelAndView boardModifyGet(ModelAndView mv, BoardVo board, HttpServletRequest r,MultipartFile file2) throws IOException, Exception {
		mv.setViewName("redirect:/board/list");
		board.setWriter(userService.getUser(r).getId());
		//새로운 첨부파일이 추가되면
		if(!file2.getOriginalFilename().equals("")) {
			String fileName = UploadFileUtils.uploadFile(uploadPath, file2.getOriginalFilename(), file2.getBytes());
			board.setFile(fileName);
		}else if(board.getFile() == null || board.getFile().equals("")) {//board.getFile이 Null이거나 빈문자열과 같으면
			board.setFile(null);
		}
		boardService.updateBoard(board);
		return mv;
	}
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv, Integer num, HttpServletRequest r) {
		mv.setViewName("redirect:/board/list");
		boardService.deleteBoard(num, userService.getUser(r));
		return mv;
	}
//	추천 
	@RequestMapping(value ="/board/up", method=RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> boardUp(@RequestBody int num, HttpServletRequest r){//RequestBody: ajax의 data값과 같아야 함
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    //현재 로그인 중인 유저 정보
	    UserVo user = userService.getUser(r);
	    if(user == null) {
	    	map.put("isUser",false);
	    }else {
	    	map.put("isUser",true);
	    	int up = boardService.updateUp(num, user.getId());
	    	map.put("up",up);
	    }
	    return map;
	}
//	다운로드 테스트
	@ResponseBody//결과물을 직접 다운로드할수 있도록 해줌
	@RequestMapping(value="/board/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
	    InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	    	//HttpHeader 객체 생성
	        HttpHeaders headers = new HttpHeaders();
	        //다운로드 할 파일을 읽어옴
	        in = new FileInputStream(uploadPath+fileName);//FileInputStream : 파일을 읽어옴
	        //다운로드 시 저장할 파일명
	        fileName = fileName.substring(fileName.indexOf("_")+1);//fileName : 다운로드 할때의 fileName
	        //Header에 컨텐츠 타입 설정 (STREAM으로)
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        //Header 정보를 추가
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");//=> fileName(String)을 -> Byte로 변환(UTF-8기준) -> ISO-8859로 변환 (인코딩 설정)
	        //ResponseEntity:읽어온 파일(in),헤더정보을 저장함=> 객체 생성
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
}
