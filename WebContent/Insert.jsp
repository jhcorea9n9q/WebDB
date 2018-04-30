<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 작성</title>
</head>

<body>

	<h1>글작성 하기</h1>
	
	<form action="Insert">
		<input type="text" name="제목" placeholder="제목입력→">
		<input type="text" name="내용" placeholder="내용입력→">
		<input type="submit" value="저장하기">
	</form>

</body>
</html>