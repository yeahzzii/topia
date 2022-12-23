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
</head>
<body>
<div id="login-page">
    <div class="container">
      <form class="form-login" action="./loginaction" method="post">
        <h2 class="form-login-heading">로그인</h2>
        <div class="login-wrap">
          <input type="text" class="form-control" placeholder="ID" name="userId" autofocus>
          <br>
          <input type="password" class="form-control" placeholder="Password" name="userPassword">
          <br>
          <button class="btn btn-theme btn-block" id="loginBtn" type="button" onclick="login()"><i class="fa fa-lock"></i> 로그인</button>
          <hr>
          <div class="registration">
            <a href="./register">회원가입</a>
          </div>
        </div>
      </form>
    </div>
  </div>
  
  <script type="text/javascript">
	$(document).ready(function(){
		$('[name=userId]').on('keypress', function(e){ 
		    if(e.keyCode == '13'){ 
		        $('#loginBtn').click(); 
		    }
		});
		$('[name=userPassword]').on('keypress', function(e){ 
		    if(e.keyCode == '13'){ 
		        $('#loginBtn').click(); 
		    }
		});
	});

	function login(){
		var idVal = $("[name=userId]").val();
	    if(idVal == ""){
	    	alert("아이디를 입력하세요");
	    	$("[name=userId]").focus();
	    	return;
	    }
	    var pwVal = $("[name=userPassword]").val();
	    if(pwVal == ""){
	    	alert("비밀번호를 입력하세요");
	    	$("[name=userPassword]").focus();
	    	return;
	    }
	    document.querySelector("form").submit();
	}
  
	var isLogin = "${isLogin}"
		if(isLogin=="Y"){
			location.href="./memberList"
		}
		if(isLogin=="N"){
			alert("${msg}");
		}
  </script>
</body>
</html>