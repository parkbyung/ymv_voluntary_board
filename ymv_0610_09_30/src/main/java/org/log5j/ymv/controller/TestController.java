package org.log5j.ymv.controller;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.RecruitBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@Resource(name="recruitBoardServiceImpl")
	private RecruitBoardService recruitBoardService;
	
	@RequestMapping("home.ymv")
	public String test(){
		return "index";
	}
	@RequestMapping("testTiles.ymv")
	public String testTiles(){
		return "home";
	}
	@RequestMapping("voluntary_board.ymv")
	public ModelAndView list(String pageNo) {	
		ListVO lvo = recruitBoardService.getBoardList(pageNo);
		System.out.println(lvo+"컨틀롤러");
		
		return new ModelAndView("voluntary_board","lvo",lvo);
	}
}
