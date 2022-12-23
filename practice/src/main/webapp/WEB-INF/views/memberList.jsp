<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>    
<c:set var="path" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="./resources/compnent/jquery-3.3.1.min.js"></script>
	<script src="./resources/compnent/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	
	<script src="./resources/compnent/jquery-loading-master/dist/jquery.loading.min.js"></script>
	<script src="./resources/compnent/jqueryPrint/jqueryPrint.js"></script>

	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
	
	<script src="./resources/js/util/util.js"></script>

<style>
h2 {
	text-align: center;
}
.table {
	
}
table {
  border-collapse: collapse; width: 80%; margin: 0 auto;
}

th, td {
  text-align: center; padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D; color: white;
}
.header {
	height: 200px;  
}
.search-option {
	
}

ul {
	list-style: none; text-align: center;
	
}
li {
	display: inline-block; margin-right: 5px; 
	
}

 .pageInfo{
      list-style : none;
      display: inline-block;
    margin: 50px 0 0 100px;      
  }
  .pageInfo li{
      float: left;
    font-size: 20px;
    margin-left: 18px;
    padding: 7px;
    font-weight: 500;
  }
 a:link {color:black; text-decoration: none;}
 a:visited {color:black; text-decoration: none;}
 a:hover {color:black; text-decoration: underline;}
 .active{
      background-color: #cdd5ec;
  }
</style>
</head>
<body>
<div class="header">
	<div>
		<h2>회원 리스트</h2>
	</div>
	<a class="logout" href="./logout">Logout</a>
	<a class="goBoard" href="./boardList">게시판이동</a> 
</div>
<div class="table">     
    <table>
      <thead>
        <tr>
          <th>회원 번호</th>
          <th>회원명</th>
          <th>아이디</th>
          <th>패스워드</th>
          <th>이메일</th>
          <th>권한</th>
          <th>주소</th>
          <th>성별</th>
          <th>전화번호</th>
          <th>등록일</th>
          <th>수정일</th>
          <th>아이피주소</th>
        </tr>
      </thead> 
      <tbody>
      <c:forEach var="mem" items="${member}">
        <tr onclick="goDetail(${mem.userIdx})">
          <td>${mem.userIdx}</td>
          <td>${mem.userName}</td>
          <td>${mem.userId}</td>
          <td>${mem.userPassword}</td>
          <td>${mem.userEmail}</td>
 		  <td>${mem.userAuth}</td>
 		  <td>${mem.userAddress}</td>
 		  <td>${mem.userSex}</td>
 		  <td>${mem.userPhoneNumber}</td>
 		  <td><fmt:formatDate value="${mem.userRegistDate}" type="date"/></td>
 		  <td><fmt:formatDate value="${mem.userUpdateDate}" type="date"/></td>
 		  <td>${mem.userIp}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
		
    
</div>
</body>

<script type="text/javascript">
	
</script>
</html>