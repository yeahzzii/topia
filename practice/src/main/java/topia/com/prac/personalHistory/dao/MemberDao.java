package topia.com.prac.personalHistory.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import topia.com.prac.entity.Member;

@Repository
@Slf4j
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate tpl;
	
	public void insertMember(Member ins) {
		tpl.insert("MemberDao.insertMember", ins);
	}

	public int hasId(String userId) {
		return tpl.selectOne("MemberDao.hasId", userId);
	}
	
	public Member getMember(Member member) {
		return tpl.selectOne("MemberDao.getMember", member);
	}
	
	public List<Member> memberList(Member member) {
		return tpl.selectList("MemberDao.memberList", member);
	}
} 
