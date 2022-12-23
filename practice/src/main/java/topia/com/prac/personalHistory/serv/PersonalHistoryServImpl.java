package topia.com.prac.personalHistory.serv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import topia.com.prac.HomeController;
import topia.com.prac.entity.Image;
import topia.com.prac.entity.UserInfo;
import topia.com.prac.entity.userVO;
import topia.com.prac.personalHistory.dao.AbstractDAO;
import topia.com.prac.personalHistory.dao.ImageDao;
import topia.com.prac.personalHistory.dao.ListDao;
import topia.com.prac.personalHistory.dao.UserInfoBodyDao;
import topia.com.prac.personalHistory.dao.UserInfoCareerDao;
import topia.com.prac.personalHistory.dao.UserInfoEduDao;
import topia.com.prac.personalHistory.dao.UserInfoLicenDao;
import topia.com.prac.personalHistory.dao.UserInfoQualifiDao;
import topia.com.prac.personalHistory.dao.UserInfoSkillDao;
import topia.com.prac.personalHistory.dao.UserInfoTrainingDao;
import topia.com.util.Sha256;

@Service
public class PersonalHistoryServImpl implements PersonalHistoryServ {

	@Autowired
	AbstractDAO dbCon;
	@Autowired
	private UserInfoCareerDao cDao;
	@Autowired
	private UserInfoEduDao eDao;
	@Autowired
	private UserInfoLicenDao lDao;
	@Autowired
	private UserInfoQualifiDao qDao;
	@Autowired
	private UserInfoSkillDao sDao;
	@Autowired
	private UserInfoTrainingDao tDao;
	@Autowired
	private UserInfoBodyDao bDao;
	@Autowired
	private ImageDao imgDao;
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Override
	/**
	 * 湲곗〈 �벑濡앸맂 媛쒖씤 �씠�젰移대뱶 媛��졇�삤湲�
	 */
	public HashMap<String, Object> userList(HashMap<String, Object> reqMap) {
		log.info("SERVICE==========ReqMap=========");
//		for(String key: reqMap.keySet()) {
//			log.info("{}: {}",key, reqMap.get(key));
//		}
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		ArrayList<Object> list;
		String totalCnt = "";
		String userCareerLength = ((String[]) reqMap.get("userCareerLength"))[0];
		//String userGender = ((String[]) reqMap.get("userGender"))[0];
		String userGender = "";
		String userMaritalStatus = "";
		String keywords = ((String[]) reqMap.get("keywords"))[0];
		try {
			
			 if (userCareerLength.equals("")) {
				  userCareerLength = null;
				  reqMap.put("userCareerLength", userCareerLength);
			 }
			 
			 if (keywords.equals("")) {
				 keywords = null;
				 reqMap.put("keywords", keywords);
			}else {
				reqMap.put("keywords", keywords.split(","));
			}
			
			if (!userGender.equals("")) {
				userGender = ((String[]) reqMap.get("userGender"))[0];
				reqMap.put("userGender", userGender);
			}
			if (!userMaritalStatus.equals("")) {
				userMaritalStatus = ((String[]) reqMap.get("userMaritalStatus"))[0];
				reqMap.put("userMaritalStatus", userMaritalStatus);
			}
			
			for(String key: reqMap.keySet()) {
				log.info("{}: {}",key, reqMap.get(key));
			}
			
	
			list = (ArrayList<Object>) dbCon.selectList("personalHistory.userList", reqMap);
			totalCnt = String.valueOf(dbCon.selectOne("personalHistory.userListCount", reqMap));
			
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
			
			resMap.put("list", list);
			resMap.put("totalCnt", totalCnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("==================={}", resMap);
		return resMap;
	}

	/**
	 * �깉濡� �옉�꽦�븳 媛쒖씤 �씠�젰移대뱶 �벑濡�
	 * 
	 * @param Object inputdata : map �삎�깭�쓽 怨좎젙�뜲�씠�꽣�� json string �삎�깭�쓽 �쑀�룞�뜲�씠�꽣 �룷�븿
	 * @return statusNum �벑濡� �꽦怨듭뿬遺�
	 */
	@Override
	@Transactional
	public HashMap<String, Object> registerUser(Object inputdata) {

		int statusNum = 0;
		HashMap<String, Object> resMap = new HashMap<String, Object>();

		try {

			HashMap<String, Object> map = (HashMap<String, Object>) inputdata;
			String socialNum = ((String[]) map.get("userSocialSecunum"))[0]; // 二쇰�쇰벑濡앸쾲�샇 �븫�샇�솕

			String encodedSocialNum = Sha256.encrypt(socialNum);

			map.replace("userSocialSecunum", encodedSocialNum);

			// ------------------------------------ 以묐났 �뿬遺� �솗�씤

			ArrayList<Object> duplitedList = (ArrayList<Object>) dbCon.selectList("personalHistory.findDuplitedUserInfo", map);

			System.out.println("size : " + duplitedList.size());

			// ------------------------------------ 以묐났 �뿬遺� �솗�씤
			if (duplitedList.size() > 0 && !socialNum.equals("1111111111111")) {

				resMap.put("errorCode", "1001");
				//resMap.put("errorMsg", "以묐났�맂 �궗�슜�옄�엯�땲�떎.");
				resMap.put("errorMsg", "이미 등록된 주민번호입니다.");

				return resMap; // 以묐났�씪 寃쎌슦 �뿉�윭肄붾뱶 由ы꽩
			} else {
				statusNum = (Integer) dbCon.insert("personalHistory.registerUser", map);
				// �쑀�룞�삎 �뜲�씠�꽣 json String -> ArrayList<HashMap<String, Object>> parsing

				String[] strList = (String[]) map.get("flexibleData");
				String listJsonStr = strList[0];

				int userIdx = (Integer) map.get("userIdx"); // 怨좎젙 �뜲�씠�꽣濡� �벑濡앸맂 pk瑜� �쑀�룞�뜲�씠�꽣�쓽 fk濡� �궗�슜
				log.info("=======================userIdx{}", userIdx);
				
				
				ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
				ObjectMapper mapper = new ObjectMapper();
				list = mapper.readValue(listJsonStr, ArrayList.class);

				log.info("=======================list{}", list);
				for (int i = 0; i < list.size(); i++) {
					String key = (String) list.get(i).get("tbName");
					
					Map<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.putAll(list.get(i));
					paramMap.put("userIdx",userIdx);
					
					if(key.equals("edu")) {
						eDao.insert(paramMap);
					}else if(key.equals("qualifi")) {
						qDao.insert(paramMap);
					}else if(key.equals("career")) {
						cDao.insert(paramMap);
					}else if(key.equals("training")) {
						tDao.insert(paramMap);
					}else if(key.equals("licen")) {
						lDao.insert(paramMap);
					}else if(key.equals("skill")) {
						sDao.insert(paramMap);
					}
				}
				
				resMap.put("userIdx", userIdx);

			}

		} catch (Exception e) {
			System.out.println("ERROR registerUserDAOImpl : " + e);
			e.printStackTrace();
		}
		log.info("============SERVICE RESMAP:{}",resMap);
		return resMap;
	}

	/**
	 * 湲곗〈 媛쒖씤�씠�젰移대뱶 �벑濡앷굔�뿉 ���븳 �닔�젙泥섎━
	 * 
	 * @HashMap<String,Object> inputdata : map �삎�깭�쓽 怨좎젙�뜲�씠�꽣�� json string �삎�깭�쓽 �쑀�룞�뜲�씠�꽣 �룷�븿
	 * 
	 * @return statusNum �벑濡� �꽦怨듭뿬遺�
	 */
	@Override
	public int registerUserUpdate(HashMap<String, Object> inputdata) {

		int statusNum = 0;

		try {
			statusNum = (Integer) dbCon.update("personalHistory.registerUserUpdate", inputdata);

			String[] strList = (String[]) inputdata.get("flexibleData");
			String listJsonStr = strList[0];

			String[] userIdxArr = (String[]) inputdata.get("userIdx");
			String userIdx = userIdxArr[0];

			inputdata.replace("userIdx", userIdx);

			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
			ObjectMapper mapper = new ObjectMapper();
			list = mapper.readValue(listJsonStr, ArrayList.class);

			// �쑀�룞�뜲�씠�꽣 �궘�젣泥섎━
			// �닔�젙嫄댁뿉 ���빐�꽌留� 濡쒖쭅泥섎━濡� 蹂�寃쏀븯硫� 醫뗭쓣寃�
			// �쁽�옱 濡쒖쭅 : 怨좎젙�뜲�씠�꽣 �뾽�뜲�씠�듃, �쑀�룞�뜲�씠�꽣 �쟾泥댁궘�젣 �썑 �옱�벑濡�
			dbCon.delete("personalHistory.deleteCareerData", inputdata);
			dbCon.delete("personalHistory.deleteEduData", inputdata);
			dbCon.delete("personalHistory.deleteLicenData", inputdata);
			dbCon.delete("personalHistory.deleteQualifiData", inputdata);
			dbCon.delete("personalHistory.deleteSkillData", inputdata);
			dbCon.delete("personalHistory.deleteTrainingData", inputdata);
			dbCon.delete("personalHistory.deleteBodyData", inputdata);

			// �쑀�룞�뜲�씠�꽣 �옱�벑濡�
			for (int i = 0; i < list.size(); i++) {
				String key = (String) list.get(i).get("tbName");
				
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.putAll(list.get(i));
				paramMap.put("userIdx",userIdx);
				
				if(key.equals("edu")) {
					eDao.insert(paramMap);
				}else if(key.equals("qualifi")) {
					qDao.insert(paramMap);
				}else if(key.equals("career")) {
					cDao.insert(paramMap);
				}else if(key.equals("training")) {
					tDao.insert(paramMap);
				}else if(key.equals("licen")) {
					lDao.insert(paramMap);
				}else if(key.equals("skill")) {
					sDao.insert(paramMap);
				}
			
			}

		} catch (Exception e) {
			System.out.println("ERROR registerUserDAOImpl : " + e);
		}

		return statusNum;
	}

	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> getRegisterData(Map<String, Object> reqMap)
			throws JsonParseException, JsonMappingException, IOException {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		log.info("SERVICE==========ReqMap=========");
		for(String key: reqMap.keySet()) {
			log.info("{}: {}",key, reqMap.get(key));
		}
		String[] strList = (String[]) reqMap.get("tbNames");
		String listJsonStr = strList[0];
		String[] userIdxList = (String[]) reqMap.get("userIdx");
		String userIdx = userIdxList[0];

		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		ObjectMapper mapper = new ObjectMapper();
		list = mapper.readValue(listJsonStr, ArrayList.class);
		log.info("=======================LIST{}",list);
		// ---------------------------------------- 怨좎젙 而щ읆 �뜲�씠�꽣 泥섎━
		HashMap<String, Object> fixedMap = new HashMap<String, Object>();

		fixedMap.put("userIdx", userIdx);

		ArrayList<Object> arr = (ArrayList<Object>) dbCon.selectList("personalHistory.getRegisterData", fixedMap);
		resMap.put("fixedData", arr);
		
		int intUserIdx = Integer.parseInt(userIdx);
			
		resMap.put("edu", eDao.list(intUserIdx));
		resMap.put("qualifi", qDao.list(intUserIdx));
		resMap.put("career", cDao.list(intUserIdx));
		resMap.put("training", tDao.list(intUserIdx));
		resMap.put("licen", lDao.list(intUserIdx));
		resMap.put("skill", sDao.list(intUserIdx));
		resMap.put("body", bDao.list(intUserIdx));

		return resMap;
	}

	@Override
	public int imgInsert(MultipartFile file, String imgName, Image image) throws IllegalStateException, IOException {
		String path = "C:/WorkSpace/practice/src/main/webapp/resources/upload";
		log.info("+-----OriginalFilename------+");
		log.info("{}", file.getOriginalFilename());
		log.info("+---------------------------+");

		int lastOfDot = file.getOriginalFilename().lastIndexOf(".");

		String extension = file.getOriginalFilename().substring(lastOfDot + 1);
		
		imgName = file.getOriginalFilename();
		
		String savedName = imgName; // + "." + extension;

		log.info(savedName);
		File picture = new File(path, savedName);
		file.transferTo(picture);
		image.setImgName(savedName);
		
		return imgDao.imgInsert(file, savedName, image);
	}

	@Override
	public int imgUpdate(MultipartFile file, String imgName, Image image) throws IllegalStateException, IOException {
		String path = "C:/WorkSpace/practice/src/main/webapp/resources/upload";
		log.info("+-----OriginalFilename------+");
		log.info("FILE :{}", file);
		log.info("{}", file.getOriginalFilename());
		log.info("+---------------------------+");
		
		int lastOfDot = file.getOriginalFilename().lastIndexOf(".");

		String extension = file.getOriginalFilename().substring(lastOfDot + 1);

		imgName = file.getOriginalFilename();
		
		String savedName = imgName; // + "." + extension;

		log.info("���옣�븷 �씠由� :{}",savedName);
		File picture = new File(path, savedName);
		file.transferTo(picture);
		image.setImgName(savedName);
		
		int userIdx = image.getUserIdx();
		Image result = imgDao.getUserImg(userIdx);	// �씠誘몄�瑜� 議고쉶�빐�꽌
		if(result==null) {							// 寃곌낵媛� null�씠硫�
			//Image image2 = new Image();
			System.out.println("@@@@@@ 글이 등록된상태에서 이미지를 신규로 등록..@@@@@@@@");
			//글이 등록된상태에서 이미지를 신규로 등록..:값을 세팅다시 해줌
//			result.setImgName(savedName);
//			result.setImgIdx(null);
//			result.setUserIdx(userIdx);
			return imgDao.imgInsert(file, savedName, image);			// �닔�젙�씠 �븘�땲�씪 �궫�엯�쓣 �빐以��떎
		}
		return imgDao.imgUpdate(image);
	}

	public Image getUserImg(Integer userIdx) {
		return imgDao.getUserImg(userIdx);
	}

	public List<String> getUserCountByCareerDate() {
		return dbCon.selectList("personalHistory.getUserCountByCareerDate");
	}
	
	public HashMap<String, Object> excelDownload(){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<HashMap<String,Object>> list = (List<HashMap<String,Object>>) dbCon.selectList("personalHistory.getinfo");
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row;
		HSSFCell cell;
		// �궎媛� �솗�씤
		for(String key: list.get(0).keySet()) {
			System.out.println(key);
		}
		
		if(list.size()>0) {
			
			for(int i=0;i<list.size();i++) {
				row=sheet.createRow(i);
				cell=row.createCell(0);
				cell.setCellValue(String.valueOf(list.get(i).get("USER_IDX")));
				cell=row.createCell(1);
				cell.setCellValue(String.valueOf(list.get(i).get("USER_NAME")));
				cell=row.createCell(2);
				cell.setCellValue(String.valueOf(list.get(i).get("USER_COMP")));
				cell=row.createCell(3);
				cell.setCellValue(String.valueOf(list.get(i).get("USERREGISTERDATE")));
				cell=row.createCell(4);
				cell.setCellValue(String.valueOf(list.get(i).get("USER_SEX")));
				cell=row.createCell(5);
				cell.setCellValue(String.valueOf(list.get(i).get("CAREER_DATE")));
				
				
			}
			
			File file = new File("C:\\test\\testWrite.xls");
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FileOutputStream fos = null;
			
			try {
				fos = new FileOutputStream(file);
				workbook.write(fos);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(workbook != null) workbook.close();
					if(fos != null) fos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			map.put("success", "Y");
		}else {
			map.put("success", "N");
		}
		
		return map;
	}

	@Override
	public HashMap<String, Object> insertUserBody(Object inputdata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUserBody(HashMap<String, Object> intputdata) {
		// TODO Auto-generated method stub
		return 0;
	}
	/*
	
	 */
	@Autowired(required = false)
	private ListDao dao;
	@Override
	public List<userVO> getUserList(Integer userIdx){
		
		
		return dao.getUserList(userIdx);
	
	}
	
	@Autowired(required = false)
	@Override
	public UserInfo detailUserList(Integer userIdx) {
		
		return dao.detailUserList(userIdx);
	}
	
	@Autowired(required = false)
	@Override
	public void deleteUserList(UserInfo userinfo) {
		try {
			dao.deleteCareerData(userinfo);
			dao.deleteEduData(userinfo);
			dao.deleteLicenData(userinfo);
			dao.deleteQualifiData(userinfo);
			dao.deleteSkillData(userinfo);
			dao.deleteTrainingData(userinfo);
			dao.deleteBodyData(userinfo);
			dao.deleteImageData(userinfo);
			dao.deleteUserList(userinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	
}
