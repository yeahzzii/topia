package topia.com.prac.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Image {
	private Integer imgIdx;
	private Integer userIdx;
	private String imgName;
	private MultipartFile file;
	
	public Integer getImgIdx() {
		return imgIdx;
	}
	public void setImgIdx(Integer imgIdx) {
		this.imgIdx = imgIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Image [imgIdx=" + imgIdx + ", userIdx=" + userIdx + ", imgName=" + imgName + ", file=" + file + "]";
	}
	
}
