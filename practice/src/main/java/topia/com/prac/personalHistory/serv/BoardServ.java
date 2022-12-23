package topia.com.prac.personalHistory.serv;

import java.util.List;

import topia.com.prac.entity.Board;
import topia.com.prac.entity.Criteria;

public interface BoardServ {
	public List<Board> boardList(Board board);
	
	public void boardInsert(Board ins);
	
	public Board boardDetail(int boardNum);
	
	public void boardUpdate(Board upt);
	
	public void boardDelete(int boardNum);
	
	public List<Board> getListPaging(Criteria cri);
	
    public int getTotal(Criteria cri);
}
