package topia.com.prac.personalHistory.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import topia.com.prac.entity.*;

@Repository
public class UserInfoBodyDao {

	@Autowired
	private SqlSessionTemplate tpl;
	
	public Integer insertUserBody(Map<String, Object> paramMap) {
		return tpl.insert("bodyDao.insert", paramMap);
	}
	
	public Integer updateUserBody(UserInfoBody userInfoBody) {
		return tpl.update("bodyDao.updateUserBody", userInfoBody);
	}

	public List<UserInfoBody> list(int intUserIdx) {
		return tpl.selectList("bodyDao.list", intUserIdx);
	}
}
