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

<link rel="shortcut icon" href="#">
</head>
<body>
	<section class="wrapper">
		<br>
		<h3>
			<i class="fa fa-angle-right"></i> 회원 가입 <i class="fa fa-angle-right"></i>
			회원 정보 입력
		</h3>
		<form class="form-horizontal style-form" enctype="multipart/form-data"
			action="./insertMember" method="post">
			<!-- 회원 정보 -->
			<div class="row mt">
				<div class="col-lg-12">
					<div class="form-panel">
						<h4 class="mb">
							<i class="fa fa-angle-right"></i> 회원 정보
						</h4>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"> 아이디*</label>
							<div class="col-sm-5">
								<div class="form-inline">
									<input type="text" class="form-control" name="userId">
									<!--  -->
									<input type="button" class="btn btn-theme03" name="idDuplConfirm" value="중복 확인">

									<span class="help-block">* 아이디를 8자 이상, 16자 이하로 입력해주세요.</span> <input
										type="hidden" name="idConfirm" value="idUncheck">
									<h5 id="idMsg"></h5>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"> 비밀번호*</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" name="userPassword">
								<span class="help-block">* 비밀번호를 8자 이상, 16자 이하로 입력해주세요.</span>
								<h5 id="pwMsg"></h5>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"> 비밀번호 확인*</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" name="pw_confirm">
								<span class="help-block">* 위 비밀번호와 같은 값을 입력해주세요.</span>
								<h5 id="pw_confirmMsg"></h5>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"> 이름*</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" name="userName">
							</div>
						</div>

					</div>
				</div>

				<!-- 연락처 정보 -->
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label"> 주소</label>
					<div class="col-sm-5">
						<input type="text" id="sample6_postcode" placeholder="우편번호" name="userAddress">
						<input type="button" onclick="sample6_execDaumPostcode()"
							value="우편번호 찾기"><br> 
						<input type="text" id="sample6_address" placeholder="주소" name="userAddress"><br> 
						<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="userAddress">

						<script
							src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
						<script>
							function sample6_execDaumPostcode() {
								new daum.Postcode(
										{
											oncomplete : function(data) {
												// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

												// 각 주소의 노출 규칙에 따라 주소를 조합한다.
												// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
												var addr = ''; // 주소 변수
												var extraAddr = ''; // 참고항목 변수

												//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
												if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
													addr = data.roadAddress;
												} else { // 사용자가 지번 주소를 선택했을 경우(J)
													addr = data.jibunAddress;
												}

												// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
												if (data.userSelectedType === 'R') {
													// 법정동명이 있을 경우 추가한다. (법정리는 제외)
													// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
													if (data.bname !== ''
															&& /[동|로|가]$/g
																	.test(data.bname)) {
														extraAddr += data.bname;
													}
													// 건물명이 있고, 공동주택일 경우 추가한다.
													if (data.buildingName !== ''
															&& data.apartment === 'Y') {
														extraAddr += (extraAddr !== '' ? ', '
																+ data.buildingName
																: data.buildingName);
													}
											

												} 
												// 우편번호와 주소 정보를 해당 필드에 넣는다.
												document
														.getElementById('sample6_postcode').value = data.zonecode;
												document
														.getElementById("sample6_address").value = addr;
												// 커서를 상세주소 필드로 이동한다.
												document
														.getElementById(
																"sample6_detailAddress")
														.focus();
											}
										}).open();
							}
						</script>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label"> 성별*</label>
					<div class="col-sm-5">
						<select name="userSex">
							<option value="남자">남자</option>
							<option value="여자">여자</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label"> 이메일*</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="userEmail">
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label"> 핸드폰번호</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="userPhoneNumber">
					</div>
				</div>
		</form>
		<!-- /row -->
		<!-- col-lg-12-->
		<br> <input type="button" class="btn btn-default"
			onclick="check()" value="가입 완료">
	</section>

</body>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="./resources/js/personalHistory/register.js" charset="UTF-8"></script>
</html>