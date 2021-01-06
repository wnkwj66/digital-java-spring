<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>입력한 값대로 로직 수행하여 출력</title>
</head>
<body>
	<h1>가는날</h1>
	<c:forEach var ="item" items="${go}"> 
		${busVo.depPlaceNm}
		출발지 : ${item.depPlaceNm}<br>
		출발시간 : ${item.depPlandTime }<br>
		도착지: ${item.arrPlaceNm }<br>
		도착시간 : ${item.arrPlandTime }<br>
		가격 : ${item.charge }<br>
		우등석 :${item.gradeNm }<br>
	</c:forEach>
		---------------------------------------------------
	<h1>오는날</h1>
	<c:forEach var ="item" items="${back}">
		출발지 : ${item.arrTerminalNm }<br>
		출발시간 : ${item.arrPlandTime }<br>
		도착지: ${item.depTerminalNm }<br>
		도착시간 : ${item.depPlandTime }<br>
		가격 : ${item.economyCharge }<br>
		우등석 :${item.prestigeCharge }<br>	
	</c:forEach> 

</body>
</html>