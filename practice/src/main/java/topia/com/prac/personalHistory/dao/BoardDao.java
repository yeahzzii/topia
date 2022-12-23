package topia.com.prac.personalHistory.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import topia.com.prac.entity.Board;
import topia.com.prac.entity.Criteria;

@Repository
@Slf4j
public class BoardDao {
	
	@Autowired
	private SqlSessionTemplate tpl;
	
	public List<Board> boardList(Board board) {
		return tpl.selectList("BoardDao.boardList", board);
	}
	
	public void boardInsert(Board ins) {
		 tpl.insert("BoardDao.boardInsert", ins);
	}
	
	public Board boardDetail(int boardNum) {
		return tpl.selectOne("BoardDao.boardDetail", boardNum);
	}
	
	public void boardUpdate(Board upt) {
		tpl.update("BoardDao.boardUpdate", upt);
	}
	
	public void boardDelete(int boardNum) {
		tpl.delete("BoardDao.boardDelete", boardNum);
	}
	
	// 게시판 목록(페이징 적용)
	public List<Board> getListPaging(Criteria cri) {
		return tpl.selectList("BoardDao.getListPaging", cri);
	}
	
	public int getTotal(Criteria cri) {
		return tpl.selectOne("BoardDao.getTotal", cri);
		
	}

} 
