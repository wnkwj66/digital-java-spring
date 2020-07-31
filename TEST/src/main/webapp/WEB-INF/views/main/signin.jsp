<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>
로그인
</h1>
<form  action="<%=request.getContextPath()%>/signin" method="POST">
	<div class="form-group">
		<input class="form-control" type="text" name="id" placeholder="아이디">
	</div>
	<div class="form-group">
		<input class="form-control" type="password" name="pw" placeholder="비밀번호">
	</div>
	<button class="btn btn-success col-12">로그인</button>
</form>