<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form name="updateForm" action="boardUpdate" method="POST" onsubmit="return false">
		<div>
			<h3>게시글 수정</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${board.bno}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${board.title }" ></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${board.writer }" ></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${board.contents }</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="text" name="image" value="${board.image }" ></td>
			</tr>
			<tr>
				<th>수정날짜</th>
				<td><input type="date" name="updatedate" 
						value='<fmt:formatDate value="${board.updatedate }" pattern="yyyy-MM-dd"/>'></td>
				<!-- <td><input type="date" name="updatedate" value="${board.updatedate}"></td> -> 데이터가 사라진 것은 아니다. 
				input태그는 타입별로 인식하는 방식이 다르다. input이 가질 수 있는 포맷이 지정된다. -->
			</tr>
		</table>
		<button type="submit">수정완료</button>
		<button type="button" onclick="location.href='boardInfo?bno=${board.bno}'">취소</button>
	</form>
	<script>
		//이벤트 객체를 받을 것이면, e로 매개변수를 넣는다.
		function updateAjax(e){
			//form이 가지고 있는 데이터를 어떻게 처리 할지가 고민포인트.
			//form태그는 데이터를 모으는 역할로 많이 사용한다. 내부에 몇개의 데이터가 있든 한꺼번에 가져올 수 있음.
			let boardData = new FormData(document.querySelector("[name='updateForm']"));
			
			//여기서 객체형태로 가지만 json 타입아니라는 것을 기억.
			fetch(updateForm.action, {
				method : 'post',
				body : boardData //Form으로 값을 받아온 것 그대로 보낸다는 뜻임.
			})
			.then(response => response.json()) //돌아온 형태는 json으로 될 테니 파싱 해줘야함.
			.then(data => {
				let message = '결과 : ' + data.result
							  + ', 게시글 번호 : ' + data['board_no'];
			    alert(message);
			})			
			.catch(err => console.log(err));
		}
		document.querySelector('button[type="submit"]')
				.addEventListener('click', updateAjax);
	</script>
</body>
</html>