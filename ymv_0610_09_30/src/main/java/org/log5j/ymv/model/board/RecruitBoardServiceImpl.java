package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class RecruitBoardServiceImpl implements RecruitBoardService {
	@Resource(name="recruitBoardDAOImpl")
	private RecruitBoardDAO recruitBoardDAO;
	@Override
	public ListVO getBoardList(String pageNo){
		if(pageNo==null||pageNo=="") 
			pageNo="1";
		List<BoardVO> list=recruitBoardDAO.getBoardList(pageNo);
		System.out.println("pageNo가 1인 상태에서 보드 리스트들을 받아오는 거"+list);
		System.out.println("RecruitBoardServiceImpl getBoardList 완료");
		int total=recruitBoardDAO.totalContent();
		System.out.println("RecruitBoardServiceImpl totalContent: "+total);
		PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
		System.out.println("paging 완료 그리고 listvo넣기전"+paging);
		ListVO lvo=new ListVO(list,paging);
		System.out.println("lvo: "+lvo);
		return lvo;
	}

}
