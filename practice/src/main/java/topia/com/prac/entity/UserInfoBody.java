package topia.com.prac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserInfoBody {
	private Integer bodyIdx;
	private Integer userIdx;
	private String bodyBloodType;
	private double bodyWeight;
	private double bodyHeight;
	private double bodyEyeSightLeft; 
	private double bodyEyeSightRight;
	public Integer getBodyIdx() {
		return bodyIdx;
	}
	public void setBodyIdx(Integer bodyIdx) {
		this.bodyIdx = bodyIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getBodyBloodType() {
		return bodyBloodType;
	}
	public void setBodyBloodType(String bodyBloodType) {
		this.bodyBloodType = bodyBloodType;
	}
	public double getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(double bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	public double getBodyHeight() {
		return bodyHeight;
	}
	public void setBodyHeight(double bodyHeight) {
		this.bodyHeight = bodyHeight;
	}
	public double getBodyEyeSightLeft() {
		return bodyEyeSightLeft;
	}
	public void setBodyEyeSightLeft(double bodyEyeSightLeft) {
		this.bodyEyeSightLeft = bodyEyeSightLeft;
	}
	public double getBodyEyeSightRight() {
		return bodyEyeSightRight;
	}
	public void setBodyEyeSightRight(double bodyEyeSightRight) {
		this.bodyEyeSightRight = bodyEyeSightRight;
	} 
	
	
}
