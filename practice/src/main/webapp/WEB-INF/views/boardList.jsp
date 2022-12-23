<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8" />
<c:set var="path" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="./resources/compnent/jquery-3.3.1.min.js"></script>
<script
	src="./resources/compnent/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>

<script
	src="./resources/compnent/jquery-loading-master/dist/jquery.loading.min.js"></script>
<script src="./resources/compnent/jqueryPrint/jqueryPrint.js"></script>

<script
	src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>

<script src="./resources/js/util/util.js"></script>

<style>
h2 {
	text-align: center;
}

.table {
	
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 0 auto;
}

th, td {
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #04AA6D;
	color: white;
}

.header {
	height: 200px;
}

.search-option {
	
}

ul {
	list-style: none;
	text-align: center;
}

li {
	display: inline-block;
	margin-right: 5px;
}

.pageInfo {
	list-style: none;
	display: inline-block;
	margin: 50px 0 0 100px;
}

.pageInfo li {
	float: left;
	font-size: 20px;
	margin-left: 18px;
	padding: 7px;
	font-weight: 500;
}

a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: black;
	text-decoration: underline;
}

.active {
	background-color: #cdd5ec;
}
</style>
</head>
<body>
	<div class="header">
		<div>
			<h2>메모 게시판</h2>
			<span><a class="logout" href="./logout">Logout</a></span> <span><a
				class="login" href="./login">Login</a></span>
		</div>

		<div class="search_wrap">
			<div class="search_area">
				<ul>
					<li><select name="type">
							<option value=""
								<c:out value="${pageMaker.cri.type == null?'selected':'' }"/>>선택</option>
							<option value="T"
								<c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
							<option value="C"
								<c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
							<option value="W"
								<c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>등록자아이디</option>
							<option value="TC"
								<c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>제목
								+ 내용</option>
							<option value="TW"
								<c:out value="${pageMaker.cri.type eq 'TW'?'selected':'' }"/>>제목
								+ 등록자아이디</option>
							<option value="TCW"
								<c:out value="${pageMaker.cri.type eq 'TCW'?'selected':'' }"/>>제목
								+ 내용 + 등록자아이디</option>
					</select></li>
					<li><input type="text" name="keyword"
						value="${pageMaker.cri.keyword }"></li>
					<li>
						<button id="searchBtn">Search</button>
					</li>
					<li>
						<button onclick="goInsert()" class="">등록</button>
					</li>
					<li>
						<button id="deleteBtn" name="deleteBtn" onclick="goDelete();">삭제</button>
					</li>
					<li>
						<button onclick="goResult()" class="">결과몰아보기</button>
					</li>
				</ul>
			</div>
		</div>

	</div>
	<div class="table">
		<table>
			<thead>
				<tr>
					<th><input type="checkbox" onclick='checkAll(this);' /></th>
					<th>No.</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성일자</th>
					<th>등록일자</th>
					<th>수정일자</th>
					<th>등록아이디</th>
					<th>수정아이디</th>
					<th>등록아이피</th>
					<th>수정아이피</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bd" items="${board}">
					<%--
					String color = "";
					if ("Y".equals(board.getNoticeYN)) {
						color = "yellow";
					}
					--%>

					<tr onclick="goDetail(${bd.boardNum})">
						<td><input type="checkbox" class="list-checkbox"
							name="boardNum" value="${bd.boardNum}"></td>
						<td>${bd.boardNum}</td>
						<c:choose>
						<c:when test="${bd.noticeYN eq 'Y'}">
							<td style="color: red">${bd.boardTitle}</td>
						</c:when>
						<c:otherwise>
							<td>${bd.boardTitle}</td>
						</c:otherwise>
						</c:choose>
						<td>${bd.boardContent}</td>
						<td>${bd.writeDate}</td>
						<td><fmt:formatDate value="${bd.registDate}" type="date" /></td>
						<td><fmt:formatDate value="${bd.updateDate}" type="date" /></td>
						<td>${bd.registId}</td>
						<td>${bd.updateId}</td>
						<td>${bd.registIp}</td>
						<td>${bd.updateIp}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

		<div class="pageInfo_wrap">
			<div class="pageInfo_area">
				<ul id="pageInfo" class="pageInfo">
					<!-- 이전페이지 버튼 -->
					<c:if test="${pageMake.prev}">
						<li class="pageInfo_btn previous"><a
							href="${pageMake.startPage-1}">Previous</a></li>
					</c:if>
					<!-- 각 번호 페이지 버튼 -->
					<c:forEach var="num" begin="${pageMake.startPage}"
						end="${pageMake.endPage}">
						<li class="pageInfo_btn ${pageMake.cri.pageNum == num ? "active":"" }"><a
							href="${num}">${num}</a></li>
					</c:forEach>
					<!-- 다음페이지 버튼 -->
					<c:if test="${pageMake.next}">
						<li class="pageInfo_btn next"><a href="${pageMake.endPage+1}">Next</a></li>
					</c:if>
				</ul>
			</div>
		</div>

		<form id="moveForm" method="get">
			<input type="hidden" name="pageNum" value="${pageMake.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageMake.cri.amount }">
			<input type="hidden" name="keyword" value="${pageMake.cri.keyword }">
			<input type="hidden" name="type" value="${pageMake.cri.type }">
		</form>
	</div>
</body>
<script src="./resources/js/personalHistory/board.js" charset="UTF-8"></script>

<script type="text/javascript">
	function goInsert() {
		location.href="${path}/boardInsertForm";
	}
	
	function goDetail(boardNum){
		location.href="${path}/boardDetail?boardNum="+boardNum;
	}
</script>
</html>