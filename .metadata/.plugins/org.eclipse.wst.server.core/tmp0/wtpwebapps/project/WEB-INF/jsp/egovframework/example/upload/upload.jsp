<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>파일 업로드</title>
		<%@ include file="../include/header.jsp" %>
	</head>
	<body>
		<%@ include file="../include/nav.jsp" %>
		
		<form name="upload_form" method="post" action="${path}/upload/upload.do" enctype="multipart/form-data">
			<input type="file" name="file" />
			<button type="submit">파일 업로드</button>
		</form>
	</body>
</html>