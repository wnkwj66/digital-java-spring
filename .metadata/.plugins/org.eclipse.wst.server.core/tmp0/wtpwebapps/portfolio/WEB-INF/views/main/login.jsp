<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1 class="text-header">
	로그인
</h1>
	<form action="<%=request.getContextPath()%>/user/login" method="POST">
		<div class="form-group">
			<input class="form-control" type="text" name="id" placeholder="아이디" >
		</div>
		<div class="form-group">
			<input class="form-control" type="password" name="pw" placeholder="비밀번호">
		</div>
		<button class="btn btn-success col-12" id="enter">로그인</button>
	</form>
	<c:if test="${msg == 'failure'}">
		<div style="color:red">
			로그인 실패
		</div>
		<script >
		alert('로그인 실패')
		</script>
	</c:if>
