package topia.com.prac.entity;

import java.sql.Date;

public class Member {
	private int userIdx;
	private String userId;
	private String userPassword;
	private String userName;
	private String userEmail;
	private String userAddress;
	private String userSex;
	private String userPhoneNumber;
	private String userAuth;
	private Date userRegistDate;
	private Date userUpdateDate;
	private String userIp;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(int userIdx, String userId, String userPassword, String userName, String userEmail,
			String userAddress, String userSex, String userPhoneNumber, String userAuth, Date userRegistDate,
			Date userUpdateDate, String userIp) {
		super();
		this.userIdx = userIdx;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userSex = userSex;
		this.userPhoneNumber = userPhoneNumber;
		this.userAuth = userAuth;
		this.userRegistDate = userRegistDate;
		this.userUpdateDate = userUpdateDate;
		this.userIp = userIp;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	
	
	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}

	public Date getUserRegistDate() {
		return userRegistDate;
	}

	public void setUserRegistDate(Date userRegistDate) {
		this.userRegistDate = userRegistDate;
	}

	public Date getUserUpdateDate() {
		return userUpdateDate;
	}

	public void setUserUpdateDate(Date userUpdateDate) {
		this.userUpdateDate = userUpdateDate;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	 

	@Override
	public String toString() {
		return "Member [userIdx=" + userIdx + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", userEmail=" + userEmail + ", userAddress=" + userAddress + ", userSex=" + userSex
				+ ", userPhoneNumber=" + userPhoneNumber + ", userAuth=" + userAuth + ", userRegistDate="
				+ userRegistDate + ", userUpdateDate=" + userUpdateDate + ", userIp=" + userIp + "]";
	}

	
}
