<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
	<button id="test">
		버튼
	</button>
</h1>
</body>
<script type="text/javascript">
	$(function(){
		$('#test').click(function(){
			alert("확인");
		})
	})
</script>
