package org.log5j.ymv.model.board;

import java.util.List;

public interface RecruitBoardDAO {
	public  List<BoardVO> getBoardList(String pageNo);
	public  int totalContent();
}
