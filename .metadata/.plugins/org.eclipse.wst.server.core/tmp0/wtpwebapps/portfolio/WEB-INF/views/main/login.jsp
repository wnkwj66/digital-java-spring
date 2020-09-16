<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1 class="text-header">로그인</h1>
<form action="<%=request.getContextPath()%>/user/login" method="POST">
	<div class="container-info">
		<div class="box-info">
			<div id="login">
				<div class="container">
					<div id="login-row"
						class="row justify-content-center align-items-center">
						<div id="login-column" class="col-md-6">
							<div id="login-box" class="col-md-12">
								<div class="form-group">
									<label for="username" class="text-info">아이디</label><br> 
									<input type="text" name="id" id="username" class="form-control"	placeholder="아이디">
								</div>
								<div class="form-group">
									<label for="password" class="text-info">비밀번호</label><br>
								 	<input type="password" name="pw" id="password" class="form-control"	placeholder="비밀번호">
								</div>
								<div class="form-group">
									<label for="remember-me" class="text-info"> 
									<span>Remember me</span>
									<span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
									<input type="submit" name="submit" class="btn btn-info btn-md" value="로그인">
								</div>
								<div id="register-link" class="text-right">
									<a href="#" class="text-info">아이디 찾기</a>
								</div>
								<div id="register-link" class="text-right">
									<a href="#" class="text-info">비밀번호 찾기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<c:if test="${msg == 'failure'}">
	<div style="color: red">로그인 실패</div>
	<script>
		alert('로그인 실패')
		</script>
</c:if>
