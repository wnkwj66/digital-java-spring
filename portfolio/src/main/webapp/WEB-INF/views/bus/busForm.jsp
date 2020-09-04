<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>원하는 값 입력</title>
</head>
<body>
<form action="/portfolio/bus" method ="POST">
	출발 : <input type ="text" name="depTerminalNm">
	도착 : <input type ="text" name="arrTerminalNm">
	가는날 : <input type ="text" name="depPlandTime">
	오는날 : <input type ="text" name="arrPlandTime">
	<input type = "submit" value= "전송">
</form>
</body>
</html>