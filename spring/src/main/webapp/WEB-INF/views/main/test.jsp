<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div>${title}</div>
<form action="<%=request.getContextPath()%>/test" method="GET">
	<input type="text" name="id" placeholder="아이디">
	<input type="password" name ="pw" placeholder="비밀번호">
	
	<button type="submit">전송</button>
</form>

