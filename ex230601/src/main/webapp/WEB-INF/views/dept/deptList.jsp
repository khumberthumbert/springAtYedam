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
<h2>부서조회</h2>
<a href="deptInsert">부서등록</a>
<!-- GET 방식임. -->

<%-- ${emp} --%>
<form action="deptList">
	부서<input name="departmentId" value="${dept.departmentId }">
	부서이름<input name="firstName" value="${dept.departmentName }">
	<button>검색</button>
	<button type="reset">초기화</button>
</form>
<c:forEach items="${deptList}" var="dept">
	<div>
	 ${dept.departmentId}, 
	 ${dept.departmentName }, 
	 ${dept.managerId }, 
	 ${dept.locationId }
	</div>
</c:forEach>
</body>
</html>