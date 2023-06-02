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
<h3>사원등록</h3>
<form action="empInsert" method="post">
	firstName<input name="firstName"><br>
	lname *<input name="lastName"><br>
	hireDate *<input name="hireDate"><br>
	email *<input name="email"><br>
	
	departmentId
	<c:forEach items="${depts }" var="dept">
		<input type="radio" name="departmentId" 
		value="${dept.departmentId }">${dept.departmentName }
	</c:forEach>
	
	jobId *<select name="jobId">
	<option value="">--선택--</option>
	<c:forEach items="${jobs}" var="job">
		<option value="${job.jobId}">${job.jobTitle}</option>
	</c:forEach>
	</select><br>
	<button>저장</button>
</form>
</body>
</html>