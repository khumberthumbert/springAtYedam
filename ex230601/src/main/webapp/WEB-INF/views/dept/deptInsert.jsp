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
<h3>부서등록</h3>
<form action="empInsert" method="post">
	DepartmentName<input name="departmentName"><br>
	ManagerId *<input name="managerId"><br>
	LOCATION_ID *<input name="locationId"><br>
	
	departmentId
	<c:forEach items="${depts }" var="dept">
		<input type="radio" name="departmentId" 
		value="${dept.departmentId }">${dept.departmentName }
	</c:forEach>
	
	DepartmentId *<select name="departmentId">
	<option value="">--선택--</option>
	<c:forEach items="${depts}" var="job">
		<option value="${job.jobId}">${job.jobTitle}</option>
	</c:forEach>
	</select><br>
	<button>저장</button>
</form>
</body>
</html>