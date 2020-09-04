<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div>${title}</div>
<form action="<%=request.getContextPath()%>/test" method="GET">
	<form action="/action_page.php">
	  <div class="form-group">
	    <label for="id">아이디</label>
	    <input type="id" class="form-control" placeholder="ID" id="id">
	  </div>
	  <div class="form-group">
	    <label for="pw">비밀번호</label>
	    <input type="password" class="form-control" placeholder="Password" id="pw">
	  </div>
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox"> Remember me
	    </label>
	  </div>
	  <button type="submit" class="btn btn-primary">로그인</button>
	</form>	
	<a class ="signup" href="<%=request.getContextPath() %>/signup"><button type="submit" class="btn btn-primary">회원가입</button></a>
</form>

