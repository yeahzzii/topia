package topia.com.prac.entity;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//lombok동작이  들쑥날쑥해서   @Data주석하고  getter,setter수동생성
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoEdu {

	private Integer eduIdx;
	private Integer userIdx;
	private String eduSchoolName;
	private String eduStatus;
	private Date eduGraduation;
	

	public Integer getEduIdx() {
		return eduIdx;
	}
	public void setEduIdx(Integer eduIdx) {
		this.eduIdx = eduIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getEduSchoolName() {
		return eduSchoolName;
	}
	public void setEduSchoolName(String eduSchoolName) {
		this.eduSchoolName = eduSchoolName;
	}
	public String getEduStatus() {
		return eduStatus;
	}
	public void setEduStatus(String eduStatus) {
		this.eduStatus = eduStatus;
	}


	public Date getEduGraduation() {
		return eduGraduation;
	}


	public void setEduGraduation(Date eduGraduation) {
		this.eduGraduation = eduGraduation;
	}
	
	
}
