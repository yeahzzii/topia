package topia.com.prac.personalHistory.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topia.com.prac.entity.Member;
import topia.com.prac.personalHistory.dao.MemberDao;

@Service
public class MemberServImpl {
	@Autowired(required=false)
	private MemberDao dao;
	
	public void insertMember(Member ins) {
		dao.insertMember(ins);
	}
	
	public int hasId(String userID) {
		return dao.hasId(userID);
	}
	
	public Member getMember(Member member) {
		return dao.getMember(member);
	}
	
	public List<Member> boardList(Member member) {
		return dao.memberList(member);
	}
}
