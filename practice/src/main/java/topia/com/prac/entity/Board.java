package topia.com.prac.entity;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardContentReply;
	private String noticeYN;
	private String writeDate;
	private Date registDate;
	private Date updateDate;
	private String registId;
	private String updateId;
	private String registIp;
	private String updateIp;
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int boardNum, String boardTitle, String boardContent, String boardContentReply, String noticeYN,
			String writeDate, Date registDate, Date updateDate, String registId, String updateId, String registIp,
			String updateIp) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardContentReply = boardContentReply;
		this.noticeYN = noticeYN;
		this.writeDate = writeDate;
		this.registDate = registDate;
		this.updateDate = updateDate;
		this.registId = registId;
		this.updateId = updateId;
		this.registIp = registIp;
		this.updateIp = updateIp;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardContentReply() {
		return boardContentReply;
	}
	public void setBoardContentReply(String boardContentReply) {
		this.boardContentReply = boardContentReply;
	}
	public String getNoticeYN() {
		return noticeYN;
	}
	public void setNoticeYN(String noticeYN) {
		this.noticeYN = noticeYN;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getRegistId() {
		return registId;
	}
	public void setRegistId(String registId) {
		this.registId = registId;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getRegistIp() {
		return registIp;
	}
	public void setRegistIp(String registIp) {
		this.registIp = registIp;
	}
	public String getUpdateIp() {
		return updateIp;
	}
	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}
	
	
	
	
	
}
