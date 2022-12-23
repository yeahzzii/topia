package topia.com.prac.personalHistory.serv;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import topia.com.prac.entity.UserInfo;
import topia.com.prac.entity.UserInfoSkill;
import topia.com.prac.entity.userVO;
import topia.com.prac.personalHistory.dao.ListDao;

@Service
public class ListService {
	@Autowired(required = false)
	private ListDao dao;
	
	public List<userVO> getUserList(Integer userIdx){
		
		
		return dao.getUserList(userIdx);
	
	}
	/*
	public void deleteUserList(UserInfo userinfo) throws Exception {
		dao.deleteUserList(userinfo);
	}
	 */
	

}


