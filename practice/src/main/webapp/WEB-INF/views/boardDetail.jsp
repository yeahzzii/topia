<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th td {
	
}
</style>
</head>
<body>
	<section class="panel">
              <header class="">
                <h4 class="">
                    게시판 상세
                  </h4>
              </header>
       
           
                <div class="">
                <table>
                	<tr>
                	<td>
                	등록 아이디 : ${member.userId}<br>
                	등록자명 : ${member.userName}<br>
                	수정 아이디 : ${board.updateId}<br>
                	제목 : ${board.boardTitle}<br>
                	공지 여부 : ${board.noticeYN}<br>
                	작성일자 :${board.writeDate}<br>
                	질문내용 : <textarea rows="" cols="" readonly="readonly">${board.boardContent}</textarea><br>
                	내용답변 : <textarea rows="" cols="" readonly="readonly">${board.boardContentReply}</textarea><br>
                	</td>
                	</tr>
                </table>
                  <button class="" onclick="goUpdate(${board.boardNum})"> 수정</button>
                  <button class="" onclick="deleteProc()"><i class="fa fa-times"></i>삭제</button>
                  <button class=""onclick="goMain()">목록</button>
                </div>
             
            </section>
</body>
<script>
	function goUpdate(boardNum){
		location.href="./boardUpdateForm?boardNum="+boardNum;  
	}
	
	function deleteProc(){
		var boardNum = "${param.boardNum}"
		if(confirm("삭제하시겠습니까?")){
			location.href="./boardDelete?boardNum="+boardNum;
			alert("삭제성공\n리스트로 이동합니다.");
			location.href="./boardList"
		}
	}

	var proc = "${proc}"
	if(proc=="del"){
		location.href="./boardList";
		
	}
	
	function goMain(){
		location.href="./boardList"
	}
</script>
</html>