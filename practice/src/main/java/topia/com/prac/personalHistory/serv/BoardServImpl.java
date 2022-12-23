package topia.com.prac.personalHistory.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topia.com.prac.entity.Board;
import topia.com.prac.entity.Criteria;
import topia.com.prac.personalHistory.dao.BoardDao;

@Service
public class BoardServImpl {
	@Autowired(required=false)
	private BoardDao dao;
	
	public List<Board> boardList(Board board) {
		return dao.boardList(board);
	}
	
	public void boardInsert(Board ins) {
		dao.boardInsert(ins);
	}
	
	public Board boardDetail(int boardNum) {
		return dao.boardDetail(boardNum);
	}
	
	public Board boardUpdate(Board upt) {
		dao.boardUpdate(upt);;
		return dao.boardDetail(upt.getBoardNum());
	}
	
	public void boardDelete(int boardNum) {
		dao.boardDelete(boardNum);
	}
	
	// 게시판 목록(페이징 적용) 
    public List<Board> getListPaging(Criteria cri) {
        
        return dao.getListPaging(cri);
    }    
    
    public int getTotal(Criteria cri) {
    	 return dao.getTotal(cri);
    }
}
