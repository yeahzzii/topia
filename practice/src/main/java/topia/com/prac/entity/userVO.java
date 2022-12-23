 package topia.com.prac.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data
@NoArgsConstructor
@AllArgsConstructor
public class userVO {
	private int rnum;
	private Integer userIdx;
	private String userName;
	private String userComp;
	private String userDept;
	private String userregisterdate;
	private String userSex;
	private String careerDate;
	private String userMaritalStatus;
	private String userAddress;
	
	
	public userVO(int rnum, Integer userIdx, String userName, String userComp, String userDept, String userregisterdate,
			String userSex, String careerDate, String userMaritalStatus, String userAddress) {
		super();
		this.rnum = rnum;
		this.userIdx = userIdx;
		this.userName = userName;
		this.userComp = userComp;
		this.userDept = userDept;
		this.userregisterdate = userregisterdate;
		this.userSex = userSex;
		this.careerDate = careerDate;
		this.userMaritalStatus = userMaritalStatus;
		this.userAddress = userAddress;
	}
	public userVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserComp() {
		return userComp;
	}
	public void setUserComp(String userComp) {
		this.userComp = userComp;
	}
	public String getUserDept() {
		return userDept;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	public String getUserregisterdate() {
		return userregisterdate;
	}
	public void setUserregisterdate(String userregisterdate) {
		this.userregisterdate = userregisterdate;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getCareerDate() {
		return careerDate;
	}
	public void setCareerDate(String careerDate) {
		this.careerDate = careerDate;
	}
	
	
	public String getUserMaritalStatus() {
		return userMaritalStatus;
	}
	public void setUserMaritalStatus(String userMaritalStatus) {
		this.userMaritalStatus = userMaritalStatus;
	}
	
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public String toString() {
		return "userVO [rnum=" + rnum + ", userIdx=" + userIdx + ", userName=" + userName + ", userComp=" + userComp
				+ ", userDept=" + userDept + ", userregisterdate=" + userregisterdate + ", userSex=" + userSex
				+ ", careerDate=" + careerDate + ", userMaritalStatus=" + userMaritalStatus + ", userAddress=" + userAddress + "]";
	}
	
	
	
}
