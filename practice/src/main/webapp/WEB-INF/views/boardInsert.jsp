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
	<script src="./resources/js/personalHistory/board.js" charset="UTF-8"></script>
<style>
input[type=date]{
	font-size: 11px;
}
.dateInput{
	font-size: 11px;
	min-width: 80px;
	background:#fff no-repeat ;
}
</style>
<script type="text/javascript">
			// 화면 접근 시 바로 수행되게 하는 부분
			$(window).on("load",function(){
				// 달력 관련 함수 호출
				calendarFunc();
			});
		</script>
</head>
<body>
	<div class="compose-mail">
             
                <form action="./boardInsert" method="post">
                
                
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">등록자 아이디 : </label>
                  
                  <span>
                  <input type="text" name="registId" id="registId" value="${member.userId}" readonly="readonly">
                    
                  </span>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">등록자명 : </label>
                  
                  <span>
                    <input type="text"  value="${member.userName}" readonly="readonly">
                  </span>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">제목 : </label>
                  <div class="col-sm-10">
                    <input type="text" name="boardTitle" class="form-control">
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">공지여부 : </label>
                  <div class="col-sm-10">
                    <input type="checkbox" name="noticeYN" class="form-control" value="Y">공지등록
                    <input type="checkbox" name="noticeYN" class="form-control" value="N">공지해제
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 col-sm-2 control-label">작성일자 : </label>
                  <div class="col-sm-10">
                    <input type="text" name="writeDate" id="writeDate" autocomplete="off" readonly="readonly" class="dateInput"/><br>
                  </div>
                </div>
                
                <div class="form-group">
                <label class="col-sm-2 col-sm-2 control-label">내용 : </label>
                    <div class="compose-editor">
                      <textarea class="wysihtml5 form-control" name="boardContent" rows="18"></textarea>
                    </div>
                </div>
					<div class="compose-button">
                      <button class="btn btn-theme btn-sm" onclick="insertProc()"><i class="fa fa-check"></i> 등록</button>
                      <button class="btn btn-sm" onclick="location.href='${path}/boardList'"><i class="fa fa-times"></i> 작성취소</button>
                    </div>   
                  </form>
                </div>
</body>

<script>
	var isInsert = "${isInsert}"
	if(isInsert=="Y"){
	   	  alert("등록에 성공했습니다.");
	      location.href="./boardList";
	   
	}

	function insertProc(){
		if(confirm("등록하시겠습니까?")){
		   var subjectVal = $("[name=boardTitle]").val();
		   if(subjectVal == ""){
		      alert("제목을 입력하세요");
		      $("[name=boardTitle]").focus();
		      return; // 프로세스를 중단 처리
	   		}
	   		location.href="./boardInsert"
	   		}
	}
	
	function goMain(){
		location.href="./boardList.do"
	}
</script>
</html>