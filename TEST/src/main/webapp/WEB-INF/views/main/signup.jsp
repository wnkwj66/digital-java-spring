<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<form method="post" action="<%=request.getContextPath()%>/signup">
<div class="container-body">
		<div class="logo">
			<a href="//naver.com">NAVER</a>
		</div>
		<div class="container-id">
			<div class="text-id">아이디</div>
			<div class="box-id">
				<input type="text" name="id" id="id">
				<label for="id"></label>
			</div>
			<label id="id-error" class="error" for="id"></label>
			<div class="dup-fail-msg display-none">이미 사용중이거나 탈퇴한 아이디입니다.</div>
			<div class="dup-suc-msg display-none">멋진 아이디네요!</div>
		</div>
		<div class="container-pw">
			<div class="text-pw">비밀번호</div>
			<div class="box-pw">
				<input type="password" name="pw" id="pw">
				<a href="#"></a>
			</div>
			<label id="pw-error" class="error" for="pw"></label>
		</div>
		<div class="container-pw">
			<div class="text-pw">비밀번호 확인</div>
			<div class="box-pw">
				<input type="password" name="pw2" id="pw2">
				<a href="#"></a>
			</div>
			<label id="pw2-error" class="error" for="pw2"></label>
		</div>
		<div class="container-gender">
			<div class="text-gender">성별</div>
			<div class="box-gender">
				<select name="gender" id="gender">
					<option value="">성별</option>
					<option value="male">남자</option>
					<option value="female">여자</option>
				</select>
			</div>
		</div>
		<label id="gender-error" class="error" for="gender"></label>
		<div class="container-email">
			<div class="text-bold">본인확인 이메일 <span class="text-small"></span></div>
			<div class="box-email">
				<input type="text" name="email" id="email">
			</div>
			<label id="email-error" class="error" for="email"></label>
		</div>
		<button class="btn-submit">가입하기</button>
	</div>
</form>