<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LIST</title>
</head>

<body>
	<%
	List<HashMap<String, Object>> LIST = (List<HashMap<String, Object>>)request.getAttribute("LIST");
	String HTML = "";
	String HTML2 = "";
	if(LIST == null){
		System.out.println("값이 없음");
		
	}else{
		System.out.println("값이 있음");
		for(int i = 0; i < LIST.size(); i++){
			HTML += "<a href='#'>" ;
			HTML += LIST.get(i).get("번호") + " ) ";
			HTML += LIST.get(i).get("제목");
			HTML += "</a><br>";
		}
	}
		
	%>
	<%= HTML%>
	<%= HTML2%>
</body>
</html>