<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
#login-page {
	text-align: center;
}

.material-symbols-outlined {
	font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48;
	font-size: 180px;
	color: rgb(165, 147, 224);
}

input {
	height: 40px;
	width: 220px;
	border: 0;
	border-radius: 10px;
	outline: none;
	padding-left: 10px;
	background-color: rgba(221, 221, 221, 0.2);
	margin: 5px 0px;
}

.text-h1 {
	magin: 30px 0;
}

.login {
	display: inline-block;
	position: absolute;
	transform: translate(140px, -72px);
}

button {
	height: 40px;
	width: 120px;
	background-color: rgb(165, 147, 224);
	color: #ffffff;
	text-align: center;
	border: 0;
	border-radius: 10px;
	outline: none;
	padding-left: 10px;
}

</style>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<div id="login-page">
		<div class="container">
			<form class="form-login" action="./loginaction" method="post">
				<h1 class="text-h1">Login</h1>
				<br> <br>
				<div class="login-wrap">
					<span class="material-symbols-outlined"> diversity_1 </span><br>
					<div class="loginArea">
						<input type="text" class="form-control" placeholder="ID"
							name="userId" autofocus> <br> <input type="password"
							class="form-control" placeholder="Password" name="userPassword">
						<br>
						<div class="login">
							<button class="loginBtn" id="loginBtn" type="button"
								onclick="login()">Login</button>
						</div>
					</div>
					<hr>
					<div class="registration">
						<a href="./register">SignUp</a>
					</div>
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('[name=userId]').on('keypress', function(e) {
				if (e.keyCode == '13') {
					$('#loginBtn').click();
				}
			});
			$('[name=userPassword]').on('keypress', function(e) {
				if (e.keyCode == '13') {
					$('#loginBtn').click();
				}
			});
		});

		function login() {
			var idVal = $("[name=userId]").val();
			if (idVal == "") {
				alert("아이디를 입력하세요");
				$("[name=userId]").focus();
				return;
			}
			var pwVal = $("[name=userPassword]").val();
			if (pwVal == "") {
				alert("비밀번호를 입력하세요");
				$("[name=userPassword]").focus();
				return;
			}
			document.querySelector("form").submit();
		}

		var isLogin = "${isLogin}"
		if (isLogin == "Y") {
			location.href = "./memberList"
		}
		if (isLogin == "N") {
			alert("${msg}");
		}
	</script>
</body>
</html>