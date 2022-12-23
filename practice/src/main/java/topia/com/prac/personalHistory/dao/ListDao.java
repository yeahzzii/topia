package topia.com.prac.personalHistory.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import topia.com.prac.entity.UserInfo;
import topia.com.prac.entity.userVO;

@Repository
@Slf4j
public class ListDao {
	@Autowired
	private SqlSessionTemplate tpl;
	
	public List<userVO> getUserList(Integer userIdx) {
		return tpl.selectList("ListDao.getUserList", userIdx);
	}
	
	public UserInfo detailUserList(Integer userIdx) {
		return null;
	}

	public void deleteUserList(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteUserList", userinfo);
	}
	public void deleteCareerData(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteCareerData", userinfo);
	}
	public void deleteEduData(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteEduData", userinfo);
	}
	public void deleteLicenData(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteLicenData", userinfo);
	}
	public void deleteQualifiData(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteQualifiData", userinfo);
	}
	public void deleteSkillData(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteSkillData", userinfo);
	}
	public void deleteTrainingData(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteTrainingData", userinfo);
	}
	public void deleteBodyData(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteBodyData", userinfo);
	}
	public void deleteImageData(UserInfo userinfo) throws Exception {
		tpl.delete("ListDao.deleteImageData", userinfo);
	}
	 
	
	
	
}
