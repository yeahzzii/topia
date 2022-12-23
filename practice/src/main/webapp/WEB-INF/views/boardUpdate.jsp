<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="./resources/js/personalHistory/board.js" charset="UTF-8"></script></head>
	<script type="text/javascript">
			// 화면 접근 시 바로 수행되게 하는 부분
			$(window).on("load",function(){
				// 달력 관련 함수 호출
				calendarFunc();
			});
		</script>
<body>
	<div class="compose-mail">
             
                <form action="./boardUpdate" method="post">
                
                
                    <%--
                    <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">제목 : </label>
                  <div class="col-sm-10">
                    <input type="text" name="boardTitle" class="form-control" value="${board.boardTitle}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">작성자 : </label>
                  
                  <div class="col-sm-10">
                
                    <input name="writer" type="text" value="">  
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">아이디 : </label>
                  
                  <div class="col-sm-10">
                    <input name="id" type="text" value="">  
                  </div>
                </div>
                    <div class="compose-editor">
                      내용 : <textarea class="wysihtml5 form-control" name="boardContent" rows="18">${board.boardContent}</textarea>
                    </div>
                    
                    <div class="compose-editor">
                      수정 : <textarea class="wysihtml5 form-control" name="boardContentReply" rows="18">${board.boardContentReply}</textarea>
                    </div>
                     --%>
                    <table>
                	<tr>
                	<td>
                	등록 아이디 : ${member.userId}<br>
                	등록자명 : ${member.userName}<br>
                	수정 아이디 : <input type="text" name="updateId" id="updateId" /><br>
                	제목 : <input type="text" name="boardTitle" id="boardTitle" value="${board.boardTitle}"/><br>
                	<label class="col-sm-2 col-sm-2 control-label">공지여부 : </label>
                  <div class="col-sm-10">
                    <input type="checkbox" name="noticeYN" class="form-control" value="Y">공지등록
                    <input type="checkbox" name="noticeYN" class="form-control" value="N">공지해제
                  </div><br>
                	<label class="col-sm-2 col-sm-2 control-label">작성일자 : </label>
                  <div class="col-sm-10">
                    <input type="text" name="writeDate" id="writeDate" autocomplete="off" class="dateInput" value="${board.writeDate}"/><br>
                  </div><br>
                	질문내용 : <textarea rows="" cols="">${board.boardContent}</textarea><br>
                	내용답변 : <textarea rows="" cols="">${board.boardContentReply}</textarea><br>
                	</td>
                	</tr>
              	  </table>
                    
                    
					<div class="compose-button">
                      <button class="btn btn-theme btn-sm" onclick="updateProc()"><i class="fa fa-check"></i> 등록</button>
                      <button class="btn btn-sm" onclick="location.href='${path}/boardList'"><i class="fa fa-times"></i> 작성취소</button>
                    </div>   
                  </form>
                </div>
</body>

<script>
	function goMain(){
	location.href="${path}/boardList"
	}
	function updateProc(){
		var boardNum = "${param.boardNum}"
		if(confirm("수정하시겠습니까?")){
			$("form").attr("action","./boardUpdate?boardNum="+boardNum);
			$("form").submit();
		}
	}
	var proc = "${proc}"
		if(proc=="upt"){
			if(confirm("수정성공\n리스트로 돌아갑니다.")){
				location.href="./boardList";
			}
		}
	
	function goMain(){
		location.href="./boardList.do"
	}
</script>
</html>