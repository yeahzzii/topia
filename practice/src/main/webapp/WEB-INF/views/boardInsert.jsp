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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="./resources/js/personalHistory/board.js" charset="UTF-8"></script>
<style>
.dateInput {
	font-size: 11px;
	min-width: 80px;
	background: #fff no-repeat;
}

.form-group {
	margin: 30px 0;
}

input[type=text] {
	height: 40px;
	width: 220px;
	border: 0;
	border-radius: 10px;
	outline: none;
	padding-left: 10px;
  	background-color: rgba(221, 221, 221, 0.2);
}

input[type=date] {
	font-size: 11px;
	height: 40px;
	width: 520px;
	border: 0;
	border-radius: 10px;
	outline: none;
	padding-left: 10px;
  	background-color: rgba(221, 221, 221, 0.2);
}

.notice {
	display: inline-block;
	padding-right: 80px;
}

.content {
	height: 440px;
	width: 634px;
	border: 0;
	border-radius: 10px;
	outline: none;
	padding-left: 10px;
  	background-color: rgba(221, 221, 221, 0.2);
}


input[type=checkbox] {
	padding: 0 30px;
}

#form-control {
	height: 40px; 
	width: 598px;
	border: 0;
	border-radius: 10px;
	outline: none;
	padding-left: 10px;
  	background-color: rgba(221, 221, 221, 0.2);
}

body {
	text-align: center;
}

button {
	height: 40px;
	width: 180px; 
	background-color: rgb(165, 147, 224);
	color: #ffffff;
	text-align: center;
	border: 0;
	border-radius: 10px;
	outline: none;
	padding-left: 10px;
}
</style>
<script type="text/javascript">
	// 화면 접근 시 바로 수행되게 하는 부분
	$(window).on("load", function() {
		// 달력 관련 함수 호출
		calendarFunc();
	});
</script>

</head>
<body>
	<div class="insArea">
		<h1>글 작성</h1>
		<form action="./boardInsert" method="post">
		<div class="">
			<div class="form-group">
				<label class="">등록자 아이디 </label> <span> <input type="text"
					class="idName" name="registId" id="registId" value="${member.userId}"
					readonly="readonly">
				</span>
				
				<label class="">등록자명 </label> <span> <input type="text"
					class="idName" value="${member.userName}" readonly="readonly">
				</span>
			</div>
		</div>
			<div class="form-group">
				<label class="">제목 </label>
					<input type="text" name="boardTitle" id="form-control" class="form-control">
			</div>

			<div class="form-group">
				<label class="">공지여부 > </label>
				<div class="notice">
					<input type="checkbox" name="noticeYN" class="notice"
						value="Y">공지등록 <input type="checkbox" name="noticeYN"
						class="notice" value="N">공지해제
				</div>
				
				<label class="">작성일자 </label>
					<input type="text" name="writeDate" id="writeDate"
						autocomplete="off" readonly="readonly" class="dateInput" /><br>
			</div>


			<div class="form-group">
				<label class="">내용</label>
				<div class="">
					<textarea class="content" name="boardContent" rows="18"></textarea>
				</div>
			</div>
			<div class="compose-button">
				<button class="" onclick="insertProc()">등록</button>
				<button class="" onclick="location.href='${path}/boardList'">
					<i class=""></i> 작성취소
				</button>
			</div>
		</form>
	</div>

</body>

<script>
	var isInsert = "${isInsert}"
	if (isInsert == "Y") {
		alert("등록에 성공했습니다.");
		location.href = "./boardList";

	}

	function insertProc() {
		if (confirm("등록하시겠습니까?")) {
			var subjectVal = $("[name=boardTitle]").val();
			if (subjectVal == "") {
				alert("제목을 입력하세요");
				$("[name=boardTitle]").focus();
				return; // 프로세스를 중단 처리
			}
			location.href = "./boardInsert"
		}
	}

	function goMain() {
		location.href = "./boardList.do"
	}
</script>
</html>