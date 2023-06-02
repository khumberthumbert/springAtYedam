<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원조회</h2>
<a href="empInsert">등록</a>
<!-- GET 방식임. -->

<%-- ${emp} --%>
<form action="empList">
	부서<input name="departmentId" value="${emp.departmentId }">
	fname<input name="firstName" value="${emp.firstName }">
	<button>검색</button>
	<button type="reset">초기화</button>
</form>
<c:forEach items="${empList}" var="emp">
	<div>
	 ${emp.employeeId}, 
	 ${emp.firstName }, 
	 ${emp.lastName }, 
	 ${emp.departmentId }, 
	 ${emp.email }
	<a href="empUpdate?empId=${emp.employeeId}">수정</a>
	<a href="empDelete?empId=${emp.employeeId}">삭제</a></div>
</c:forEach>
</body>
</html>