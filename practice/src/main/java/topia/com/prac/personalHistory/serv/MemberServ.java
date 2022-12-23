package topia.com.prac.personalHistory.serv;

import java.util.List;

import topia.com.prac.entity.Member;

public interface MemberServ {
	public void insertMember(Member ins);
	
	public Member getMember(Member member);
	
	public List<Member> boardList(Member member);
}
