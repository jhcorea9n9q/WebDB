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
	String BoardNo = request.getAttribute("번호").toString(); 
	String HTML = "";
	String HTML2 = "";
	
	if(LIST != null) {
		
		for(int i = 0; i < LIST.size(); i++){
			HTML += "<a href='List?번호=" + LIST.get(i).get("번호") + "'>" ;
			HTML += LIST.get(i).get("번호") + " ) ";
			HTML += LIST.get(i).get("제목");
			HTML += "</a><br>";
		}
		
		if (BoardNo != null) {
			System.out.println(BoardNo);
			for (int i = 0; i < LIST.size(); i++) {
				if (BoardNo.equals(LIST.get(i).get("번호").toString())) {
					HTML2 = LIST.get(i).get("내용").toString();
				}
			}
		}
		
	}
		
	%>
	
	<p><a href="Insert.jsp"> 글작성 </a></p>
	
	<%= HTML%>
	<%= HTML2%>
</body>
</html>