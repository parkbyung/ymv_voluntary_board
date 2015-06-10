package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class RecruitBoardDAOImpl implements RecruitBoardDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> getBoardList(String pageNo){
		System.out.println(pageNo+"   RecruitBoardDAOImpl  getBoardList pageno");
		
		List<BoardVO> list = sqlSessionTemplate.selectList("board.getBoardList", pageNo);
		System.out.println("RecruitBoardDAOImpl db 들어가서 list 넣은거"+list);
		return list;
	}

	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("board.totalContent");
	}

}
