<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

	<script src="./resources/compnent/jquery-3.3.1.min.js"></script>
	<script src="./resources/compnent/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	
	<script src="./resources/compnent/jquery-loading-master/dist/jquery.loading.min.js"></script>
	<script src="./resources/compnent/jqueryPrint/jqueryPrint.js"></script>

	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
	
	<script src="./resources/js/util/util.js"></script>
	
	<script src="./resources/js/personalHistory/personalHistory.js" charset="UTF-8"></script>
	<script src="./resources/js/personalHistory/personalHistoryFunc.js" charset="UTF-8"></script>
	<script src="./resources/js/personalHistory/list.js" charset="UTF-8"></script>
	
	<link rel="stylesheet" type="text/css" href="./resources/compnent/jquery-ui-1.12.1.custom/jquery-ui.min.css">
	<link rel="stylesheet" type="text/css" href="./resources/compnent/jquery-loading-master/dist/jquery.loading.min.css">
	
<!-- 
<link rel="stylesheet" type="text/css" href="./resources/css/personalHistory/personalHistory.css?ver=1">
 -->	<link rel="shortcut icon" href="#">

	<title>list</title>
	<style type="text/css">
	
	#pop{
		width:300px; height:400px; background:#3d3d3d; color: #fff;
		position: absolute; top: 10px; left: 100px; text-align: center;
		border: 2px solid #000;
	}
	
	#section{
		text-align: center;
	}
	
	#section > .pop-register-list-pannel2 > .pop-register-list2 {
		margin: auto; 
		width: 90%;
	}
	
	
	th {
		background-color: gray;
	}
	
	th, td {
	  padding: 8px;
	  text-align: center;
	  border-bottom: 1px solid #ddd;
	}
	
	.tbody-tr:hover {background-color: #efefef;}
	

	.header {
		position: absolute;
		display: block;
		width: 100%;
		margin-top: 50px;
	}
	
	.header > .header-text {
		position: relative;
		display: inline-block;
		text-align: left;
		margin-right: 850px;
	}
	
	.header > .header-search {
		position: relative;
		display: inline-block;
		text-align: right;
	}
	
	.search {
		display: inline-block;
	}
	
	.pop-register-list-pannel2 {
		margin-top: 50px;
	}
	span {
		font-size: 24px;
	}
	</style>
</head>
<body>

	<section id="section">
	<div class="header">
		<div class="header-text">
			<span>개인 이력 List Page</span>
		</div>
		
		<!-- 
		<form action="/prac_kkw/detail" id="detailFrm" name="detailFrm" method="post">
			<input type="hidden" id="userIdx" name="userIdx">
		</form>
		 -->
		
		<div class="header-search">
		
		<!-- <form action="userList.do" id="frm" name="frm" method="post" class="search">  -->
			<input type="hidden" id="userInfoTotalCnt" name="userInfoTotalCnt" value="21">
			<input type="hidden" id="userDelete" name="userDelete" value="">
			<input type="hidden" id="userInfoPageSize" name="userInfoPageSize" value="10">
			<input type="hidden" id="userInfoPageNo" name="userInfoPageNo" value="">
			
			<input type="hidden" id="prevLimit" name="prevLimit">
			<input type="hidden" id="laterLimit" name="laterLimit">
			
			<select id="userListSearchPeriod">
				<option value="">검색조건</option>
				<option value="userName">이름</option>
				<option value="userComp">소속회사</option>
				<option value="userDept">부서</option>
				<option value="careerDate">경력</option>
				<option value="userAddress">주소</option>
			</select>
		
			<input type="text" id="userListSearchWord" name="userListSearchWord" value="">
			
			<!-- <button id="userListSearchBtn" class="user-list-search-btn">검색</button> -->
			<button id="userListSearchBtn" class="user-list-search-btn">검색</button>
		<!-- </form> -->
		</div>
	</div>
	<br>
	<button id="insertBtn" name="insertBtn" onclick="goInsert('');">등록</button>	

		<button id="deleteBtn" name="deleteBtn" onclick="goDelete();">삭제</button>
	<div class="pop-register-list-pannel2">
		<table class="pop-register-list2" style="text-align: center">
			<thead>
				<tr>
					<td><input type="checkbox" onclick='checkAll(this);'/></td> 
					<td>등록번호</td>
					<td>이름</td>
					<td>소속회사</td>
					<td>부서</td>
					<td>성별</td> 
					<td>경력</td>
					<td>등록날짜</td>
				</tr>
			</thead>
			<tbody> 
			<c:forEach var="list" items="${listPage}">
				<tr ondblclick="goDetail(${list.userIdx})" class="tbody-tr">
					<td><input type="checkbox" class="list-checkbox" name="userIdx" value="${list.userIdx}"/></td>
					<td name="">${list.userIdx}</td>
					<td>${list.userName}</td>
					<td>${list.userComp}</td>
					<td>${list.userDept}</td>
					<td>${list.userSex}</td>
					<td>${list.careerDate}</td>
					<td>${list.userregisterdate}</td> 
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="pop-paging-pannel2">
			
		</div>
	</div>
	</section>
</body>
</html>
