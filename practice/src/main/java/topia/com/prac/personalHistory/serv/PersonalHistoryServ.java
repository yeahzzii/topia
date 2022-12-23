package topia.com.prac.personalHistory.serv;

import java.io.*;
import java.util.*;

import org.mybatis.spring.*;
import org.codehaus.jackson.*;
import org.codehaus.jackson.map.*;
import org.springframework.web.multipart.*;

import topia.com.prac.entity.*;

public interface PersonalHistoryServ {
	public HashMap<String, Object> userList(HashMap<String,Object> reqMap); 
	HashMap<String,Object> registerUser(Object inputdata);
	public int registerUserUpdate(HashMap<String,Object> intputdata);
	public HashMap<String, Object> getRegisterData(Map<String, Object> userIdx) throws JsonParseException, JsonMappingException, IOException;
	int imgInsert(MultipartFile file, String imgName, Image image) throws IllegalStateException, IOException;
	int imgUpdate(MultipartFile file, String imgName, Image image) throws IllegalStateException, IOException;
	HashMap<String,Object> insertUserBody(Object inputdata);
	public int updateUserBody(HashMap<String,Object> intputdata);
	List<userVO> getUserList(Integer userIdx);
	public UserInfo detailUserList(Integer userIdx);
	public void deleteUserList(UserInfo userinfo);
}
